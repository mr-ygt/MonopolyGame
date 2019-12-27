package com.company;

import java.util.Random;

public class Board {

    int numOfDice;

    String[] towns = {"Kasimpasa", "Dolapdere", "Sultanahmet", "Karakoy", "Sirkeci", "Beyoglu", "Besiktas",
            "Taksim", "Harbiye", "Sisli", "Mecidiyekoy", "Bostanci", "Erenkoy", "Caddebostan" , "Nisantasi",
            "Tesvikiye", "Macka", "Levent", "Etiler", "Bebek", "Tarabya"};

    String message;


    Square[] squares = new Square[40];
    Card[] LuckyCards = new Card[10];
    Card[] ChestCards = new Card[16];
    String[] colors = {"Color1", "Color2", "Color3", "Color4","Color5", "Color6", "Color7"};
    public Board(int goMoney, int taxAmount, int numOfDices){
        this.numOfDice = numOfDices;
        int price = 100;
        int index = 0;
        int c = 0;
        for(int i = 0; i < 10; i++){
            if(i%5 == 0)    LuckyCards[i] = new Card(1, "Go To Jail!");
            else if(i%5 == 1)   LuckyCards[i] = new Card(2, "Add Money: 500$");
            else if(i%5 == 2)   LuckyCards[i] = new Card(3, "Reduce Money: 200$");
            else if(i%5 == 3)   LuckyCards[i] = new Card(4, "Again Roll Dice!");
            else if(i%5 == 4)   LuckyCards[i] = new Card(5, "Go To Vacation!");
        }

        for(int j = 0; j < 16; j++){
            if(j%8 == 0)    ChestCards[j] = new Card(6, "Advance to \"Go\".");
            else if(j%8 == 1)   ChestCards[j] = new Card(7, "Bank error in your favor.");
            else if(j%8 == 2)   ChestCards[j] = new Card(8, "Doctor's fees.");
            else if(j%8 == 3)   ChestCards[j] = new Card(9, "Go to Jail.");
            else if(j%8 == 4)   ChestCards[j] = new Card(10, "It is your birthday.");
            else if(j%8 == 5)   ChestCards[j] = new Card(11, "Hospital Fees.");
            else if(j%8 == 6)   ChestCards[j] = new Card(12, "School fees.");
            else if(j%8 == 7)   ChestCards[j] = new Card(13, "You inherit $100.");
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
            else if(i == 23){//////////////yeniiii
                squares[i] = new UtilitySquare("Water Works #2", true, i, 150);
            }
            else {

                squares[i] = new TownsSquare(towns[index],true, i, price, colors[c]);
                price += 20;
                index++;

                if(index %3 == 0 ){
                    c++;
                }
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
