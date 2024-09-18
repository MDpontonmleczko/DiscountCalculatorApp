package com.md.calculator.valueData;

public class DiscountPrice {

    Double value;

    public DiscountPrice(Double value) {
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
