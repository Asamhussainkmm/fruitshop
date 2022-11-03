package com.asamhussain.springmvc.controller;

import com.asamhussain.springmvc.model.Fruit;
import com.asamhussain.springmvc.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class PricesController {

    private final FruitService fruitService;

    public PricesController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    private List<Double> priceListApple;
    private List<Double> priceListKingCoconut;


    //Return the view of Prices.html
    @GetMapping("prices")
    public String getContactPage(Model model){
        //Retrieve Apple details from DB Prepare the price list for 25 apples
        priceListApple = fruitService.getPriceList(25, fruitService.getFruitByName("Apple"));

        //Retrieve King Coconut details from DB Prepare the price list for 25 King Coconut
        priceListKingCoconut = fruitService.getPriceList(25, fruitService.getFruitByName("KingCoconut"));

        //Attach the lists to model
        model.addAttribute("pricesApple", priceListApple);
        model.addAttribute("pricesKingCoconut", priceListKingCoconut);
        return "prices";
    }
}
