package com.company;

import java.util.Random;

public class LuckyCardSquare extends Square {
    @Override
    public void Speak() {
        System.out.println("Name of the square is: " + getName());
    }
    static int cardNumber = 0;
    @Override
    public void action(Player player, Board board) {
        board.squares[player.piece.position].Speak();
        int type = (int)(Math.random()*4 + 1);
        Card card = board.cards[cardNumber%10];
        player.getCard(card, board);
        cardNumber++;
    }

}
