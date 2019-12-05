
public class Money {

	private double money;
	private char currency;

	public Money() {
		this(0);
	}

	public Money(double money) {
		this.money = money;
		this.currency = '$';
	}

	public double getMoney() {
		return money;
	}

	public void setMoneyAmount(double money) {
		this.money = money;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public void addMoney(int amount) {
		money += amount;
	}

	public void substractMoney(int amount) {
		money -= amount;
	}

	public boolean isBrokeOut() {
		return money < 0;
	}

}