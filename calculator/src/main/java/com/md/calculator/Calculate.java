package com.md.calculator;

import com.md.calculator.counters.DiscountPriceCounter;
import com.md.calculator.counters.CurrentPriceCounter;
import com.md.calculator.counters.OriginalPriceCounter;
import com.md.calculator.valueData.CurrentPrice;
import com.md.calculator.valueData.DiscountPrice;
import com.md.calculator.valueData.OriginalPrice;

public class Calculate {
    public static void main(String[] args) {
        OriginalPrice originalPrice = new OriginalPrice(20.00);
        DiscountPrice discountPrice = new DiscountPrice(10.00);
        CurrentPrice currentPrice = new CurrentPrice(18.00);

        DiscountPriceCounter discountPriceCounter = new DiscountPriceCounter(originalPrice, currentPrice);
        System.out.println("Discount amount is equal to: " + discountPriceCounter.count());

        OriginalPriceCounter originalPriceCounter = new OriginalPriceCounter(currentPrice, discountPrice);
        System.out.println("Original amount is equal to: " + originalPriceCounter.count());

        CurrentPriceCounter currentPriceCounter = new CurrentPriceCounter(originalPrice, discountPrice);
        System.out.println("New amount is equal to: " + currentPriceCounter.count());
    }
}
