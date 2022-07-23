package com.patika.springbootcamp.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;


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

    @Override
    public String toString() {
        return text;
    }


    public String getText() {
        return this.text;
    }

    @JsonCreator
    public static Size fromText(String text) {
        for (Size r : Size.values()) {
            if (r.getText().equals(text)) {
                return r;
            }
        }
        throw new IllegalArgumentException();
    }
}



