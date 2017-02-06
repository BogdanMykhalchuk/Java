package Furniture;

public class ProductivityEmployee extends FurnitureShop {
	private int numberOfChairs;
	private int numberOfSofas;

	public ProductivityEmployee() {
	}

	public ProductivityEmployee(String name, int numberOfChairs,
								int numberOfSofas) {
		super(name);
		this.numberOfChairs = numberOfChairs;
		this.numberOfSofas = numberOfSofas;
	}

	public int getNumberOfChairs() {
		return numberOfChairs;
	}

	public void setNumberOfChairs(int numberOfChairs) {
		this.numberOfChairs = numberOfChairs;
	}

	public int getNumberOfSofas() {
		return numberOfSofas;
	}

	public void setNumberOfSofas(int numberOfSofas) {
		this.numberOfSofas = numberOfSofas;
	}

	@Override
	public int getWages() {
		return getNumberOfChairs() * getChairPrice() + getNumberOfSofas() * getSofaPrice();
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%d;%d\n", getName(), getNumberOfChairs(), getNumberOfSofas(),
				getWages());
	}
}