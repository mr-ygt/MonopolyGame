package com.company;

public class CarPark extends Square {

	public CarPark(String name, boolean purchasable, int position) {
		super(name, false, position);
	}

	@Override
	public void Speak() {
		System.out.println("Name of the square is: CarPark");

	}

	@Override
	public void action(Player player, Board board) {

		board.squares[player.piece.position].Speak();

	}

}
