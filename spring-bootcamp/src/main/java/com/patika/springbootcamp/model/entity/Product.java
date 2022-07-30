package com.patika.springbootcamp.model.entity;

import com.patika.springbootcamp.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String details;
    private double price;
    private int numberOfPeopleClicked;
    private int countOfLikes;
    private String brand;
    @Enumerated(EnumType.ORDINAL)
    private Usage usage;
    @Enumerated(EnumType.ORDINAL)
    private Size size;
    @Enumerated(EnumType.ORDINAL)
    private Colors colors;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @Enumerated(EnumType.ORDINAL)
    private SubCategory subCategory;


    @ManyToOne()
    private User seller;

    @ManyToOne()
    private User buyer;

}