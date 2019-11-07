public class Player extends MonopolyGame {

    // Money, piece , sequence of player
    private int money;
    private int piece;
    private int sequence;

    // Default constructor
    public Player() {

    }

    // Constructor with parameters
    public Player(int money, int piece, int sequence) {
        this.money = money;
        this.piece = piece;
        this.sequence = sequence;
    }

    // Method for rolling 2 dice, it returns number between 2 and 12.
    private static int dice() {
        int dice = (int) Math.floor(Math.random() * 13);
        while (dice == 0 || dice == 1) {
            dice = (int) Math.floor(Math.random() * 13);
        }
        return dice;
    }

    // Rolling dice
    private static int dice = dice();

    // Getter method for private variable
    public static int getDice() {
        return dice;
    }

}