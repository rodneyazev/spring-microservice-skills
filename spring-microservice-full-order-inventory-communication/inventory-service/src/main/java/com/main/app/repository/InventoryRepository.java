package com.main.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.app.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findBySkucodeIn(List<String> skucode);

}
