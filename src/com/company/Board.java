package com.company;

import java.util.Random;

public class Board {

    int numOfDice;

    String[] towns = {"Kasimpasa", "Dolapdere", "Sultanahmet", "Karakoy", "Sirkeci", "Beyoglu", "Besiktas",
            "Taksim", "Harbiye", "Sisli", "Mecidiyekoy", "Bostanci", "Erenkoy", "Caddebostan" + "Nisantasi",
            "Tesvikiye", "Macka", "Levent", "Etiler", "Bebek", "Tarabya", "Yenikoy"};

    String message;


    Square[] squares = new Square[40];
    Card[] cards = new Card[10];
    public Board(int goMoney, int taxAmount, int numOfDices){
        this.numOfDice = numOfDices;
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
            if(i == 0)
                squares[0] = new GoSquare("Start",false , goMoney);
            else if(i == 2 || i == 17 || i == 33){
                squares[i] = new CommunityChestSquare("Community Chest ", false, i);
            }
            else if(i == 4){
                squares[i] = new TaxSquare("Income Tax",false , i, taxAmount);
            }
            else if(i == 38){
                squares[i] = new TaxSquare("Luxury Tax",false , i, taxAmount);
            }
            else if(i == 5){
                squares[i] = new RailRoadSquare("Reading Rail Road", true, i, 200);
            }
            else if(i == 15){
                squares[i] = new RailRoadSquare("Pennsylvania Rail Road", true, i, 200);
            }
            else if(i == 25){
                squares[i] = new RailRoadSquare("B&O Rail Road", true, i, 200);
            }
            else if(i == 35){
                squares[i] = new RailRoadSquare("Short Line", true, i, 200);
            }
            else if(i == 7 || i == 22 || i == 36){
                squares[i] = new LuckyCardSquare("Lucky Card Square", false, i);
            }
            else if(i == 10){
                squares[i] = new JailSquare("Jail", false, i);
            }
            else if(i == 20){
                squares[i] = new FreeParkingSquare("Free Parking ", false, i);
            }
            else if(i == 30){
                squares[i] = new GoToJailSquare("Go to Jail", false, i);
            }
            else if(i == 12){
                squares[i] = new UtilitySquare("Electric Company", true, i, 150);
            }
            else if(i == 28){
                squares[i] = new UtilitySquare("Water Works", true, i, 150);
            }
            else{
                squares[i] = new TownsSquare(towns[index],true, i, price);
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
