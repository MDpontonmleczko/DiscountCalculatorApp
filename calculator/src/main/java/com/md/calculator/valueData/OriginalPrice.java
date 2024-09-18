package com.md.calculator.valueData;

public class OriginalPrice {

    Double value;

    public OriginalPrice(Double value) {
        if (value < 0.0) {
            this.value = 0.0;
        } else {
            this.value = value;
        }
    }

    public Double getValue() {
        return value;
    }
}
