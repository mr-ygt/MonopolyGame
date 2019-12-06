package com.company;
public class TownsSquare extends Square {

	int price;
	int rent;

	public TownsSquare(String name, boolean purchasable, int position, int price) {
		super(name, purchasable, position);
		this.price = price;
	}

	@Override
    public void Speak() {
		System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {
		Speak();

		if (owner== null){
			System.out.println("There is no owner of this " + getName());
			if (player.getMoney().getAmount() >= price){
				Dice dice2 = new Dice();
				int face2 = (dice2.rand.nextInt(6) + 1);
				if(face2>=4){
					System.out.println("Dice Value: "+ face2 + player.getName() + " want to buy " + getName() + " for " + price);
					owner = player;
					player.reduceBalance(price);
				}
				else{
					System.out.println(player.getName() + " don't want to buy " + getName());
				}

			}
			else{
				System.out.println(player.getName() + " can't buy " + getName());

			}
		}

		else{
			if(owner != player){
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + owner.getName() + ".");
				player.reduceBalance(rent);
				owner.addBalance(rent);
			}

			else if(owner == player){
			System.out.println(player.getName() + " is the owner of this " + getName() );
			}

		}
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}

