package com.company;

public class JailSquare extends Square {

    public JailSquare(String name, boolean purchasable, int position) {
		super(name, purchasable, position);
	}

    @Override
	public void Speak(){
        System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {

		Speak();
		System.out.println("So, " + player.getName() + " can't move ");
		player.isInJail = true;
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
