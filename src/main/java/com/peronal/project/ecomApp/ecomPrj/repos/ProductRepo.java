package com.peronal.project.ecomApp.ecomPrj.repos;

import com.peronal.project.ecomApp.ecomPrj.models.Product;
import com.peronal.project.ecomApp.ecomPrj.projections.ProductWithTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long Id);
    @Override
    Product save(Product product); //both create and update it will do

    void delete(Product product);

    //HQL Query
    @Query("select p.title as title, p.description as desc from Product p where p.id=:id")
    ProductWithTitleAndDesc someRandomQuery(@Param("id") Long id);

    //SQL Query
    @Query(value = "select title, description from Product where id=:id", nativeQuery = true)
    ProductWithTitleAndDesc someRandomQuery1(@Param("id") Long id);
}
