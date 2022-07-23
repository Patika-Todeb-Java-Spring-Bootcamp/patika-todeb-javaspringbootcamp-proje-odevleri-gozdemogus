package com.patika.springbootcamp.model.dto;

import com.patika.springbootcamp.model.enums.LangOptions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private String title;
    private String details;
    private double price;
    private int quota;
    private List<String> keywords;
    private List<LangOptions> langOptions;
    private String brand;
}
