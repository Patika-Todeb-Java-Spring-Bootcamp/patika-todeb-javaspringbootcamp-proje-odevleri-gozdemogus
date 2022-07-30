package com.patika.springbootcamp.model.entity;

import com.patika.springbootcamp.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String name;
    private String surname;
    private String about;
    private String email;
    private String address;
    private String phone;
    private String IBAN;
    @CreationTimestamp
    private Date dateOfSignUp;

    @OneToMany()
    private List<Product> productsSold = new ArrayList<Product>();

    @OneToMany()
    private List<Product> productsBought = new ArrayList<Product>();

}
