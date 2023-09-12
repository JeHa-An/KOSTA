package com.test06.entity;

public class Juice extends Drink{
    final int JUICE_PRICE;
    public Juice(){
        super(200);
        JUICE_PRICE = super.price;
    }
    public int getJUICE_PRICE() {
        return JUICE_PRICE;
    }
    @Override
    public String toString() {
        return String.format("주스");
    }
}
