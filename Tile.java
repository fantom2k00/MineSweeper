public abstract class Tile {

	protected int posX;
	protected int posY;
	protected boolean flag;
	protected boolean opened;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Tile(int x, int y) {
		// TODO - implement Tile.Tile
		throw new UnsupportedOperationException();
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

	/**
	 * 
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * 
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * 
	 * @param flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * 
	 * @param opened
	 */
	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public abstract void open();

}