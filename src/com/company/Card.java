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
                player.piece.position = 10;
                player.isInJail = true ;
                //board.squares[10].action(player, board);
                //player.reduceBalance(200);
                break;
            case 2:
                System.out.println(this.description);
                player.addBalance(500);
                break;
            case 3:
                System.out.println(this.description);
                player.reduceBalance(200);
                break;
            case 4:
                System.out.println(this.description);
                player.move(player.piece,board.numOfDice);
                break;
            case 5:
                System.out.println(this.description);
                //vacation.
                break;
            case 6:
                System.out.println(this.description);
                System.out.println(player.getName() + " goes to Go Square");
                player.piece.position = 0 ;
                player.addBalance(200);
                break;
            case 7:
                System.out.println(this.description);
                System.out.println("Collect $200.");
                player.addBalance(200);
                break;
            case 8:
                System.out.println(this.description);
                System.out.println("{fee} Pay $50.");
                player.reduceBalance(50);
                break;
            case 9:
                System.out.println(this.description);
                System.out.println(player.getName() + " has to go to Jail!");
                player.piece.position = 10;
                player.isInJail = true ;
                break;
            case 10:
                System.out.println(this.description);
                System.out.println("Collect $10 from every player.");
                player.addBalance(10 );
                break;
            case 11:
                System.out.println(this.description);
                System.out.println("Pay $100.");
                player.reduceBalance(100);
                break;
            case 12:
                System.out.println(this.description);
                System.out.println("Pay $150.");
                player.reduceBalance(150 );
                break;
            case 13:
                System.out.println(this.description);
               // System.out.println("You inherit $100.");
                player.addBalance(100 );
                break;

            default:
                System.out.print("default");
        }

    }

}
