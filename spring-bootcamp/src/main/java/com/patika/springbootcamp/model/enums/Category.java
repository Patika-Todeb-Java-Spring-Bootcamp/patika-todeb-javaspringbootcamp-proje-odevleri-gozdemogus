package com.patika.springbootcamp.model.enums;

import lombok.Getter;

@Getter
public enum Category {
    WOMAN("WOMAN"),
    MAN("MAN"),
    CHILD("CHILD"),
    HOME_LIVING("HOME_LIVING");
    private String text;

    Category(String text) {
        this.text = text;
    }

}
