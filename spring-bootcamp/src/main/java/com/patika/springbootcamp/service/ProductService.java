package com.patika.springbootcamp.service;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.entity.User;
import com.patika.springbootcamp.model.mapper.ProductMapper;
import com.patika.springbootcamp.repository.ProductRepository;
import com.patika.springbootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public List<Product> getAllProducts() {
        List<Product> allCourses = productRepository.findAll();
        return allCourses;
    }

    public Product getById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException(" not found!"));
    }

    public Product create(ProductDTO productDTO) {
        Product course = ProductMapper.toEntity(productDTO);
        return productRepository.save(course);
    }

    public void delete(Long id) {
        getById(id);
        productRepository.deleteById(id);
    }

    public Product update(String title, ProductDTO productDTO) {
        Optional<Product> productByTitle = productRepository.findProductByTitle(title);
        if (!productByTitle.isPresent())
            return null;
        Product updatedProduct = productByTitle.get();
        if (!StringUtils.isEmpty(productDTO.getTitle())) {
            updatedProduct.setTitle(productDTO.getTitle());
        }
        if (!StringUtils.isEmpty(productDTO.getDetails())) {
            updatedProduct.setDetails(productDTO.getDetails());
        }

        return productRepository.save(updatedProduct);
    }

}
