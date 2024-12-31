package com.peronal.project.ecomApp.ecomPrj.repos;

import com.peronal.project.ecomApp.ecomPrj.models.Category;
import com.peronal.project.ecomApp.ecomPrj.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long Id);
    @Override
    Category save(Category category); //both create and update it will do

    void delete(Category category);

    Category findByTitle(String title);
}
