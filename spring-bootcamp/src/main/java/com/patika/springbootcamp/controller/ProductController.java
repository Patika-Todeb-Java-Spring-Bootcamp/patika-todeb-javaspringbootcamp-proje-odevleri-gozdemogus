package com.patika.springbootcamp.controller;

import com.patika.springbootcamp.model.dto.ProductDTO;

import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Product byId;
        try {
            byId = productService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewProduct(@RequestBody ProductDTO productDTO) {
        Product respProduct = productService.create(productDTO);
        if (respProduct == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Course could not be created..");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respProduct);
    }


    // pathvariable ok requestparam x
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable(name = "id") Long id) {
        try {
            productService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @PutMapping("/{title}")
    public ResponseEntity updateProduct(
            @PathVariable String title,
            @RequestBody ProductDTO course) {
        Product update = productService.update(title, course);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Product could not be updated..");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }


}
