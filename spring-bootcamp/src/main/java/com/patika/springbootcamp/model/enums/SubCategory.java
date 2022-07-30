package com.patika.springbootcamp.model.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum SubCategory {
    CLOTHING("CLOTHING"),
    BAGS("BAGS"),
    SHOES("SHOES"),
    ACCESSORIES("ACCESSORIES"),
    SPORT_OUTDOOR("SPORT_OUTDOOR"),
    HOBBY("HOBBY"),
    TOYS("TOYS"),
    BOOKS("BOOKS"),
    ELECTRONICS("ELECTRONICS");

    private String text;

    SubCategory(String text) {
        this.text = text;
    }

}
