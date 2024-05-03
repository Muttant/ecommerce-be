package com.tutorial.ecommerce_be.api.controller.product;

import com.tutorial.ecommerce_be.model.Product;
import com.tutorial.ecommerce_be.model.dao.ProductDAO;
import com.tutorial.ecommerce_be.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
