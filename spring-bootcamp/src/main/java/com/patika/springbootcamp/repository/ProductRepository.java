package com.patika.springbootcamp.repository;


import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    // JPQL
    Optional<Product> findProductByTitle(String title);

    Product findProductById(Long id);

    //   List<Optional<Product>> findAllByTitleAndPrice(String title);

    // Native SQL
    //   @Query("SELECT p FROM Product p WHERE p.title = :title AND p.price = :price")
    //   List<Product> getAllByTitleAndPriceNative(String title, Double price);


}
