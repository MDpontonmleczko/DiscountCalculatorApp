package com.md.calculator;

import com.md.calculator.counters.OriginalPriceCounter;
import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.DiscountedPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOriginalPriceCounter {

    DiscountedPrice discountedPrice;
    DiscountValue discountValue;

    @Test
    public void countPositiveOriginalPrice(){
        discountedPrice = new DiscountedPrice(15.00);
        discountValue = new DiscountValue(25.00);
        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(discountedPrice, discountValue);
        Assertions.assertEquals(20,originalPriceCounter.count());
    }

    @Test
    public void countOriginalPriceWithNegativePrices(){
        discountedPrice = new DiscountedPrice(-12.00);
        discountValue = new DiscountValue(-20.00);
        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(discountedPrice, discountValue);
        Assertions.assertEquals(0,originalPriceCounter.count());
    }

    @Test
    public void countOriginalPriceWithNegativeDiscountedPrice(){
        discountedPrice = new DiscountedPrice(-12.00);
        discountValue = new DiscountValue(20.00);
        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(discountedPrice, discountValue);
        Assertions.assertEquals(0,originalPriceCounter.count());
    }

    @Test
    public void countOriginalPriceWithNegativeDiscountValue(){
        discountedPrice = new DiscountedPrice(11.00);
        discountValue = new DiscountValue(-10.00);
        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(discountedPrice, discountValue);
        Assertions.assertEquals(10,originalPriceCounter.count());
    }
}
