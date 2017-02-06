package Customer;
class Rental { // write class rental in separete file
	private int kind;
	private int days;
	private double basePrice; // add another field and better to write price then prise
	
	public Rental(int kind, int days) {
		this.kind = kind;
		this.days = days;
	}
	
	public int getKind() {
		return kind;
	}
	
	public void setKind() {
		this.kind = kind;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays() {
		this.days = days;
	}
	
	public double getBasePrice() {
		return basePrice;		// get base price
	}
	
	public void setBasePrice() {
		this.basePrice = basePrice; // add setter for field "basePrice"
	}
	
	public double amountFor() { // we moved this method here because it uses methods and objects of class Rental
		double result;
		result = getDays() * getBasePrice();
		if(getKind() == 1) {
			result = result * 1.5;
		}
		
		if(getKind() == 2) {
			result = result * 2;
		}
		if(getKind() >= 3 && getKind() < 7) { // add additional condition to avoid missing result for int between 3 and 7
			result = result * 2.5;
		}
		
		if(getKind() > 7) {
			result = result * 3;
		}
		
		return result;
	}
}
			