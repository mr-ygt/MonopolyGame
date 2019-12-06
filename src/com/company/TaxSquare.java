package com.company;

public class TaxSquare extends Square {

    int taxAmount;

    public TaxSquare(String name, boolean purchasable, int position, int taxAmount) {
		super(name, purchasable, position);
		this.taxAmount = taxAmount;
	}

	public int getTaxAmount(){
        return taxAmount;
    }
    public void setTaxAmount(int tax){
        taxAmount = tax;
    }

    @Override
    public void Speak() {
    	System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {
		Speak();
        System.out.println("So, " + player.getName() + " has to give " + taxAmount + "$ for tax");
        player.reduceBalance(taxAmount);

        System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
