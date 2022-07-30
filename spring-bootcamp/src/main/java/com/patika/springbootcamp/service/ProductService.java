package com.patika.springbootcamp.service;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.mapper.ProductMapper;
import com.patika.springbootcamp.repository.ProductRepository;
import com.patika.springbootcamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> allCourses = productMapper.toProductDTOs(productRepository.findAll());
        return allCourses;
    }

    public ProductDTO getById(Long id) {
        Product byId = productRepository.findProductById(id);
        ProductDTO byIdDTO = productMapper.toProductDTO(byId);
        return byIdDTO;
    }

    public Product create(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        getById(id);
        productRepository.deleteById(id);
    }

    public Product update(String title, Product product) {
        Optional<Product> productByTitle = productRepository.findProductByTitle(title);
        if (!productByTitle.isPresent())
            return null;
        Product updatedProduct = productByTitle.get();

        //  if (!StringUtils.isEmpty(product.getTitle())) {
        //    updatedProduct.setTitle(product.getTitle());
        // }
        //  if (!StringUtils.isEmpty(product.getDetails())) {
        //    updatedProduct.setDetails(product.getDetails());
        // }

        return productRepository.save(updatedProduct);
    }

}
