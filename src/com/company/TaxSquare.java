package com.company;

public class TaxSquare extends Square {

    int taxAmount;

    public TaxSquare(String name, boolean purchasable, int position, int taxAmount) {
		super(name, false, position);
		this.taxAmount = taxAmount;
	}

	public int getTaxAmount(){
        return taxAmount;
    }
    public void setTaxAmount(int tax){
        this.taxAmount = tax;
    }

    @Override
    public void Speak() {
    	System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {
		board.squares[player.piece.position].Speak();
        System.out.println("So, " + player.name + " has to give " + taxAmount + "$ for tax");
        player.reduceBalance(taxAmount);

	}
}
