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

    public Card(int type, String description){
        this.type = type;
        this.description = description;
    }


    public void action(Player player, Board board){
        switch(this.type){
            case 1:
                System.out.println(this.description);
                board.squares[10].action(player, board);
                player.piece.position = 10;
                player.reduceBalance(200);
                break;
            case 2:
                System.out.println(this.description);
                player.addBalance(500);
                break;
            case 3:
                System.out.println(this.description);
                player.reduceBalance(250);
            case 4:
                System.out.println(this.description);
                player.move(player.piece, board.dice1, board.dice2);
            case 5:
                System.out.println(this.description);
                //vacation.
            default:
                System.out.print("default");
        }

    }

}
