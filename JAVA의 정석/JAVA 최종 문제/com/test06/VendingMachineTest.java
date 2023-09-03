package com.test06;

import com.test06.biz.*;
import com.test06.entity.*;

import java.util.Scanner;

public class VendingMachineTest {
    static void printMenu() {
        System.out.println("=============================");
        System.out.println("[음료수 자판기 관리 시스템]");
        System.out.println("=============================");
        System.out.println("1.전체 음료수 및 잔액 보기");
        System.out.println("2.쥬스 구입하기 ( 200원 )");
        System.out.println("3.커피 구입하기 ( 100원 )");
        System.out.println("4.코크 구입하기 ( 50원 )");
        System.out.println("5.구입한 음료수 목록 보기");
        System.out.println("9.종료\n");
        System.out.println("=============================");
        System.out.print("메뉴 입력 => ");
    }

    public static void main(String[] args){
        VendingMachineBiz vmb = new VendingMachineBiz();
        Scanner in = new Scanner(System.in);
        Drink[] dr = {new Juice(), new Coffe(), new Coke()};
        int sel = 0;

        while(true){
            printMenu();
            sel = Integer.parseInt(in.nextLine());

            switch (sel){
                case 1:
                    vmb.printDrinkList(dr);
                    break;
                case 2:
                    System.out.println(vmb.cartDrink(new Juice()));
                    break;
                case 3:
                    System.out.println(vmb.cartDrink(new Coffe()));
                    break;
                case 4:
                    System.out.println(vmb.cartDrink(new Coke()));
                    break;
                case 5:
                    vmb.printCart();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return ;
                default:
                    System.out.println("메뉴값을 확인후 다시 입력하세요");
            }
        }
    } // main
}
