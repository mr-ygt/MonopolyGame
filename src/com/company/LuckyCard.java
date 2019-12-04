package com.company;

import java.util.Random;

public class LuckyCard extends Square {
    @Override
    public void Speak() {

    }



    public void action(){
        int type = (int)(Math.random()*5 + 1);
        Card card = new Card(type);
        card.getCard(card.type);
    }

}
