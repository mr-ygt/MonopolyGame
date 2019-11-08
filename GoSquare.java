package com.company;

public class GoSquare extends Square {

    int goMoney;

    public GoSquare(String name, int goMoney){
        super(name);
        this.goMoney = goMoney;
        this.position = 0;
    }

    public int getGoMoney(){
        return goMoney;
    }
    public void setGoMoney(int goMoney){
        this.goMoney = goMoney;
    }


}
