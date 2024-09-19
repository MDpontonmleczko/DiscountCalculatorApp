package com.md.calculator;

import com.md.calculator.counters.DiscountValueCounter;
import com.md.calculator.counters.DiscountedPriceCounter;
import com.md.calculator.counters.OriginalPriceCounter;
import com.md.calculator.valueData.DiscountValue;
import com.md.calculator.valueData.DiscountedPrice;
import com.md.calculator.valueData.OriginalPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/")
    public String calculator(Model model) {
        model.addAttribute("discount", 0);
        model.addAttribute("original", 0);
        model.addAttribute("current", 0);
        return "calculator";
    }

    @PostMapping("/calculateDiscountPrice")
    public String calculateDiscount(
            @RequestParam(value = "original", required = false) Double original,
            @RequestParam(value = "current", required = false) Double current,
            Model model) {

        logger.info("Original Price: {}", original);
        logger.info("New Price: {}", current);

        OriginalPrice originalPrice = new OriginalPrice(original);
        DiscountedPrice discountedPrice = new DiscountedPrice(current);

        Double discount = new DiscountValueCounter(originalPrice, discountedPrice).count();
        DiscountValue discountValue = new DiscountValue(discount);

        model.addAttribute("discount", discountValue.getValue());
        model.addAttribute("original", originalPrice.getValue());
        model.addAttribute("current", discountedPrice.getValue());

        return "calculateResults";
    }

    @PostMapping("/calculateCurrentPrice")
    public String calculateNewPrice(
            @RequestParam(value = "original", required = false) Double original,
            @RequestParam(value = "discount", required = false) Double discount,
            Model model) {

        logger.info("Original Price: {}", original);
        logger.info("New Price: {}", discount);

        OriginalPrice originalPrice = new OriginalPrice(original);
        DiscountValue discountValue = new DiscountValue(discount);

        Double current = new DiscountedPriceCounter(originalPrice, discountValue).count();
        DiscountedPrice discountedPrice = new DiscountedPrice(current);

        model.addAttribute("discount", discountValue.getValue());
        model.addAttribute("original", originalPrice.getValue());
        model.addAttribute("current", discountedPrice.getValue());

        return "calculateResults";
    }

    @PostMapping("/calculateOriginalPrice")
    public String calculateOriginalPrice(
            @RequestParam(value = "current", required = false) Double current,
            @RequestParam(value = "discount", required = false) Double discount,
            Model model) {

        logger.info("Original Price: {}", current);
        logger.info("New Price: {}", discount);

        DiscountedPrice discountedPrice = new DiscountedPrice(current);
        DiscountValue discountValue = new DiscountValue(discount);

        Double original = new OriginalPriceCounter(discountedPrice, discountValue).count();
        OriginalPrice originalPrice = new OriginalPrice(original);

        model.addAttribute("discount", discountValue.getValue());
        model.addAttribute("original", originalPrice.getValue());
        model.addAttribute("current", discountedPrice.getValue());

        return "calculateResults";
    }
}
