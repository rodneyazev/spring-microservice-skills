package com.main.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.app.dto.InventoryResponse;
import com.main.app.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	@SneakyThrows
	public List<InventoryResponse> isInStock(List<String> skucode) {
		log.info("Checking Inventory");
		return
			inventoryRepository.findBySkucodeIn(skucode)
				.stream().map(inventory ->
					InventoryResponse.builder()
						.skucode(inventory.getSkucode())
						.isInStock(inventory.getQuantity() > 0)
						.build()
				).toList();
	}

}
