package com.peronal.project.ecomApp.ecomPrj.services;

import com.peronal.project.ecomApp.ecomPrj.models.Category;
import com.peronal.project.ecomApp.ecomPrj.models.Product;
import com.peronal.project.ecomApp.ecomPrj.repos.CategoryRepo;
import com.peronal.project.ecomApp.ecomPrj.repos.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService{

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo,CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProdById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()){
            throw new EntityNotFoundException("Product was not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(categoryRepo.findByTitle(category.getTitle()) == null){
            Category saveCategory = categoryRepo.save(category);
            product.setCategory(saveCategory);
        }
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product delProduct(Long id) {
        return null;
    }
}
