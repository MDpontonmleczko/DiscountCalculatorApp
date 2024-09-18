package com.md.calculator;

import com.md.calculator.counters.DiscountPriceCounter;
import com.md.calculator.counters.CurrentPriceCounter;
import com.md.calculator.counters.OriginalPriceCounter;
import com.md.calculator.valueData.DiscountPrice;
import com.md.calculator.valueData.CurrentPrice;
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
            @RequestParam Double original,
            @RequestParam Double current,
            Model model) {

        logger.info("Original Price: {}", original);
        logger.info("New Price: {}", current);

        OriginalPrice originalPrice = new OriginalPrice(original);
        CurrentPrice currentPrice = new CurrentPrice(current);

        Double discount = new DiscountPriceCounter(originalPrice, currentPrice).count();

        model.addAttribute("discount", discount);
        model.addAttribute("original", original);
        model.addAttribute("current", current);

        return "calculateResults";
    }

    @PostMapping("/calculateCurrentPrice")
    public String calculateNewPrice(
            @RequestParam Double original,
            @RequestParam Double discount,
            Model model) {

        logger.info("Original Price: {}", original);
        logger.info("New Price: {}", discount);

        OriginalPrice originalPrice = new OriginalPrice(original);
        DiscountPrice discountPrice = new DiscountPrice(discount);

        Double current = new CurrentPriceCounter(originalPrice, discountPrice).count();

        model.addAttribute("discount", discount);
        model.addAttribute("original", original);
        model.addAttribute("current", current);

        return "calculateResults";
    }

    @PostMapping("/calculateOriginalPrice")
    public String calculateOriginalPrice(
            @RequestParam Double current,
            @RequestParam Double discount,
            Model model) {

        logger.info("Original Price: {}", current);
        logger.info("New Price: {}", discount);

        CurrentPrice currentPrice = new CurrentPrice (current);
        DiscountPrice discountPrice = new DiscountPrice(discount);

        Double original = new OriginalPriceCounter(currentPrice, discountPrice).count();

        model.addAttribute("discount", discount);
        model.addAttribute("original", original);
        model.addAttribute("current", current);

        return "calculateResults";
    }
}
