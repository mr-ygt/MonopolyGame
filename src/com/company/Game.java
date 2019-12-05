package com.company;

import java.util.*;

public class Game {

    int numOfPlayer;
    public int inGamePlayers;
    public int cycle = 1;
    int startMoney;
    int goMoney;

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

    String[] playernames = {"Vito",  "Santino", "Michael", "Tom Hagen", "Fredo", "Clemenza", "Luca Brasi", "Vincent Mancini"};
    String[] pieces = {"Handgun", "Cigar", "Horse Head", "Alfa Romeo", "Cadillac", "Knife", "Fedora Hat", "Wineglass"};

    int number;
    public void play(){
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        int numOfPlayer= 0, startMoney = 0, goMoney = 0, numOfTaxSquare = 0, taxAmount = 0;
        Money money = new Money();
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
                money.setMoney(input.nextInt());
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
        System.out.print("Enter the number of Tax Square: ");
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
        }while(flag);
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

        System.out.println("\n\nThe Game Has Begun!");
        System.out.println("\nMonopoly Game: Godfather Edition!\n\n");
        System.out.println("============================");

        this.numOfPlayer = numOfPlayer;
        inGamePlayers = numOfPlayer; // **************** //
        this.cycle = 0;
        this.startMoney = money.getMoney();

        Player[] players = new Player[numOfPlayer];
        Board board = new Board(goMoney, taxAmount);
        Player[] balances = new Player[numOfPlayer];

        Randomize(playernames);
        Randomize(pieces);

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        int i;
        for(i = 0; i < numOfPlayer; i++){
            Piece piece = new Piece(0, pieces[i]);
            Player player = new Player(playernames[i], i + 1, money, piece);
            players[i] = player;
            balances[i] = player;
        }

        while(inGamePlayers > 1){
            for(i = 0; i < numOfPlayer; i++){
                System.out.print("Cycle -> " + cycle + " | ");
                players[i].Speak();
                board.squares[players[i].piece.position].Speak();

                //rolling dice and move the piece of player on turn.
                players[i].piece.position = players[i].move(players[i].piece, dice1,dice2);


                if(board.squares[players[i].piece.position].name == "Tax Square"){
                    board.squares[players[i].piece.position].Speak();
                    System.out.println("So, " + players[i].name + " has to give " + taxAmount + "$ for tax");
                    players[i].reduceBalance(taxAmount);
                }
                else if(board.squares[players[i].piece.position].name == "Start"){
                    board.squares[players[i].piece.position].Speak();
                    System.out.println("So, " + players[i].name + " earn " + goMoney + "$");
                    players[i].addBalance(goMoney);
                }
                else{
                    board.squares[players[i].piece.position].Speak();
                }
                System.out.println("Current balance of " + players[i].name + " is " + players[i].money.getMoney() + "$");
            }

            Arrays.sort(balances);
            for(i = numOfPlayer-1; i >= 0; i--){
                System.out.println(balances[i].name + ": " + balances[i].money.getMoney());
            }

            for(i = 0; i < numOfPlayer; i++){
                if(players[i].money.getMoney() < 0){
                    System.out.println(players[i].name + " is disqualified!");
                    number = i;
                    for (int j = (i+1); j < numOfPlayer; j++){
                        if(i != (numOfPlayer-1)){

                            for(int k = 0; k < numOfPlayer; k++){
                                    if(players[i] == balances[k]){
                                        //balances[k] = null;
                                    }
                            }
                            players[j].turn--;
                            players[i] = players[j];
                            players[j] = null;
                            i++;

                        }
                    }
                    i = number;
                    inGamePlayers--;
                    numOfPlayer--;
                }
            }

            if(balances[1].money.getMoney() < -2000){
                System.exit(1);
            }


            System.out.println("");
            cycle++;
        }
        System.out.print("hello");
    }

}
