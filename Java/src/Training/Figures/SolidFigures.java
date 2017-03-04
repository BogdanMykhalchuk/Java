package Training.Figures;

public class SolidFigures extends Figures {
	private int volume;
	SolidFigures() {}
	SolidFigures(String name, String color, int angles, int volume) {
		super(name, color, angles);
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	@Override
	public int getProduct() {
		return volume * getAngles();
	}
	
	@Override
	public String getDescriptor() {
		return "SolidFigures";
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%d;%d;%d;%s\n", getName(), getColor(), getAngles(),
                getVolume(), getProduct(), getDescriptor());
	}
}