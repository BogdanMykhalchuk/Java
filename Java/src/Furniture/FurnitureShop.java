package Furniture;

public abstract class FurnitureShop {
	private String name;
	private static int chairPrice = 20;
	private static int sofaPrice = 30;
	private static int hourlyPrice = 5;
	
	public FurnitureShop() {}
	
	public FurnitureShop(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getChairPrice() {
		return chairPrice;
	}
	
	public void setChairPrice(int chairPrice) {
		this.chairPrice = chairPrice;
	}
	
	public int getSofaPrice() {
		return sofaPrice;
	}
	
	public void setSofaPrice(int sofaPrice) {
		this.sofaPrice = sofaPrice;
	}
	
	public int getHourlyPrice() {
		return hourlyPrice;
	}
	
	public void setHourlyPrice(int hourlyPrice) {
		this.hourlyPrice = hourlyPrice;
	}
	
	public abstract int getWages();
}