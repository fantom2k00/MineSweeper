import java.util.*;

public class ControlCenter {

	private String name;
	private Category category;
	private ArrayList<Sensor> sensors;

	public ControlCenter(String ccName, Category cat) {
		name = ccName;
		category = cat;
		sensors = new ArrayList<Sensor>();
	}

	public void addSensor(Sensor sensor) {
		if(!existingSensor(sensor))
			sensors.add(sensor);
	}

	public boolean existingSensor(Sensor sensor) {
		for(Sensor s : sensors)
			if(s.getType() == sensor.getType())
				if(s.getLocation() == sensor.getLocation())
					if(s.getManufacturer() == sensor.getManufacturer())
						return true;

		return false;
	}

	public int testSensor(Sensor s) {
		return s.getActive() ? sensors.indexOf(s) : -1;
	}

	public int testAllSensors() {
		int amount = 0;
		for(Sensor s : sensors)
			if(s.getActive())
				amount++;

		return amount;
	}

}