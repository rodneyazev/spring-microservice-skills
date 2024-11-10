package com.main.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.app.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySkucode(String skucode);

}
