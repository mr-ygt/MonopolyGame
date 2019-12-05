package com.company;

import java.util.Random;

public class LuckyCardSquare extends Square {
    @Override
    public void Speak() {

    }

    @Override
    public void action(Player player, Board board) {

    }


    public void action(){
        int type = (int)(Math.random()*5 + 1);
        Card card = new Card(type);
        card.getCard(card.type);
    }

}
