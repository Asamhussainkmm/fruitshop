package com.asamhussain.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name="fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cartonQty")
    private int cartonQty;
    @Column(name = "cartonPrice")
    private int cartonPrice;

    public Fruit() {
    }

    public Fruit(int id, String name, int cartonQty, int cartonPrice) {
        this.id = id;
        this.name = name;
        this.cartonQty = cartonQty;
        this.cartonPrice = cartonPrice;
    }

    public Fruit(String name, int cartonQty, int cartonPrice) {
        this.name = name;
        this.cartonQty = cartonQty;
        this.cartonPrice = cartonPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCartonQty() {
        return cartonQty;
    }

    public void setCartonQty(int cartonQty) {
        this.cartonQty = cartonQty;
    }

    public int getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(int cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public double getFruitPrice(){
        double oneFruitPrice = (cartonPrice/cartonQty) * 1.2;
        return oneFruitPrice;
    }
}