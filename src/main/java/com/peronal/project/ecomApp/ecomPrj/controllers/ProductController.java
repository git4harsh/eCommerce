package com.peronal.project.ecomApp.ecomPrj.controllers;

import com.peronal.project.ecomApp.ecomPrj.models.Product;
import com.peronal.project.ecomApp.ecomPrj.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProdById(@PathVariable("id") Long id){
        return productService.getProdById(id);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product delProductById(@PathVariable("id") Long id){
        return productService.delProduct(id);
    }

}
