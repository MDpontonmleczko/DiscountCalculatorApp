package com.md.calculator.counters;

import com.md.calculator.valueData.CurrentPrice;
import com.md.calculator.valueData.OriginalPrice;

public class DiscountPriceCounter extends Counter{

    private final OriginalPrice originalPrice;
    private final CurrentPrice currentPrice;

    public DiscountPriceCounter(OriginalPrice originalPrice, CurrentPrice currentPrice) {
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
    }

    @Override
    public double count(){
        if (this.originalPrice.getValue() > 0){
            return (this.originalPrice.getValue() - this.currentPrice.getValue()) / this.originalPrice.getValue() * 100;
        } else {
            return 0;
        }

    }
}
