package com.company;
public class TownsSquare extends Square {

	int price;
	private int rent ;
	String color ;
	private boolean CanBuild = false;
	private int HotelPrice;

	public TownsSquare(String name, boolean purchasable, int position, int price, String color) {
		super(name, purchasable, position);
		this.price = price;
		this.color = color ;
		this.rent = price / 4 ;
		this.HotelPrice = price * 4;
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
				Dice dice2 = new Dice();
				int face2 = (dice2.rand.nextInt(6) + 1);
				if(face2>=4){
					System.out.println("Dice Value:" + face2 + " " +  player.getName() + " want to buy " + getName() + " for " + price);
					setOwner(player);

					switch (this.color) {
						case "Color1":
							player.setColor1(1);
							break;
						case "Color2":
							player.setColor1(2);
							break;
						case "Color3":
							player.setColor1(3);
							break;
						case "Color4":
							player.setColor1(4);
							break;
						case "Color5":
							player.setColor1(5);
							break;
						case "Color6":
							player.setColor1(6);
							break;
						case "Color7":
							player.setColor1(7);
							break;
					}
					player.reduceBalance(price);
				}
				else{
					System.out.println("Dice Value:" + face2 + " " + player.getName() + " don't want to buy " + getName());
				}

			}
			else{
				System.out.println(player.getName() + " can't buy " + getName());

			}
		}

		else{

			switch (this.color) {
				case "Color1":
					if (player.getColor1() == 3) {
						CanBuild = true;
					}
					break;
				case "Color2":
					if (player.getColor2() == 3) {
						CanBuild = true;
					}
					break;
				case "Color3":
					if (player.getColor3() == 3) {
						CanBuild = true;
					}
					break;
				case "Color4":
					if (player.getColor4() == 3) {
						CanBuild = true;
					}
					break;
				case "Color5":
					if (player.getColor5() == 3) {
						CanBuild = true;
					}
					break;
				case "Color6":
					if (player.getColor6() == 3) {
						CanBuild = true;
					}
					break;
				case "Color7":
					if (player.getColor7() == 3) {
						CanBuild = true;
					}
					break;
			}


			if(getOwner() != player){
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + getOwner().getName() + ".");
				player.reduceBalance(rent);
				getOwner().addBalance(rent);
			}

			else if(getOwner() == player){
			System.out.println(player.getName() + " is the owner of this " + getName() );
				if(CanBuild && player.getMoney().getAmount() > HotelPrice){
					Dice dice2 = new Dice();
					int face2 = (dice2.rand.nextInt(6) + 1);
					if(face2>=4){
						System.out.println("Dice Value:" + face2 + " " +  player.getName() + " want to build a hotel here for $" + HotelPrice );
						player.reduceBalance(HotelPrice);
						this.rent = rent*2;
					}
				}
			}

		}
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");
	}
}

