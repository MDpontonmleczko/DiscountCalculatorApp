package com.md.calculator.counters;

import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.OriginalPrice;

public class DiscountedPriceCounter extends Counter{

    private final OriginalPrice originalPrice;
    private final DiscountValue discountValue;

    public DiscountedPriceCounter(OriginalPrice originalPrice, DiscountValue discountValue) {
        this.originalPrice = originalPrice;
        this.discountValue = discountValue;
    }

    @Override
    public double count() {
        return this.originalPrice.getValue()- this.originalPrice.getValue() * this.discountValue.getValue()/100;
    }
}
