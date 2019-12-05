package com.company;

public class RailRoadSquare extends Square {

	int price;
	int rent;

	public RailRoadSquare(String name, boolean purchasable, int position, int price, int rent) {
		super(name, true, position);
		this.price = price;
		this.rent = rent;
	}

	@Override
    public void Speak() {
		System.out.println("Name of the square is: " + getName());
    }

	@Override
	public void action(Player player, Board board) {
		board.squares[player.piece.position].Speak();

		if (board.squares[player.piece.position].owner== null){
			System.out.println("There is no owner of this " + getName());
			if (player.getMoney().amount >= price){
				Dice dice1 = new Dice();
				int face1 = (dice1.rand.nextInt(6) + 1);
				if(face1>=4){
					System.out.println("Dice Value: "+ face1 + player.getName() + " want to buy " + getName() + " for " + price);
					board.squares[player.piece.position].owner = player;
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
			if(board.squares[player.piece.position].owner!=player){
				System.out.println(player.getName() + " paid $" + rent + " rent to owner " + board.squares[player.piece.position].owner.getName() + ".");
				player.reduceBalance(rent);
				board.squares[player.piece.position].owner.addBalance(rent);
			}

			else if(board.squares[player.piece.position].owner == player){
			System.out.println(player.getName() + " is the owner of this " + getName() );
			}

		}
	}
}


