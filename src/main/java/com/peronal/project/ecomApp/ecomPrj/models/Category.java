package com.peronal.project.ecomApp.ecomPrj.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Category extends BaseModel{

    private String title;

    @OneToMany
    private List<Product> productList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
