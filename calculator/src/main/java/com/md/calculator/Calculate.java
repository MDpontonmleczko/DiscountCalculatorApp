package com.md.calculator;

import com.md.calculator.counters.DiscountValueCounter;
import com.md.calculator.counters.DiscountedPriceCounter;
import com.md.calculator.counters.OriginalPriceCounter;
import com.md.calculator.valueData.DiscountedPrice;
import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.OriginalPrice;

public class Calculate {
    public static void main(String[] args) {
        OriginalPrice originalPrice = new OriginalPrice(20.00);
        DiscountValue discountValue = new DiscountValue(10.00);
        DiscountedPrice discountedPrice = new DiscountedPrice(18.00);

        DiscountValueCounter discountValueCounter = new DiscountValueCounter(originalPrice, discountedPrice);
        System.out.println("Discount amount is equal to: " + discountValueCounter.count());

        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(discountedPrice, discountValue);
        System.out.println("Original amount is equal to: " + originalPriceCounter.count());

        DiscountedPriceCounter discountedPriceCounter = new DiscountedPriceCounter(originalPrice, discountValue);
        System.out.println("New amount is equal to: " + discountedPriceCounter.count());
    }
}
