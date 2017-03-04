package Training.Figures;

public class PlaneFigures extends Figures {
	private int area;
	PlaneFigures() {}
	PlaneFigures(String name, String color, int angles, int area) {
		super(name, color, angles);
		this.area = area;
	}
	
	public int getArea() {
		return area;
	}
	
	@Override
    public int getProduct() {
        return area * getAngles();
    }
	
	@Override
	public String getDescriptor() {
		return "PlaneFigures";
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%d;%d;%d;%s\n", getName(), getColor(), getAngles(), getArea(),
                getProduct(), getDescriptor());
	}
}