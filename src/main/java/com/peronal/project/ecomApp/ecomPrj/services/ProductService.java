package com.peronal.project.ecomApp.ecomPrj.services;

import com.peronal.project.ecomApp.ecomPrj.models.Product;

import java.util.List;

public interface ProductService {

    Product getProdById(Long id);
    List<Product> getAllProducts();

    Product createProduct(Product product);
    Product udpateProduct(Product product);
    Product delProduct(Long id);
}
