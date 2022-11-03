package com.asamhussain.springmvc.service;

import com.asamhussain.springmvc.model.Fruit;
import com.asamhussain.springmvc.model.UserInput;
import com.asamhussain.springmvc.repository.FruitRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitService {


    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    public Fruit addFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    public Fruit getFruitByName(String name){
        return fruitRepository.findFruitByName(name);
    }

    public double getFruitPrice(Fruit fruit){
        return fruit.getFruitPrice();
    }

    public List<Fruit> getAllFruit(){
        return fruitRepository.findAll();
    }

    //create price list depend on fruit quantity
    public List<Double> getPriceList(int qty, Fruit fruit){
        double fruitPrice = fruit.getFruitPrice();
        int cartonQty = fruit.getCartonQty();
        double cartonPrice = fruit.getCartonPrice();
        double totalAmount = 0;

        List<Double> priceList = new ArrayList<>();
        if(qty == 0){
            priceList.add(0.0);
            return priceList;
        }
        for(int x=1; x<=qty; x++){
            if(x%cartonQty == 0){
                try{
                    int noOfCarton = x/cartonQty;
                    totalAmount = noOfCarton * cartonPrice;
                }
                catch (ArithmeticException arithmeticException){
                    totalAmount = 0;
                }


                priceList.add(totalAmount);
            }
            else {
                totalAmount = totalAmount + fruitPrice;
                priceList.add(totalAmount);
            }
        }
        return priceList;
    }

    //Calculate the carton count by user input in the qty
    public int getCartonCount(UserInput userInput){
        Fruit mFruit = fruitRepository.findFruitByName(userInput.getFruitName());
        return userInput.getFruitCount()/mFruit.getCartonQty();
    }

    //Calculate the balance fruit after carton
    public int getFruitsAfterCarton(Fruit fruit, UserInput userInput){
        return userInput.getFruitCount()%fruit.getCartonQty();
    }

    //Calculate the total price of carton
    public double getPriceOfCarton(UserInput userInput){

        Fruit mFruit = fruitRepository.findFruitByName(userInput.getFruitName());
        return mFruit.getCartonPrice() * userInput.getCartonCount();
    }

    //Calculate the total amount of fruits inputs
    public double getTotalAmountOfFruitInput(UserInput userInput){
        Fruit mFruit = fruitRepository.findFruitByName(userInput.getFruitName());
        double fruitPrice = mFruit.getFruitPrice();
        int cartonQty = mFruit.getCartonQty();
        double cartonPrice = mFruit.getCartonPrice();
        double totalAmount = 0;

        int inputCartonQty = userInput.getCartonCount();
        int inputQty = userInput.getFruitCount();

        //get total amount
        for(int x=1; x<=inputQty; x++){

            //Check the carton quantity
            if(x%cartonQty == 0){

                //find the carton quantity
                int noOfCarton = x/cartonQty;
                totalAmount = noOfCarton * cartonPrice;

            }
            else {
                totalAmount = totalAmount + fruitPrice;
            }
        }
        return totalAmount;

    }

    //Calculate the total amount
    public double getAmount(UserInput userInput){
        return getTotalAmountOfFruitInput(userInput) + getPriceOfCarton(userInput);
    }


}
