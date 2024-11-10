package com.main.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.main.app.model.Inventory;
import com.main.app.repository.InventoryRepository;

@SpringBootApplication
public class SpringMicroserviceInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceInventoryApplication.class, args);
	}
	@Bean
	CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkucode("iphone_15");
			inventory.setQuantity(100);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkucode("iphone_15_black");
			inventory1.setQuantity(0);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
