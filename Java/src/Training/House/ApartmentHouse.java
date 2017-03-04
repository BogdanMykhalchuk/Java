package Training.House;

public class ApartmentHouse extends House {
	private int residents;
	
	public ApartmentHouse() {}
	
	public ApartmentHouse (int floors, String wasBuild, int residents) {
		super(floors, wasBuild);
		this.residents = residents;
	}
	
	public int getResidents() {
		return residents;
	}
	
	public void addResidents(int moovedin) {
		residents+=moovedin;
	}
	
	public void removeResidents(int moovedout) {
		residents-=moovedout;
	}
	
	@Override
	public String getType() {
		return "ApartmentHouse";
	}
	
	@Override
	public String toString() {
		return String.format("%d;%s;%d;%s;%d\n", getFloors(), getWasBuild(), getResidents(),
		getType(), getAge());
	}
}