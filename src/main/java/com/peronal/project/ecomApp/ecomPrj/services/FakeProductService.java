package com.peronal.project.ecomApp.ecomPrj.services;

import com.peronal.project.ecomApp.ecomPrj.dto.FakeStoreProductDto;
import com.peronal.project.ecomApp.ecomPrj.models.Category;
import com.peronal.project.ecomApp.ecomPrj.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.util.ArrayList;
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

        List<FakeStoreProductDto> fakeStoreProductDtolist = restTemplate.exchange("https://fakestoreapi.com/products"
                ,HttpMethod.GET
                ,null
                ,new ParameterizedTypeReference<List<FakeStoreProductDto>>() {}
        ).getBody();

        List<Product> productsList = new ArrayList<>();
        for( FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtolist){
            Product product = convertToProduct(fakeStoreProductDto);
            productsList.add(product);
        }
        return productsList;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertToDto(product);
        fakeStoreProductDto = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreProductDto, FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public Product udpateProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertToDto(product);
        fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/" + product.getId()
                                                            ,fakeStoreProductDto
                                                            , FakeStoreProductDto.class);
        return convertToProduct(fakeStoreProductDto);
    }

    @Override
    public Product delProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.exchange("https://fakestoreapi.com/products/" + id
                                                                            ,HttpMethod.DELETE
                                                                            ,null
                                                                            ,FakeStoreProductDto.class).getBody();
        return convertToProduct(fakeStoreProductDto);
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

    public static FakeStoreProductDto convertToDto(Product product) {
        if (product == null) {
            return null;
        }

        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        // Convert the Category object to a category string
        if (product.getCategory() != null) {
            dto.setCategory(product.getCategory().getTitle());
        }

        return dto;
    }
}
