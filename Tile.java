import javax.swing.*;

public abstract class Tile {

	protected int posX;
	protected int posY;
	protected boolean flag;
	protected boolean opened;

	public Tile(int x, int y) {
		posX = x;
		posY = y;
		flag = false;
		opened = false;
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public boolean getFlag() {
		return this.flag;
	}

	public boolean getOpened() {
		return this.opened;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		//TODO: Draw or Erase Flag on Tile
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public abstract void open();
}