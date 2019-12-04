package com.company;

public class Card {

    int type;
    String description;

    /**
     * type1: goToJail
     * type2: addMoney(500)
     * type3: reduceMoney(250)
     * type4: againRollDice
     * type5: goToVacation
     */

    public void getCard(int type){
        switch(type){
            case 1:
                System.out.print("Go to jail!");

                break;
            case 2:
                System.out.print("Add money");
                break;
            case 3:

            default:
                System.out.print("default");
        }
    }

    public Card(int type){
        this.type = type;

    }
}
