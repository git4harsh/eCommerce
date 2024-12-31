package com.peronal.project.ecomApp.ecomPrj.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category extends BaseModel{

    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
