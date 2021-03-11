public class COSensor extends Sensor {

	private float concentration;

	public COSensor(String loc, String manuf, float conc) {
		super(loc, manuf);
		concentration = conc;
	}

	public void procedure() {
		System.out.println("Alarm in " + this.getType() + " " + this.getLocation() + " (" + this.getManufacturer() + ")");
		System.out.println("Opening Windows...");
	}

	public float getConcentration() {
		return this.concentration;
	}

	public void setConcentration(float concentration) {
		this.concentration = concentration;
	}

	public String toString() {
		String msg = "Info of " + (this.active ? "active" : "inactive" + " sensor");
		msg += " (type = " + this.getType() + "), from " + this.manufacturer;
		msg += " located at " + this.location + " with trigger concentration of " + this.concentration;
		return msg;
	}
}