package com.company;

public class Player {
    //these following lines are attributes of player.
    public String name;
    public int turn;
    public int balance;
    public Piece piece;
    public int twiceCounter = 0;
    public boolean isDouble = false;

    public Player(){

    }

    public Player(String name, int turn, int balance, Piece piece){   //this constructor creates new player based on given parameters.
        this.balance = balance;
        this.turn = turn;
        this.name = name;
        this.piece = piece;
    }

    public void reduceBalance(int amount){  //these two methods set the balance.
        balance -= amount;
    }
    public void addBalance(int amount){
        balance += amount;
    }

    public int move(Piece piece, Dice dice1, Dice dice2){   //this method rolls the dices and moves the piece of player based on result
        int step = this.roll(dice1,dice2);                  //and returns the new position of piece of player.
        this.piece.position += step;
        this.piece.position = (this.piece.position%40);
        System.out.println(this.name + " is now located in Square " + this.piece.position);
        return piece.position;
    }

    public int roll(Dice dice1, Dice dice2){        //this method rolls the dices and returns the sum of them.
        int face1 = (dice1.rand.nextInt(6) + 1);
        int face2 = (dice2.rand.nextInt(6) + 1);

        if(face1 == face2){
            this.twiceCounter++;
            this.isDouble = true;
        }
        System.out.println("First dice: " + face1 + ", the Second dice: " + face2 + " and the sum is " + (face1 + face2));
        return (face1 + face2);
    }

    public void Speak(){
        System.out.println("Now, it is " + this.name +"'s turn.");
        System.out.println(this.name + " is on " + this.turn + ". turn.");
        System.out.println(this.name + " is currently in Square " + this.piece.position + ".");
    }
}
