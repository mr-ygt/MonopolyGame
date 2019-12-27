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
		//PutInJail(player);
    	System.out.println(player.getName() + " visits the jail. ");
		System.out.println("Current balance of " + player.getName() + " is " + player.getMoney().getAmount() + "$");

		/*if(player.isInJail = true){
			GetOutOfJail(player);
		}	 */
	}

	/*public void PutInJail(Player player){
    	player.isInJail = true;
	}

	public void GetOutOfJail(Player player){
		player.isInJail = false;
		player.inJail = 0;
	}*/
}
