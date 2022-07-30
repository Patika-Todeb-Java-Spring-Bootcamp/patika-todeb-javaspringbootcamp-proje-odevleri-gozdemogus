package com.patika.springbootcamp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderTable")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyy")
    private Date orderDate;
    @OneToOne
    @JoinColumn(name = "buyer", referencedColumnName = "id")
    private User buyer;
    private boolean finished;
    private boolean confirmed;
    private Long boughtProductId;
}
