package com.asamhussain.springmvc.controller;

import com.asamhussain.springmvc.model.Fruit;
import com.asamhussain.springmvc.model.UserInput;
import com.asamhussain.springmvc.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private final FruitService fruitService;

    UserInput userInput = new UserInput();


    public CalculatorController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    private List<Fruit> allFruits = new ArrayList<>();

    //Return the view of Calculator.html
    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model){

        //sending the fruits details from database
        model.addAttribute("fruits", fruitService.getAllFruit());
        model.addAttribute("userInput", userInput);
        return "calculator";
    }

    //Button click action
    @RequestMapping(value = "/calculator", params = "calc", method = RequestMethod.POST)
    public String calc(@ModelAttribute("userInput") UserInput userInput, BindingResult result, Model model){
        //error checking
        if(!result.hasErrors()){

            Fruit fruit = fruitService.getFruitByName(userInput.getFruitName());

            model.addAttribute("result", fruitService.getAmount(userInput));

            //Retrieve Apple details from DB Prepare the price list
            List <Double> priceList = fruitService.getPriceList(userInput.getFruitCount(), fruit);

            //Attach the lists to model
            model.addAttribute("pricesList", priceList);

            //Attach the carton capacity
            model.addAttribute("carton_count", fruit.getCartonQty());

            //Attach one carton price
            model.addAttribute("carton_price", fruit.getCartonPrice());

            //Attach the carton count what user inserted
            model.addAttribute("carton_input_count", userInput.getCartonCount());

            //Attach the fruit count what user inserted
            model.addAttribute("fruit_input_count", userInput.getFruitCount());

            //Attach the price of total amount of cartons (user input)
            model.addAttribute("price_of_all_carton", fruitService.getPriceOfCarton(userInput));

            //Attach the quantity of cartons using user Fruits quantity input
            model.addAttribute("total_carton", fruitService.getCartonCount(userInput));

            //Attach the balance fruits quantity after cartons
            model.addAttribute("balance_fruit", fruitService.getFruitsAfterCarton(fruit, userInput));

            //Attach the total price of the fruits without carton input
            model.addAttribute("amount_of_fruits_input", fruitService.getTotalAmountOfFruitInput(userInput));
        }
        else {
            //for the wrong input
            userInput.setCartonCount(0);
            userInput.setFruitCount(0);
            model.addAttribute("result", fruitService.getAmount(userInput));

        }

        return "calculator";
    }





}
