package com.patika.springbootcamp.model;

import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {

}
