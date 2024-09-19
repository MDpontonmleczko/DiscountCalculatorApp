package com.md.calculator;

import com.md.calculator.counters.DiscountedPriceCounter;
import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.OriginalPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiscountedPriceCounter {
    DiscountValue discountValue;
    OriginalPrice originalPrice;

    @Test
    public void countPositiveDiscountedPrice(){
        discountValue = new DiscountValue(10.00);
        originalPrice = new OriginalPrice(20.00);
        DiscountedPriceCounter discountedPriceCounter = new DiscountedPriceCounter(originalPrice, discountValue);
        Assertions.assertEquals(18.00, discountedPriceCounter.count());
    }

    @Test
    public void countNegativeDiscountedPriceWithNegativeDiscountValue(){
        discountValue = new DiscountValue(-10.00);
        originalPrice = new OriginalPrice(20.00);
        DiscountedPriceCounter discountedPriceCounter = new DiscountedPriceCounter(originalPrice, discountValue);
        Assertions.assertEquals(22.00, discountedPriceCounter.count());
    }

    @Test
    public void countDiscountedPriceWithNegativeOriginalPrice(){
        discountValue = new DiscountValue(10.00);
        originalPrice = new OriginalPrice(-20.00);
        DiscountedPriceCounter discountedPriceCounter = new DiscountedPriceCounter(originalPrice, discountValue);
        Assertions.assertEquals(0, discountedPriceCounter.count());
    }

    @Test
    public void countDiscountedPriceWIthNegativePrices(){
        discountValue = new DiscountValue(-10.00);
        originalPrice = new OriginalPrice(-20.00);
        DiscountedPriceCounter discountedPriceCounter = new DiscountedPriceCounter(originalPrice, discountValue);
        Assertions.assertEquals(0,discountedPriceCounter.count());
    }
}
