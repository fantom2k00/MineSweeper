import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.awt.*;

public class Map extends JFrame implements MouseListener{

	private boolean firstClick;
	private int boardSizeX;
	private int boardSizeY;
	private int tileSize;
	private int mineCount;
	private int flagCount;
	private ArrayList<Tile> tiles;
	private ArrayList<Integer> mineLocations;
	private ArrayList<JButton> buttons;
	private JFrame frame;
	private JLabel flagTextbox;

	public Map(int sizeX, int sizeY, int mines) {
		firstClick = true;
		boardSizeX = sizeX;
		boardSizeY = sizeY;
		tileSize = 30;
		mineCount = mines;
		flagCount = 0;
		tiles = new ArrayList<Tile>();
		mineLocations = new ArrayList<Integer>();
		buttons = new ArrayList<JButton>();
		mineGenerator();
		createMapGUI();
	}

	public void createMapGUI() {
		frame = new JFrame("Mine Sweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(boardSizeX * tileSize + 25, boardSizeY * tileSize + 70);
		frame.setVisible(true);
		frame.setLayout(null);

		flagTextbox = new JLabel("Flags: " + flagCount + "/" + mineCount);
		flagTextbox.setBounds(5, boardSizeY * tileSize + 5, 100, 15);
		flagTextbox.setVisible(true);
		frame.add(flagTextbox);

		for(int i = 0; i < boardSizeX; i++) {
			for(int j = 0; j < boardSizeY; j++) {
				Tile tile;

				JButton tileButton = new JButton("");
				tileButton.setOpaque(true);
				//tileButton.setBorderPainted(false); //For Mac support
				tileButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				tileButton.setMargin(new Insets(0,0,0,0));
				tileButton.setBackground(Color.LIGHT_GRAY);

				if(mineLocations.contains(i*boardSizeX + j)) {
					tile = new Mine();
					tileButton.setName("Mine");
				}
				else {
					tile = new Empty();
					tileButton.setName("Empty");
				}

				tileButton.setBounds(i*tileSize + 4, j*tileSize, tileSize, tileSize);
				tileButton.addMouseListener(this);


				frame.add(tileButton);
				buttons.add(tileButton);
				tiles.add(tile);
			}
		}
	}

	public void mineGenerator() {
		int random;
		for(int i = 0; i < mineCount; i++) {
			random = (int)(Math.random() * (boardSizeX * boardSizeY + 1));
			while(mineLocations.contains(random)) {
				random = (int)(Math.random() * (boardSizeX * boardSizeY + 1));
			}
			System.out.println(random);
			mineLocations.add(random);
		}
	}

	public void repositionMine(JButton btn) {
		for (JButton button : buttons) {
			if (button.getName().equals("Empty")) {
				button.setBackground(Color.BLACK);
				button.setName("Mine");
				tiles.set(buttons.indexOf(button), new Mine());
				break;
			}
		}
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setName("Empty");
		tiles.set(buttons.indexOf(btn), new Empty());
	}

	public int countNearbyMines(int x, int y, JButton btn)
	{
		int count = 0;
		if(x == 0) {
			for (int i = 0; i <= x + 1; i++) {
				if(y == 0) {
					for (int j = 0; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else if(y == boardSizeY - 1) {
					for (int j = y-1; j <= y; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else {
					for (int j = y-1; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
			}
		}
		else if(x == boardSizeX - 1) {
			for (int i = x-1; i <= x; i++) {
				if(y == 0) {
					for (int j = 0; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else if(y == boardSizeY - 1) {
					for (int j = y-1; j <= y; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else {
					for (int j = y-1; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
			}
		}
		else {
			for (int i = x - 1; i <= x + 1; i++) {
				if(y == 0) {
					for (int j = 0; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else if(y == boardSizeY - 1) {
					for (int j = y-1; j <= y; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
				else {
					for (int j = y-1; j <= y + 1; j++) {
						if (tiles.get(i * boardSizeY + j).getType().equals("Mine")) {
							count++;
						}
					}
				}
			}
		}

		if(count > 0) {
			JLabel mineText = new JLabel(Integer.toString(count), JLabel.CENTER);
			mineText.setBounds(btn.getBounds());
			mineText.setForeground(new Color((int) (85 * Math.sqrt(count)), 255 - 32 * count, 32 * count));
			mineText.setVisible(true);
			frame.add(mineText);
		}

		else
			openEmptyTiles(x, y, btn);

		if (tiles.get(buttons.indexOf(btn)).getFlag()) {
			flagCount--;
			tiles.get(buttons.indexOf(btn)).setFlag(false);
			flagTextbox.setText("Flags: " + flagCount + "/" + mineCount);
		}

		btn.setVisible(false);
		return count;
	}

	public void openEmptyTiles(int x, int y, JButton btn) {
		if(buttons.get(buttons.indexOf(btn)).isVisible()) {
			btn.setVisible(false);
			if (y < boardSizeY-1) {
				countNearbyMines(x, y + 1, buttons.get(buttons.indexOf(btn) + 1));
				if (x < boardSizeX-1) {
					countNearbyMines(x + 1, y+1, buttons.get(buttons.indexOf(btn) + boardSizeY + 1));
				}
				if (x > 0) {
					countNearbyMines(x - 1, y + 1, buttons.get(buttons.indexOf(btn) - boardSizeY + 1));
				}
			}
			if (y > 0) {
				countNearbyMines(x, y - 1, buttons.get(buttons.indexOf(btn) - 1));
				if (x < boardSizeX-1) {
					countNearbyMines(x + 1, y - 1, buttons.get(buttons.indexOf(btn) + boardSizeY - 1));
				}
				if (x > 0) {
					countNearbyMines(x - 1, y - 1, buttons.get(buttons.indexOf(btn) - boardSizeY - 1));
				}
			}
			if (x < boardSizeX-1) {
				countNearbyMines(x + 1, y, buttons.get(buttons.indexOf(btn) + boardSizeY));
			}
			if (x > 0) {
				countNearbyMines(x - 1, y, buttons.get(buttons.indexOf(btn) - boardSizeY));
			}
		}
	}

	public void endGame() {
		for (JButton btn : buttons) {
			if (btn.getName().equals("Mine")) {
				JLabel mineText = new JLabel("B", JLabel.CENTER);
				mineText.setForeground(Color.RED);
				mineText.setBackground(Color.BLACK);
				mineText.setOpaque(true);
				mineText.setBounds(btn.getBounds());
				mineText.setVisible(true);

				btn.setVisible(false);
				frame.add(mineText);
			}
		}
		JOptionPane.showMessageDialog(null, "R.I.P. YOU HAVE PRESSED THE BOMB",
				"Game over", JOptionPane.CLOSED_OPTION);
	}

	public void rightClick(MouseEvent e) {
		for (JButton btn : buttons) {
			if (e.getSource() == btn) {
				Tile tile = tiles.get(buttons.indexOf(btn));
				if (tile.getFlag()) {
					tile.setFlag(false);
					btn.setText("");
					flagCount--;
				}
				else {
					tile.setFlag(true);
					btn.setText("F");
					btn.setForeground(new Color(200, 0, 200));
					flagCount++;
				}
				break;
			}
		}
		flagTextbox.setText("Flags: " + flagCount + "/" + mineCount);
	}

	public void leftClick(MouseEvent e) {
		for (JButton btn : buttons) {
			if (e.getSource() == btn) {

				if(btn.getName().equals("Empty"))
					countNearbyMines(btn.getX()/tileSize, btn.getY()/tileSize, btn);

				else {
					if ((firstClick))
						repositionMine(btn);
					else
						endGame();
				}

				firstClick = false;
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftClick(e);

		else if (e.getButton() == MouseEvent.BUTTON3)
			rightClick(e);
	}

	//Need overriding for MouseListener
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}