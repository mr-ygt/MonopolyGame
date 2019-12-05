package com.company;

import java.util.Random;

public class Board {

    int numOfTaxSquare;

    String[] towns = {"Kasimpasa", "Dolapdere", "Sultanahmet", "Karakoy", "Sirkeci", "Beyoglu", "Besiktas",
            "Taksim", "Harbiye", "Sisli", "Mecidiyekoy", "Bostanci", "Erenkoy", "Caddebostan" + "Nisantasi",
            "Tesvikiye", "Macka", "Levent", "Etiler", "Bebek", "Tarabya", "Yenikoy", "Sicilya", "NewYork"};

    String message;


    Square[] squares = new Square[40];
    public Board(int goMoney, int taxAmount){
    int price = 100;
    int index = 0;
        for(int i = 0; i < 40; i++){
            squares[i].purchasable = false;
            if(i == 0)
                squares[0] = new GoSquare("Start", goMoney);
            else if(i == 2 || i == 17 || i == 33){
                squares[i] = new EmptySquare();
            }
            else if(i == 4 || i == 38){
                squares[i] = new TaxSquare("Tax Square", taxAmount, i);
            }
            else if(i == 5 || i == 15 || i == 25 || i == 35){
                squares[i] = new RailRoadSquare();
            }
            else if(i == 7 || i == 22 || i == 36){
                squares[i] = new LuckyCardSquare();
            }
            else if(i == 10){
                squares[10] = new JailSquare();
            }
            else if(i == 20){
                squares[20] = new CarPark();
            }
            else if(i == 30){
                squares[30] = new GoToJailSquare();
            }
            else{
                squares[i] = new TownSquare(price,towns[index], i);
                squares[i].purchasable = true;
                price += 20;
            }
        }
    }

    public Board(String message){
        this.message = message;
    }

    // prints the test message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

}
