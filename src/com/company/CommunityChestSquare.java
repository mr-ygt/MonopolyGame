package com.company;

public class CommunityChestSquare extends Square {

	public CommunityChestSquare(String name, boolean purchasable, int position) {
		super(name, purchasable, position);
	}

	@Override
    public void Speak() {
    	System.out.println("Name of the square is: " + getName());
    }


	@Override
	public void action(Player player, Board board) {

		Speak();
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
