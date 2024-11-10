package com.main.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
