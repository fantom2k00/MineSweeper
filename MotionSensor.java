public class MotionSensor extends Sensor {

	private float distance;

	public MotionSensor(String loc, String manuf, float dist) {
		super(loc, manuf);
		this.distance = dist;
	}

	public void procedure() {
		System.out.println("Alarm in " + this.getType() + " " + this.getLocation() + " (" + this.getManufacturer() + ")");
		System.out.println("Contacting Police...");
	}

	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		String msg = "Info of " + (this.active ? "active" : "inactive" + " sensor");
		msg += " (type = " + this.getType() + "), from " + this.manufacturer;
		msg += " located at " + this.location + " with an active radius of " + this.distance;
		return msg;
	}
}