package com.main.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.app.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
