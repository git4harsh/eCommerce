package com.peronal.project.ecomApp.ecomPrj.repos;

import com.peronal.project.ecomApp.ecomPrj.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long Id);
    @Override
    Product save(Product product); //both create and update it will do

    void delete(Product product);
}
