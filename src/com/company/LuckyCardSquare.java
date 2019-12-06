package com.company;

import java.util.Random;

public class LuckyCardSquare extends Square {

    public LuckyCardSquare(){

    }
    @Override
    public void Speak() {
        System.out.println("Name of the square is: " + getName());
    }
    static int counter = 0;
    @Override
    public void action(Player player, Board board) {
        this.Speak();
        //int type = (int)(Math.random()*4 + 1);    this will work if cards will random.
        Card card = board.cards[counter%10];
        player.getCard(card, board);
        counter++;
    }

}
