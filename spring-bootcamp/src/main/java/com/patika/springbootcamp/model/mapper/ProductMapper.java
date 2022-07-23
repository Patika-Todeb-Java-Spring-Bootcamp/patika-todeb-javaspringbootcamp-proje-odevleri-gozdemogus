package com.patika.springbootcamp.model.mapper;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDetails(product.getDetails());
        productDTO.setBrand(product.getBrand());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDetails(productDTO.getDetails());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        return product;
    }

}
