package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/{skucode}")
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@PathVariable("skucode") String skucode) {
		return inventoryService.isInStock(skucode);
	}
	
}
