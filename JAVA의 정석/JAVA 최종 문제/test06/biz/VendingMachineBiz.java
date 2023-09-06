package com.test06.biz;

import com.test06.entity.Coffe;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz implements IVendingMachineBiz {
    int balance;
    Drink[] cartList;
    int count = 0;

    public VendingMachineBiz() {
        balance = 1000;
        cartList = new Drink[3];
    }
    public void setBalance(int pay){
        balance = pay;
    }

    public int getBalance() {
        return balance;
    }
    @Override
    public String cartDrink(Drink drink) {
        if(balance < drink.getPrice()) {
            return String.format("잔액이 부족하여 %s 구매 불가능합니다.", drink.toString());
        }
        if(cartList.length == count) {
            Drink[] temp = new Drink[cartList.length * 3];
            System.arraycopy(cartList, 0, temp, 0, cartList.length);
            cartList = temp;
        }
        setBalance(balance - drink.getPrice());
        cartList[count++] = drink;

        return String.format("%s를 구입했습니다. 현재 잔액: %d 원", drink.toString(), getBalance());
    }

    @Override
    public void printCart() {
        int juiceCnt = 0, coffeCnt = 0, cokeCnt = 0;
        for(Drink dr : cartList) {
            if (dr == null) break;
            else if (dr.getPrice() == 200) juiceCnt++;
            else if (dr.getPrice() == 100) coffeCnt++;
            else cokeCnt++;
        }
        System.out.println("=====음료수 구입 목록=====");
        System.out.println(String.format("쥬스 : %d 개", juiceCnt));
        System.out.println(String.format("커피 : %d 개", coffeCnt));
        System.out.println(String.format("코크 : %d 개", cokeCnt));
        System.out.println("=============================");
        System.out.println(String.format("사용 금액 : %d 원",1000 - getBalance()));
        System.out.println(String.format("남은 금액 : %d 원",getBalance()));
    }
    @Override
    public void printDrinkList(Drink[] drinkList) {
        System.out.println("===================");
        System.out.println("음료수명   가격");
        System.out.println("===================");
        System.out.println(String.format("%s %10d", drinkList[1].toString(), drinkList[1].getPrice()));
        System.out.println(String.format("%s %10d", drinkList[2].toString(), drinkList[2].getPrice()));
        System.out.println(String.format("%s %10d", drinkList[0].toString(), drinkList[0].getPrice()));
        System.out.println("-----------");
        System.out.println(String.format("현재 잔액: %d 원", getBalance()));

    }
}
