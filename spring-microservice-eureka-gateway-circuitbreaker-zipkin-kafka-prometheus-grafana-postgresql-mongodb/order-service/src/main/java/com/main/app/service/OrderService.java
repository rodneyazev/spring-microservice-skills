package com.main.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.main.app.dto.InventoryResponse;
import com.main.app.dto.OrderLineItemsDto;
import com.main.app.dto.OrderRequest;
import com.main.app.event.OrderPlacedEvent;
import com.main.app.model.Order;
import com.main.app.model.OrderLineItems;
import com.main.app.repository.OrderRepository;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final WebClient.Builder webClientBuilder;
	private final ObservationRegistry observationRegistry;
	private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

	public String placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
			.stream().map(this::mapToDto).toList();
		
		order.setOrderLineItemsList(orderLineItems);
		
		List<String> skuCodes = order.getOrderLineItemsList().stream()
				.map(OrderLineItems::getSkucode).toList();
		
		// Call inventory service, and place order if product is in stock		
		
		Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup",this.observationRegistry);
		inventoryServiceObservation.lowCardinalityKeyValue("call", "inventory-service");
		
        return inventoryServiceObservation.observe(() -> {	

			InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
					//.uri("http://inventory-service/api/inventory",
					.uri("http://inventory-service:8080/api/inventory",
							uriBuilder -> uriBuilder.queryParam("skucode", skuCodes).build())
					.retrieve()
					.bodyToMono(InventoryResponse[].class)
					.block();
			
			boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
					.allMatch(InventoryResponse::isInStock);
			
			if(allProductsInStock) {
				orderRepository.save(order);
				kafkaTemplate.send("notification_topic", new OrderPlacedEvent(order.getOrderNumber()));
				return "Order placed successfully.";
			} else {
				throw new IllegalArgumentException("Product is not in stock, please try again later");
			}
        });
					
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkucode(orderLineItemsDto.getSkucode());
        return orderLineItems;
    }
}
