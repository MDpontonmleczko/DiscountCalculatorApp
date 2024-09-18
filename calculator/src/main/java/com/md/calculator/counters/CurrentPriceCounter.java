package com.md.calculator.counters;

import com.md.calculator.valueData.DiscountPrice;
import com.md.calculator.valueData.OriginalPrice;

public class CurrentPriceCounter extends Counter{

    private final OriginalPrice originalPrice;
    private final DiscountPrice discountPrice;

    public CurrentPriceCounter(OriginalPrice originalPrice, DiscountPrice discountPrice) {
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
    }

    @Override
    public double count() {
        return this.originalPrice.getValue()- this.originalPrice.getValue() * this.discountPrice.getValue()/100;
    }
}
