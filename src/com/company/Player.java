package com.company;

public class Player implements Comparable<Player> {
    //these following lines are attributes of player.
    private String name;
    public int turn;
    Money money;
    public Piece piece;
    public int twiceCounter = 0;
    public boolean isDouble = true;
    public boolean isInJail = false ;

    //these 3 lines are properties.(tapu)
    private int Utility;
    private int RailRoad;
    private int color1, color2, color3, color4, color5, color6, color7;

    public int inJail;

    public Player(){

    }

    public Player(String name, int turn, Money money, Piece piece){   //this constructor creates new player based on given parameters.
        this.money = new Money(money.getAmount());
        this.turn = turn;
        this.name = name;
        this.piece = piece;
    }
    public void getCard(Card card, Board board){
        //int type = card.type;
        card.action(this, board);
    }
    //these two methods set the balance.
    public void reduceBalance(int amount){
        this.money.subtractMoney(amount);
    }
    public void addBalance(int amount){
        this.money.addMoney(amount);
    }

    public int move(Piece piece, int dices){   //this method rolls the dices and moves the piece of player based on result
        int step = this.roll(dices);                  //and returns the new position of piece of player.
        this.piece.position += step;
        this.piece.position = (this.piece.position%40);
        System.out.println(this.name + " is now located in Square " + this.piece.position);
        return piece.position;
    }

    public int roll(int dices){        //this method rolls the dices and returns the sum of them.
        int faces[] = new int[dices];
        int total = 0;
        Dice dice = new Dice();
        for(int i = 0; i < dices; i++){
            faces[i] = (dice.rand.nextInt(6) + 1);
        }
        for(int i = 0; i < faces.length-1; i++){
            if(faces[i] != faces[i+1]){
                this.isDouble = false;
                break;
            }
            else{
                this.isDouble = true;
            }
        }
        if(this.isDouble == true){
            this.twiceCounter++;
        }
        for(int i = 1; i < faces.length+1; i++){
            System.out.print("The " + i + ". dice: " + faces[i-1] + " ");
            total += faces[i-1];
        }
        System.out.println(" and the sum is " + total);

        return total;
    }

    public void Speak(){
        System.out.println("Now, it is " + name +"'s turn.");
        System.out.println(name + " is on " + turn + ". turn.");
        System.out.println(name + " is currently in Square " + piece.position + ".");
    }
    public boolean isBrokeOut(){
        if(money.getAmount() < 0) return true;
        else return false;
    }
    @Override
    public int compareTo(Player o) {
        return this.money.getAmount() - o.money.getAmount();
    }

    public String getName(){
    	return name;}

    public Money getMoney() {
		return money;
	}



	public int getUtility() {
        //Properties
		return this.Utility;
	}

	public void setUtility(int utility) {
		this.Utility += utility;
	}

	public int getRailRoad() {
		return this.RailRoad;
	}

	public void setRailRoad(int railRoad) {
		this.RailRoad += railRoad;
	}

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 += color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 += color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 += color3;
    }

    public int getColor4() {
        return color4;
    }

    public void setColor4(int color4) {
        this.color4 += color4;
    }

    public int getColor5() {
        return color5;
    }

    public void setColor5(int color5) {
        this.color5 += color5;
    }

    public int getColor6() {
        return color6;
    }

    public void setColor6(int color6) {
        this.color6 += color6;
    }

    public int getColor7() {
        return color7;
    }

    public void setColor7(int color7) {
        this.color7 += color7;
    }

}
