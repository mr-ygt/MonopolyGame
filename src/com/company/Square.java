package com.company;

public abstract class Square {

    private String name;
    int position = 0;
    Player owner = null;
	boolean purchasable;

    public Square(){

    }

    public Square(String name, boolean purchasable, int position){
        this.name = name;
        this.purchasable = purchasable;
        this.position = position;
    }

    public String getName() {
		return name;
	}

    public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public abstract void Speak();

    public abstract void action(Player player, Board board);

}
