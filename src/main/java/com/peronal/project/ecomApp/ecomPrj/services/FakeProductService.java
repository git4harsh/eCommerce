package com.peronal.project.ecomApp.ecomPrj.services;

import com.peronal.project.ecomApp.ecomPrj.dto.FakeStoreProductDto;
import com.peronal.project.ecomApp.ecomPrj.models.Category;
import com.peronal.project.ecomApp.ecomPrj.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService {

    private final RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProdById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Long id) {
        return null;
    }

    @Override
    public Product udpateProduct(Long id) {
        return null;
    }

    @Override
    public Product delProduct(Long id) {
        return null;
    }

    private Product convertToProduct(FakeStoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Convert the category string to a Category object
        Category category = new Category();
        category.setTitle(dto.getCategory());
        // Optionally set an ID or leave it as default
        product.setCategory(category);

        return product;
    }
}
