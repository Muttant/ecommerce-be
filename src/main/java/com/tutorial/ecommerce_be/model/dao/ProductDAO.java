package com.tutorial.ecommerce_be.model.dao;

import com.tutorial.ecommerce_be.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
