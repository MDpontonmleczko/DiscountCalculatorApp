package com.md.calculator.valueData;

public class DiscountedPrice {

    Double value;

    public DiscountedPrice(Double value) {
        if (value == null || value < 0.0) {
            this.value = 0.0;
        } else {
            this.value = value;
        }
    }

    public Double getValue() {
        return value;
    }
}
