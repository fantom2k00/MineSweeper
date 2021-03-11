public abstract class Sensor {

	protected String location;
	protected String manufacturer;
	protected boolean active;

	/**
	 * 
	 * @param loc
	 * @param manuf
	 */
	public Sensor(String loc, String manuf) {
		location = loc;
		manufacturer = manuf;
		active = false;
	}

	public String getType() {
		return this.getClass().getName();
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String newLoc) {
		this.location = newLoc;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String newManuf) {
		this.manufacturer = newManuf;
	}

	public boolean getActive() {
		return this.active;
	}

	/**
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public abstract void procedure();
}