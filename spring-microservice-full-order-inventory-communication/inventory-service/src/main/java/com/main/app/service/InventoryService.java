package com.main.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.app.dto.InventoryResponse;
import com.main.app.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skucode) {
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
