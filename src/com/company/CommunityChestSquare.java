package com.company;

public class CommunityChestSquare extends Square {

	public CommunityChestSquare(String name, boolean purchasable, int position) {
		super(name, purchasable, position);
	}

	@Override
    public void Speak() {
    	System.out.println("Name of the square is: " + getName());
    }

	static int counter = 0;

	@Override
	public void action(Player player, Board board) {

		Speak();
		Card card = board.ChestCards[counter%16];
		player.getCard(card, board);
		counter++;
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
