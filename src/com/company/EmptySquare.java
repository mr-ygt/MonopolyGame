package com.company;

public class EmptySquare extends Square {

	public EmptySquare(String name, boolean purchasable, int position) {
		super(name, false, position);
	}

	@Override
    public void Speak() {
    	//BU SQUARE ISMI DEGISMELI
		System.out.println("Name of the square is: " + getName());
    }




	@Override
	public void action(Player player, Board board) {

		board.squares[player.piece.position].Speak();

	}
}
