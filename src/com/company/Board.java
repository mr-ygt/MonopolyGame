package com.company;

import java.util.Random;

public class Board {

    int numOfTaxSquare;

    String[] towns = {"Kasimpasa", "Dolapdere", "Sultanahmet", "Karakoy", "Sirkeci", "Beyoglu", "Besiktas",
            "Taksim", "Harbiye", "Sisli", "Mecidiyekoy", "Bostanci", "Erenkoy", "Caddebostan" + "Nisantasi",
            "Tesvikiye", "Macka", "Levent", "Etiler", "Bebek", "Tarabya", "Yenikoy", "Sicilya", "NewYork"};

    String message;


    Square[] squares = new Square[40];
    Card[] cards = new Card[10];
    public Board(int goMoney, int taxAmount){
        int price = 100;
        int index = 0;
        for(int i = 0; i < 10; i++){
            if(i%5 == 0)    cards[i] = new Card(1, "Go To Jail!");
            else if(i%5 == 1)   cards[i] = new Card(2, "Add Money: 500$");
            else if(i%5 == 2)   cards[i] = new Card(3, "Reduce Money: 200$");
            else if(i%5 == 3)   cards[i] = new Card(4, "Again Roll Dice!");
            else if(i%5 == 4)   cards[i] = new Card(5, "Go To Vacation!");
        }
        for(int i = 0; i < 40; i++){
            squares[i].purchasable = false;
            if(i == 0)
                squares[0] = new GoSquare("Start",false , goMoney);
            else if(i == 2 || i == 17 || i == 33){
                squares[i] = new EmptySquare("Empty", false, i);
            }
            else if(i == 4 || i == 38){
                squares[i] = new TaxSquare("Tax Square",false , i, taxAmount);
            }
            else if(i == 5 || i == 15 || i == 25 || i == 35){
                squares[i] = new RailRoadSquare("Rail Road Square", true, i, price, price/2);
            }
            else if(i == 7 || i == 22 || i == 36){
                squares[i] = new LuckyCardSquare();
            }
            else if(i == 10){
                squares[i] = new JailSquare("Jail", false, i);
            }
            else if(i == 20){
                squares[i] = new CarPark("Car Park", false, i);
            }
            else if(i == 30){
                squares[i] = new GoToJailSquare("Go to Jail", false, i);
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
