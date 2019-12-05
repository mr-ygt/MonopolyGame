package com.company;

public class GoSquare extends Square {

    int goMoney;

    public GoSquare(String name, boolean purchasable, int goMoney){
        super(name, false, 0);
        this.goMoney = goMoney;
        this.position = 0;
    }

    public int getGoMoney(){
        return goMoney;
    }
    public void setGoMoney(int goMoney){
        this.goMoney = goMoney;
    }

    @Override
    public void Speak(){
        System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {

		board.squares[player.piece.position].Speak();
        System.out.println("So, " + player.name + " earn " + goMoney + "$");
        player.addBalance(goMoney);

	}
}
