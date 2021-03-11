public class Map {

	private int boardSizeX;
	private int boardSizeY;
	private int mineCount;

	public Map(int sizeX, int sizeY, int mines) {

		throw new UnsupportedOperationException();
	}

	public int getBoardSizeX() {
		return this.boardSizeX;
	}

	public int getBoardSizeY() {
		return this.boardSizeY;
	}

	public int getMineCount() {
		return this.mineCount;
	}

	/**
	 * 
	 * @param boardSizeX
	 */
	public void setBoardSizeX(int boardSizeX) {
		this.boardSizeX = boardSizeX;
	}

	/**
	 * 
	 * @param boardSizeY
	 */
	public void setBoardSizeY(int boardSizeY) {
		this.boardSizeY = boardSizeY;
	}

	/**
	 * 
	 * @param mineCount
	 */
	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void leftClick(int x, int y) {
		// TODO - implement Map.leftClick
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void rightClick(int x, int y) {
		// TODO - implement Map.rightClick
		throw new UnsupportedOperationException();
	}

}