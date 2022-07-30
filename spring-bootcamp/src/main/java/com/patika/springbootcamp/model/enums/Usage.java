package com.patika.springbootcamp.model.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Usage {
    USED("used"),
    UNUSED("unused"),
    NEW_WITH_TAGS("NEW_WITH_TAGS");

    private String text;

    Usage(String text) {
        this.text = text;
    }


}
