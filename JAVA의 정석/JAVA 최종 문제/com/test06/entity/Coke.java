package com.test06.entity;

public class Coke extends Drink {
    final int COKE_PRICE;
    public Coke(){
        super(50);
        COKE_PRICE = super.price;
    }
    public int getCOKE_PRICE() {
        return COKE_PRICE;
    }
    @Override
    public String toString() {
        return String.format("코크");
    }
}
