package com.md.calculator.counters;

import com.md.calculator.valueData.DiscountedPrice;
import com.md.calculator.valueData.OriginalPrice;

public class DiscountValueCounter extends Counter{

    private final OriginalPrice originalPrice;
    private final DiscountedPrice discountedPrice;

    public DiscountValueCounter(OriginalPrice originalPrice, DiscountedPrice discountedPrice) {
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public double count(){
        if (this.originalPrice.getValue() > 0){
            return (this.originalPrice.getValue() - this.discountedPrice.getValue()) / this.originalPrice.getValue() * 100;
        } else {
            return 0;
        }

    }
}
