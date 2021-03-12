import javax.swing.*;

public class Map extends JFrame{

	private int boardSizeX;
	private int boardSizeY;
	private int mineCount;

	public Map(int sizeX, int sizeY, int mines) {
		JFrame frame = new JFrame("Mine Sweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(sizeX, sizeY);
		frame.setVisible(true);
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

	public void setBoardSizeX(int boardSizeX) {
		this.boardSizeX = boardSizeX;
	}

	public void setBoardSizeY(int boardSizeY) {
		this.boardSizeY = boardSizeY;
	}

	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}

	public void leftClick(int x, int y) {
		// TODO - implement Map.leftClick
		throw new UnsupportedOperationException();
	}

	public void rightClick(int x, int y) {
		// TODO - implement Map.rightClick
		throw new UnsupportedOperationException();
	}
}