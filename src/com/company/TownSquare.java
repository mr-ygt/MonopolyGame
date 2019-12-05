package com.company;

public class TownSquare extends Square {

    int price;

    public TownSquare(int price, String name, int position){
        this.price = price;
    }

    @Override
    public void Speak() {

    }

    @Override
    public void action(Player player, Board board) {

    }
}
