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
        Fruit apple = fruitService.getFruitByName("Apple");
        priceListApple = fruitService.getPriceList(25, apple);


        //Retrieve King Coconut details from DB Prepare the price list for 25 King Coconut
        Fruit kingCoconut = fruitService.getFruitByName("KingCoconut");
        priceListKingCoconut = fruitService.getPriceList(25, kingCoconut);

        //attach fruits details
        model.addAttribute("a_carton_price", apple.getCartonPrice());
        model.addAttribute("a_carton_qty", apple.getCartonQty());
        model.addAttribute("k_carton_price", kingCoconut.getCartonPrice());
        model.addAttribute("k_carton_qty", kingCoconut.getCartonQty());

        //Attach the lists to model
        model.addAttribute("pricesApple", priceListApple);
        model.addAttribute("pricesKingCoconut", priceListKingCoconut);
        return "prices";
    }
}
