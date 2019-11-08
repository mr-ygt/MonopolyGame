package com.company;

public class Square {

    String name = "Empty!";
    int position = 0;

    public Square(){

    }

    public Square(String name){
        this.name = name;
    }

    public void Speak(){
        System.out.println("Name of the square is: " + this.name);
    }
}
