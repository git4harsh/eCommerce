package com.peronal.project.ecomApp.ecomPrj.controllers;

import com.peronal.project.ecomApp.ecomPrj.models.Product;
import com.peronal.project.ecomApp.ecomPrj.services.ProductService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/replace/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product delProductById(@PathVariable("id") Long id){
        return productService.delProduct(id);
    }

    @ExceptionHandler({RuntimeException.class, NullPointerException.class})
    //Debug this to log but just give "Something went wrong" to user
    public ResponseEntity<String> handleException(){
        System.out.println("Something went Wrong");
        return new ResponseEntity<>("Something ent Wrong", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexOutOfBoundException(){
        //Debug this to log but just give "Something went wrong" to user
        System.out.println("Index out of bounds");
        return new ResponseEntity<>("Something ent Wrong", HttpStatus.NOT_FOUND);
    }

}
