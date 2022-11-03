package com.asamhussain.springmvc.controller;

import com.asamhussain.springmvc.model.Fruit;
import com.asamhussain.springmvc.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping()
public class FruitAddController {

    private final FruitService fruitService;

    public FruitAddController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostConstruct
    //Adding fruits to database
    public void addFruit(){
        Fruit apple = new Fruit("Apple", 15, 300);
        Fruit kingCoconut = new Fruit("KingCoconut", 5, 625);
        fruitService.addFruit(apple);
        fruitService.addFruit(kingCoconut);
    }


}
