package com.patika.springbootcamp.model.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Colors {
    WHITE("white"),
    BLACK("black"),
    ORANGE("orange"),
    GREEN("green"),
    GREY("grey"),
    BLUE("blue"),
    YELLOW("yellow"),
    PRINTED("printed"),
    OTHER("other");

    private String text;

    Colors(String text) {
        this.text = text;
    }

}