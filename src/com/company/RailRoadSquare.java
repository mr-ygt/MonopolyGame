package com.company;

public class RailRoadSquare extends Square {

	int price;
	private int rent;

	public RailRoadSquare(String name, boolean purchasable, int position, int price) {
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



		if (getOwner() == null){
			System.out.println("There is no owner of this " + getName());
			if (player.getMoney().getAmount() >= price){
				Dice dice1 = new Dice();
				int face1 = (dice1.rand.nextInt(6) + 1);
				if(face1>=4){
					System.out.println("Dice Value:" + face1 + " " + player.getName() + " want to buy " + getName() + " for " + price);
					setOwner(player);
					getOwner().setRailRoad(1);
					player.reduceBalance(price);
				}
				else{
					System.out.println("Dice Value:" + face1 + " " + player.getName() + " don't want to buy " + getName());
				}

			}
			else{
				System.out.println(player.getName() + " can't buy " + getName());

			}
		}

		else{
			if(getOwner().getRailRoad() == 1){
				this.rent = 25;
			}
			else if(getOwner().getRailRoad() == 2){
				this.rent = 50;
			}
			else if(getOwner().getRailRoad() == 3){
				this.rent = 100;
			}
			else if(getOwner().getRailRoad() == 4){
				this.rent = 150;
			}
			if(getOwner() !=player){
				System.out.println(player.getName() + " paid $" + rent + " rent to " + getOwner().getName() + ".");
				player.reduceBalance(rent);
				getOwner().addBalance(rent);
			}

			else if(getOwner() == player){
			System.out.println(player.getName() + " is the owner of this " + getName() );
			}

		}

		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}
