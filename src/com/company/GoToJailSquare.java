package com.company;

public class GoToJailSquare extends Square {

	public GoToJailSquare(String name, boolean purchasable, int position) {
		super(name, purchasable, position);
	}

	@Override
    public void Speak() {
		System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {

		Speak();
		System.out.println(player.getName() + " has to go Jail");
		player.piece.position = 10 ;
		player.isInJail = true ;

		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
