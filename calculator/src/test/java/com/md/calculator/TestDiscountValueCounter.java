package com.md.calculator;

import com.md.calculator.counters.DiscountValueCounter;
import com.md.calculator.valueData.DiscountedPrice;
import com.md.calculator.valueData.OriginalPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiscountValueCounter {

    DiscountedPrice discountedPrice;
    OriginalPrice originalPrice;

    @Test
    public void countPositiveDiscountValue(){
        discountedPrice = new DiscountedPrice(15.00);
        originalPrice = new OriginalPrice(20.00);
        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        Assertions.assertEquals(25.00, discountValueCounter.count());
    }

    @Test
    public void countNegativeDiscountValue(){
        discountedPrice = new DiscountedPrice(110.00);
        originalPrice = new OriginalPrice(100.00);
        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        Assertions.assertEquals(-10.00, discountValueCounter.count());
    }

    @Test
    public void countDiscountValueWithNegativeOriginalPrice(){
        discountedPrice = new DiscountedPrice(50.00);
        originalPrice = new OriginalPrice(-100.00);
        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        Assertions.assertEquals(0, discountValueCounter.count());
    }

    @Test
    public void countDiscountValueWithNegativeDiscountedPrice(){
        discountedPrice = new DiscountedPrice(-50.00);
        originalPrice = new OriginalPrice(100.00);
        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        Assertions.assertEquals(100.00, discountValueCounter.count());
    }

    @Test
    public void countDiscountValueWithNegativePrices(){
        discountedPrice = new DiscountedPrice(-50.00);
        originalPrice = new OriginalPrice(-100.00);
        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        Assertions.assertEquals(0, discountValueCounter.count());
    }
}
