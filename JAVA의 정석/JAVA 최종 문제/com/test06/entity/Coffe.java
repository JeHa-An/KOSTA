package com.test06.entity;

public class Coffe extends Drink{
    final int COFFEE_PRICE;
    public Coffe() {
        super(100);
        COFFEE_PRICE = super.price;
    }
    public int getCOFFEE_PRICE() {
        return COFFEE_PRICE;
    }

    @Override
    public String toString() {
        return String.format("커피");
    }
}
