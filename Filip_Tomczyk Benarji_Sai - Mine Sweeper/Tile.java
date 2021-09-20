import javax.swing.*;

public abstract class Tile {

	protected boolean flag;
	protected boolean opened;
	protected String type;

	public Tile(String tileType) {
		flag = false;
		opened = false;
		type = tileType;
	}

	public boolean getFlag() {
		return this.flag;
	}

	public String getType() {
		return this.type;
	}

	public void setFlag(boolean flag) { this.flag = flag; }
}