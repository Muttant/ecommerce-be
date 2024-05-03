package com.tutorial.ecommerce_be.model.dao;

import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {
    List<WebOrder> findByUser(LocalUser user);
}
