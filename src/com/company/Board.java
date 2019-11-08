package com.company;

import java.util.Random;

public class Board {

    int numOfTaxSquare;

    Square[] squares = new Square[40];
    String message;

    public Board(int goMoney, int numOfTaxSquare, int taxAmount){
        this.addSquare(createGoSquare(goMoney), 1);
        this.numOfTaxSquare = numOfTaxSquare;
        this.addSquare(createTaxSquare(taxAmount), numOfTaxSquare);
        this.addSquare(createEmptySquare(), 39-numOfTaxSquare);

    }

    public void addSquare(Square square, int number){
        Random rand;
        if(square instanceof GoSquare){
            squares[0] = square;
            return;
        }
        for(int i = 0; i < number; i++){
            rand = new Random();
            int random = (rand.nextInt(39) + 1);
            while(squares[random] != null){
                random = (rand.nextInt(39) + 1);
            }
            squares[random] = square;
            square.position = random;
        }
    }

    public Square createGoSquare(int goMoney){
        GoSquare goSquare = new GoSquare("Start", goMoney);
        return goSquare;
    }

    public Square createTaxSquare(int taxAmount){
        TaxSquare square = new TaxSquare("Tax Square", taxAmount);
        return square;
    }

    public Square createEmptySquare(){
        Square square = new Square();
        return square;
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
