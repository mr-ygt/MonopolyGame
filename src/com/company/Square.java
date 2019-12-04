package com.company;

public abstract class Square {

    String name;
    int position = 0;
    boolean purchasable;

    public Square(){

    }

    public Square(String name, boolean purchasable, int position){
        this.name = name;
        this.purchasable = purchasable;
        this.position = position;
    }

    public abstract void Speak();

}
