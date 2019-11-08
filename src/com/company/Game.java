package com.company;

import java.util.Arrays;
import java.util.Random;

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

    String[] playernames = {"Vito", "Santino", "Michael", "Tom Hagen", "Fredo", "Clemenza", "Luca Brasi", "Vincent Mancini"};
    String[] pieces = {"Handgun", "Cigar", "Horse Head", "Alfa Romeo", "Cadillac", "Knife", "Fedora Hat", "Wineglass"};

    public void play(int numOfPlayer, int startMoney, int goMoney, int numOfTaxSquare, int taxAmount){

        System.out.println("\n\nThe Game Has Begun!");
        System.out.println("\nMonopoly Game: Godfather Edition!\n\n");
        System.out.println("============================");

        this.numOfPlayer = numOfPlayer;
        this.inGamePlayers = numOfPlayer; // **************** //
        this.cycle = 0;
        this.startMoney = startMoney;

        Player[] players = new Player[numOfPlayer];
        Board board = new Board(goMoney, numOfTaxSquare, taxAmount);
        int[] balances = new int[numOfPlayer];

        Randomize(playernames);
        Randomize(pieces);

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        int i;
        for(i = 0; i < numOfPlayer; i++){
            Piece piece = new Piece(0, pieces[i]);
            Player player = new Player(playernames[i], i + 1, startMoney, piece);
            players[i] = player;
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
                    players[i].balance -= taxAmount;
                }
                else if(board.squares[players[i].piece.position].name == "Start"){
                    board.squares[players[i].piece.position].Speak();
                    System.out.println("So, " + players[i].name + " earn " + goMoney + "$");
                    players[i].balance += goMoney;
                }
                else{
                    System.out.print("empty!");
                    //board.squares[players[i].piece.position].Speak();
                }
                balances[i] = players[i].balance;
                System.out.println("Current balance of " + players[i].name + " is " + players[i].balance + "$");
            }
            Arrays.sort(balances);
            System.out.println("");
            cycle++;
        }
    }
}
