package com.patika.springbootcamp.model.enums;

import lombok.Getter;

@Getter
public enum Size {
    XS("x small"),
    S("small"),
    M("medium"),
    L("large"),
    ONE_SIZE("One Size");

    private String text;

    Size(String text) {
        this.text = text;
    }
}



