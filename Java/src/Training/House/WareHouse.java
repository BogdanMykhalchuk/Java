package Training.House;

public class WareHouse extends House {
	private int packages;
	
	public WareHouse() {}
	
	public WareHouse(int floors, String wasBuild, int packages) {
		super(floors, wasBuild);
		this.packages = packages;
	}
	
	public int getPackages() {
		return packages;
	}
	
	public void addPackages(int income) {
		packages+=income;
	}
	
	public void removePackages(int outcome) {
		packages-=outcome;
	}
	
	@Override
	public String getType() {
		return "WareHouse";
	}
	
	@Override
	public String toString() {
		return String.format("%d;%s;%d;%s;%d\n", getFloors(), getWasBuild(), getPackages(),
		getType(), getAge());
	}
}