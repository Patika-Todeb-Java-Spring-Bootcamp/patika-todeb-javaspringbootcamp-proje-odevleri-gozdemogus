package com.patika.springbootcamp.controller;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.mapper.ProductMapper;
import com.patika.springbootcamp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Tag(name="Product", description="Includes product CRUD operations")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;


    @GetMapping(path = "/all")
    @Operation(summary = "Get all products", method="GET")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        ProductDTO byIdDTO;
        try {
            byIdDTO = productService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byIdDTO);
    }

    @PostMapping("/create")
    public ResponseEntity createNewProduct(@RequestBody ProductDTO productDTO) {
        Product respProduct = productService.create(productDTO);
        if (respProduct == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Product could not be created..");
        }
        // ProductDTO productDTO2 = productMapper.toProductDTO(respProduct);
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
            @RequestBody Product product) {
        Product update = productService.update(title, product);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Product could not be updated..");
        }
        ProductDTO productDTO = productMapper.toProductDTO(update);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }


}
