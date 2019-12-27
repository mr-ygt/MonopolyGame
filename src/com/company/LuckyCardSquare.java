package com.company;

import java.util.Random;

public class LuckyCardSquare extends Square {

    public LuckyCardSquare(String name, boolean purchasable, int position){
        super(name, purchasable, position);
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
        Card card = board.LuckyCards[counter%10];
        player.getCard(card, board);
        counter++;
        System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");

    }

}
