package com.patika.springbootcamp.model.dto;

import com.patika.springbootcamp.model.entity.User;
import com.patika.springbootcamp.model.enums.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String details;
    @NotBlank(message = "bos bırakılamaz")
    @Positive(message = "positive")
    private double price;
    private String brand;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @Enumerated(EnumType.ORDINAL)
    private Usage usage;
    @Enumerated(EnumType.ORDINAL)
    private Colors colors;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    private int numberOfPeopleClicked;
    private int countOfLikes;
    @Enumerated(EnumType.ORDINAL)
    private SubCategory subCategory;
    private User seller;
    private User buyer;


}
