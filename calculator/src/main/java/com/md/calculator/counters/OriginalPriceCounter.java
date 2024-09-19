package com.md.calculator.counters;

import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.DiscountedPrice;

public class OriginalPriceCounter extends Counter {

    private final DiscountedPrice discountedPrice;
    private final DiscountValue discountValue;

    public OriginalPriceCounter(DiscountedPrice discountedPrice, DiscountValue discountValue) {
        this.discountedPrice = discountedPrice;
        this.discountValue = discountValue;
    }

    @Override
    public double count() {
        return 100 * this.discountedPrice.getValue() / (100 - this.discountValue.getValue());
    }
}
