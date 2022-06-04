package com.example.domain.driven.skeleton.domain.valueobj.enums;

import lombok.Getter;

public enum CurrencyType {
    RMB("RMB", 100),
    USD("USD", 200);

    @Getter
    private final String denote;
    @Getter
    private final Integer code;

    CurrencyType(String denote, Integer code) {
        this.denote = denote;
        this.code = code;
    }

    public static CurrencyType parseCode(Integer code) {
        if (code != null) {
            for (CurrencyType value : CurrencyType.values()) {
                if (code.equals(value.getCode())) {
                    return value;
                }
            }
        }
        return null;
    }

    public static CurrencyType parseDenote(String denote) {
        if (denote != null) {
            for (CurrencyType item : CurrencyType.values()) {
                if (denote.equals(item.getDenote())) {
                    return item;
                }
            }
        }
        return null;
    }
}
