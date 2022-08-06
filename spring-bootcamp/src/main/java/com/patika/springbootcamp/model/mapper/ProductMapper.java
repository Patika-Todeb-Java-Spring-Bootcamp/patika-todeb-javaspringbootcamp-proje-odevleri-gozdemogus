package com.patika.springbootcamp.model.mapper;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOList(List<Product> list);
    List<Product> toProductList(List<ProductDTO> list);

    Product toProduct(ProductDTO productDTO);

}
