public class SmokeSensor extends Sensor {

	private boolean smokeOnly;

	public SmokeSensor(String loc, String manuf, boolean smoke) {
		super(loc, manuf);
		smokeOnly = smoke;
	}

	public void procedure() {
		System.out.println("Alarm in " + this.getType() + " " + this.getLocation() + " (" + this.getManufacturer() + ")");
		System.out.println("Windows are being closed and siren is sounding");
	}

	public boolean getSmokeOnly() {
		return this.smokeOnly;
	}

	public void setSmokeOnly(boolean smokeOnly) {
		this.smokeOnly = smokeOnly;
	}

	public String toString() {
		String msg = "Info of " + (this.active ? "active" : "inactive" + " sensor");
		msg += " (type = " + this.getType() + "), from " + this.manufacturer;
		msg += " located at " + this.location + " with fire detection set to " + !this.smokeOnly;
		return msg;
	}
}