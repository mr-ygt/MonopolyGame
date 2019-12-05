package com.company;

public class GoToJailSquare extends Square {

	public GoToJailSquare(String name, boolean purchasable, int position) {
		super(name, false, position);
	}

	@Override
    public void Speak() {
		System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {

		board.squares[player.piece.position].Speak();
		System.out.println(player + " has to go Jail");
		player.piece.position = 10 ;

	}
}