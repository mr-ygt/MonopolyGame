package com.company;

public class JailSquare extends Square {

    public JailSquare(String name, boolean purchasable, int position) {
		super(name, false, position);
	}

    @Override
	public void Speak(){
		System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {

		board.squares[player.piece.position].Speak();
		System.out.println("So, " + player.name + " can't move ");

	}
}
