package com.md.calculator.valueData;

import java.util.Objects;

public class DiscountValue {

    Double value;

    public DiscountValue(Double value) {
        this.value = Objects.requireNonNullElse(value, 0.0);
    }

    public Double getValue() {
        return value;
    }
}
