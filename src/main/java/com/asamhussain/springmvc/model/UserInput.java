package com.asamhussain.springmvc.model;

import org.springframework.context.annotation.Bean;

public class UserInput {
    private String fruitName;
    private int cartonCount;
    private int fruitCount;

    public UserInput() {
    }

    public UserInput(String fruitName, int cartonCount, int fruitCount) {
        this.fruitName = fruitName;
        this.cartonCount = cartonCount;
        this.fruitCount = fruitCount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getCartonCount() {
        return cartonCount;
    }

    public void setCartonCount(int cartonCount) {
        this.cartonCount = cartonCount;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }
}
