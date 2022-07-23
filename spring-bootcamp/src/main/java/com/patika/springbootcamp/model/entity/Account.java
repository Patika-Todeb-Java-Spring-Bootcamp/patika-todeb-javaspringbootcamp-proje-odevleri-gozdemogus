package com.patika.springbootcamp.model.entity;

import javax.persistence.*;

@Entity
public class Account {

    @OneToOne()
    private User owner;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int balance;
    private int amountOnWait;
    private int amountAvailable;

}
