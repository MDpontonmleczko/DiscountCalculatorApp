package com.md.calculator;

import com.md.calculator.counters.DiscountPriceCounter;
import com.md.calculator.valueData.CurrentPrice;
import com.md.calculator.valueData.OriginalPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiscountPriceCounter {

    CurrentPrice currentPrice;
    OriginalPrice originalPrice;

    @Test
    public void countCorrectValues(){
        currentPrice = new CurrentPrice(15.00);
        originalPrice = new OriginalPrice(20.00);
        DiscountPriceCounter discountPriceCounter = new DiscountPriceCounter(originalPrice, currentPrice);
        Assertions.assertEquals(25, discountPriceCounter.count());
        System.out.println("With new amount: " + currentPrice.getValue()
                + ", and original amount: " + originalPrice.getValue()
                + ". Discount amount is equal to: " + discountPriceCounter.count());
    }
}
