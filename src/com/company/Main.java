package com.company;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    String message;

    public Main() {

    }


    @Test
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totPlayer = 0, placesNumber=0;
        String places[];
        while (totPlayer < 2 || totPlayer > 8) {
            try {
                System.out.println("Please enter the number of total players..");
                System.out.print("Total players should be between 2 and 8:  ");
                totPlayer = scanner.nextInt();
            }
            catch(Exception e) {
                System.err.println("Error: Total players should be between 2 and 8.");
                continue;
            }
            if(totPlayer > 8) {
                System.err.println("Error: Invalid player count.");
            }
        }
        System.out.println("How many do you want places?");
        placesNumber=scanner.nextInt();

        places = new String[placesNumber];

        for (int i=0; i < placesNumber;i++){
            System.out.println("Choose place names?");
            places[i] = scanner.next();
        }

        scanner.close();
        //Main main = new Main(totPlayer,places);
        Board board = new Board(5000,100,2);
    }

    /*public Main(int totalPlayer, String [] places) {
        Board board = new Board(5000,100,2);
    }*/

    // prints the test message
    public String printMessage(){
        System.out.println(message);
        return message;
    }
}
