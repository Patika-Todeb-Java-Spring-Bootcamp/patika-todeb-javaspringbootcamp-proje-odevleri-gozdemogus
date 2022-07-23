package com.patika.springbootcamp.model.entity;

import com.patika.springbootcamp.model.enums.Category;
import com.patika.springbootcamp.model.enums.Color;
import com.patika.springbootcamp.model.enums.Size;
import com.patika.springbootcamp.model.enums.Usage;
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
    @Enumerated
    private Usage usage;
    @Enumerated
    private Size size;
    @Enumerated
    private Color color;
    @Enumerated
    private Category category;

    @ManyToOne()
    private User seller;

    @ManyToOne()
    private User buyer;
}