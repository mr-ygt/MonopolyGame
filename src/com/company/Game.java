package com.company;

import java.util.*;

public class Game {

    int numOfPlayer;
    public int inGamePlayers;
    public int cycle = 1;

    public Game(){

    }

    public static void Randomize(String[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randPos = rand.nextInt(arr.length);
            String tmp = arr[i];
            arr[i] = arr[randPos];
            arr[randPos] = tmp;
        }
    }

    String[] playerNames = {"Vito",  "Santino", "Michael", "Tom Hagen", "Fredo", "Clemenza", "Luca Brasi", "Vincent Mancini"};
    String[] pieces = {"Handgun", "Cigar", "Horse Head", "Alfa Romeo", "Cadillac", "Knife", "Fedora Hat", "Wineglass"};

    int number;
    public void play(){
        Scanner input;
        boolean flag;
        int numOfPlayer= 0, goMoney = 0, taxAmount = 0, numOfDice = 0;
        Money startMoney = new Money();
        System.out.print("Enter the number of player (2-8): ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer between 2 and 8: ");
                flag = true;
            }else{
                numOfPlayer = input.nextInt();
                if(numOfPlayer >= 2 && numOfPlayer <= 8){
                    flag = false;
                }else{
                    System.out.print("Wrong input! Please enter an integer between 2 and 8: ");
                    flag = true;
                }
            }
        }while(flag);
        System.out.print("Enter the amount of money each player starts with: ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer: ");
                flag = true;
            }else{
                startMoney.setAmount(input.nextInt());
                flag = false;
            }
        }while(flag);
        System.out.print("Enter the amount of money each player's token lands on or passes over GO: ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer: ");
                flag = true;
            }else{
                goMoney = input.nextInt();
                flag = false;
            }
        }while(flag);
      /*  System.out.print("Enter the number of Tax Square: ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer: ");
                flag = true;
            }else{
                numOfTaxSquare = input.nextInt();
                if(numOfTaxSquare >= 0 && numOfTaxSquare <= 39){
                    flag = false;
                }else{
                    System.out.print("Wrong input! Please enter an integer between 0 and 39: ");
                    flag = true;
                }
            }
        }while(flag);*/
        System.out.print("Enter the amount of money for tax: ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer: ");
                flag = true;
            }else{
                taxAmount = input.nextInt();
                flag = false;
            }
        }while(flag);

        System.out.print("Enter the number of dice: ");
        do{
            input = new Scanner(System.in);
            if(!input.hasNextInt()){
                System.out.print("Wrong input! Please enter an integer: ");
                flag = true;
            }else{
                numOfDice = input.nextInt();
                if(numOfDice >= 2){
                    flag = false;
                }else{
                    System.out.print("Wrong input! Please enter an integer that bigger than 1: ");
                    flag = true;
                }
            }
        }while(flag);

        this.numOfPlayer = numOfPlayer;
        inGamePlayers = numOfPlayer; // **************** //
        cycle = 1;

        Player[] players = new Player[numOfPlayer];
        Player[] balances = new Player[numOfPlayer];
        Board board = new Board(goMoney, taxAmount, numOfDice);

        Randomize(playerNames);
        Randomize(pieces);
        //Randomize(board.cards); it will work on next step.

        for(int i = 0; i < numOfPlayer; i++){
            Piece piece = new Piece(0, pieces[i]);
            Player player = new Player(playerNames[i], i + 1, startMoney, piece);
            players[i] = player;
            balances[i] = player;
        }

        System.out.println("\n\nThe Game Has Begun!");
        System.out.println("\nMonopoly Game: Godfather Edition!\n\n");
        System.out.println("============================");

        while(inGamePlayers > 1){
            for(int i = 0; i < numOfPlayer; i++){
                System.out.print("Cycle -> " + cycle + " | ");
                players[i].Speak();
                board.squares[players[i].piece.position].Speak();

                //rolling dice and move the piece of player on turn.
                players[i].piece.position = players[i].move(players[i].piece, numOfDice);

                board.squares[players[i].piece.position].action(players[i], board);
                /*
                if(board.squares[players[i].piece.position].getName() == "Tax Square"){
                    board.squares[players[i].piece.position].Speak();
                    System.out.println("So, " + players[i].name + " has to give " + taxAmount + "$ for tax");
                    players[i].reduceBalance(taxAmount);
                }
                else if(board.squares[players[i].piece.position].getName() == "Start"){
                    board.squares[players[i].piece.position].Speak();
                    System.out.println("So, " + players[i].name + " earn " + goMoney + "$");
                    players[i].addBalance(goMoney);
                }
                else{
                    board.squares[players[i].piece.position].Speak();
                }*/
                //System.out.println("Current balance of " + players[i].name + " is " + players[i].money.getAmount() + "$");
            }

            Arrays.sort(balances);
            for(int i = numOfPlayer-1; i >= 0; i--){
                System.out.println(balances[i].name + ": " + balances[i].money.getAmount());
            }
            for(int i = 0; i < numOfPlayer; i++){
                if(players[i].isBrokeOut()){
                    System.out.println(players[i].name + " is disqualified!");
                    number = i;
                    for (int j = (i+1); j < numOfPlayer; j++){
                        if(i != (numOfPlayer-1)){
/*
                            for(int k = 0; k < numOfPlayer; k++){
                                    if(players[i] == balances[k]){
                                        for(int m = (k+1); m < numOfPlayer; m++){

                                        }
                                        //balances[k] = null;
                                    }
                            }
*/
                            players[j].turn--;
                            players[i] = null;
                            players[i] = players[j];
                            players[j] = null;
                            i++;

                        }
                    }
                    i = number-1;
                    inGamePlayers--;
                    numOfPlayer--;
                }
            }balances = players;
/*
            if(balances[1].money.getAmount() < -2000){
                System.exit(1);
            }
*/

            System.out.println("");
            cycle++;
        }
        System.out.print("hello");
    }

}
