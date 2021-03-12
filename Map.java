import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;

public class Map extends JFrame implements ActionListener {

	private int boardSizeX;
	private int boardSizeY;
	private int mineCount;
	private ArrayList<Tile> tiles;
	private ArrayList<JButton> buttons;

	public Map(int sizeX, int sizeY, int mines) {
		JFrame frame = new JFrame("Mine Sweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(sizeX, sizeY);
		frame.setVisible(true);
		frame.setLayout(null);
		//panel = new JPanel((new FlowLayout(FlowLayout.LEFT, 0, 0)));
		//frame.add(panel);

		tiles = new ArrayList<Tile>();
		buttons = new ArrayList<JButton>();

		for(int i = 0; i < sizeX - 30; i += 30) {
			for(int j = 0; j < sizeY - 60; j += 30) {
				Tile tile = new Empty(10, 10);
				JButton tileButton = new JButton("");
				tileButton.setBounds(i, j, 30, 30);
				tileButton.addActionListener(this);
				frame.add(tileButton);
				buttons.add(tileButton);
			}
		}
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

	public void actionPerformed(ActionEvent e)
	{
		for (JButton btn : buttons) {
			if (e.getSource() == btn) {
				System.out.println(btn.getX() + "," + btn.getY());
				btn.setVisible(false);
			}
		}
	}

	public void rightClick(int x, int y) {
		// TODO - implement Map.rightClick
		throw new UnsupportedOperationException();
	}
}