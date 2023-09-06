package com.test06.biz;

import com.test06.entity.*;

public interface IVendingMachineBiz {
    public String cartDrink(Drink drink);
    public  void printCart();
    public void printDrinkList(Drink[] drinkList);

}
