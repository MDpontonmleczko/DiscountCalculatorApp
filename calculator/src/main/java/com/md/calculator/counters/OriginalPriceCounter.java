package com.md.calculator.counters;

import com.md.calculator.valueData.DiscountPrice;
import com.md.calculator.valueData.CurrentPrice;

public class OriginalPriceCounter extends Counter {

    private final CurrentPrice currentPrice;
    private final DiscountPrice discountPrice;

    public OriginalPriceCounter(CurrentPrice currentPrice, DiscountPrice discountPrice) {
        this.currentPrice = currentPrice;
        this.discountPrice = discountPrice;
    }

    @Override
    public double count() {
        return 100 * this.currentPrice.getValue() / (100 - this.discountPrice.getValue());
    }
}
