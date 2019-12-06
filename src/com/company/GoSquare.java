package com.company;

public class GoSquare extends Square {

    int goMoney;

    public GoSquare(String name, boolean purchasable, int goMoney){
        super(name, purchasable, 0);
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

		Speak();
        System.out.println("So, " + player.getName() + " earn " + goMoney + "$");
        player.addBalance(goMoney);

        System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}

