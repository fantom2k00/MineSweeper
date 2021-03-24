import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.awt.*;

public class Map extends JFrame implements MouseListener{

	private int boardSizeX;
	private int boardSizeY;
	private int mineCount;
	private int track;
	private int bombCount;
	private ArrayList<Tile> tiles;
	private ArrayList<Integer> mineLocations;
	private ArrayList<JButton> buttons;
	private JFrame frame;
	private JFrame endframe;


	public Map(int sizeX, int sizeY, int mines) {
		boardSizeX = sizeX;
		boardSizeY = sizeY;
		mineCount = mines;
		tiles = new ArrayList<Tile>();
		mineLocations = new ArrayList<Integer>();
		buttons = new ArrayList<JButton>();
		this.mineGenerator();
		track = 0;
		bombCount = 0;

		frame = new JFrame("Mine Sweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(sizeX*30 + 25, sizeY * 30 + 50);
		frame.setVisible(true);
		frame.setLayout(null);
		/*JLabel flags = new JLabel("Bombs left" + bombCount);

		frame.add(flags, BorderLayout.NORTH);*/

		/*endframe = new JFrame("RIP");
		endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endframe.setSize(sizeX*30 + 25, sizeY * 30 + 50);
		endframe.setVisible(false);
		endframe.setLayout(null);*/



		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {

				JButton tileButton = new JButton("");

				tileButton.setOpaque(true);
				tileButton.setBorderPainted(false);

				Tile tile;

				if(mineLocations.contains(i*boardSizeX + j)) {
					tile = new Mine(i, j);
					tileButton.setBackground(Color.BLACK);
					tileButton.setName("Mine");
				}
				else {
					tile = new Empty(i, j);
					tileButton.setBackground(Color.LIGHT_GRAY);
					tileButton.setName("Empty");
				}

				tileButton.setBounds(i*30 + 4, j*30, 30, 30);
				tileButton.addMouseListener(this);


				frame.add(tileButton);
				buttons.add(tileButton);
				tiles.add(tile);
			}
		}
	}
	public void mineGenerator()
	{
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
	/*public void actionPerformed(ActionEvent e)
	{
		for (JButton btn : buttons) {
			if (e.getSource() == btn) {
				if(btn.getName().equals("Empty")) {
					int nearbyMines = countNearbyMines(btn.getX()/30, btn.getY()/30);
					if(nearbyMines > 0) {
						JLabel mineText = new JLabel(Integer.toString(nearbyMines));
						mineText.setBounds(btn.getBounds());
						mineText.setVisible(true);
						frame.add(mineText);

					}
					//else{
					//open empties}
					btn.setVisible(false);
					break;
				}

				else {
					for (JButton button : buttons) {
						if(button.getName().equals("Mine")) {
							for (JButton button1 : buttons){
								if(button1.getName().equals("Mine")) {
							button1.setVisible(false);}
							}
							JOptionPane.showMessageDialog(null, "R.I.P. YOU HAVE PRESSED THE BOMB", "Game over", JOptionPane.CLOSED_OPTION);

							frame.setVisible(false);
							break;
							/*endframe.setVisible(true);
							endframe.setLayout(null);
							endframe.setLocation(500,500);


						}
					}
					break;
				}
			}
		}
	}*/
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



	public int countNearbyMines(int x, int y)
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
		System.out.println(count);
		return count;
	}



	public void rightClick(int x, int y) {
		// TODO - implement Map.rightClick
		throw new UnsupportedOperationException();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			System.out.println("no");
			for (JButton btn : buttons) {
				if (e.getSource() == btn) {
					if(btn.getName().equals("Empty")) {
						int nearbyMines = countNearbyMines(btn.getX()/30, btn.getY()/30);
						if(nearbyMines > 0) {
							JLabel mineText = new JLabel(Integer.toString(nearbyMines));
							mineText.setBounds(btn.getBounds());
							mineText.setVisible(true);
							frame.add(mineText);

						}
						//else{
						//open empties}
						btn.setVisible(false);
						break;
					}

					else {
						for (JButton button : buttons) {
							if(button.getName().equals("Mine")) {
								for (JButton button1 : buttons){
									if(button1.getName().equals("Mine")) {
										button1.setVisible(false);}
								}
								JOptionPane.showMessageDialog(null, "R.I.P. YOU HAVE PRESSED THE BOMB", "Game Over", JOptionPane.CLOSED_OPTION);

								frame.setVisible(false);
								break;
							/*endframe.setVisible(true);
							endframe.setLayout(null);
							endframe.setLocation(500,500);*/

								//todo endgame
							}
						}
						break;
					}
				}
			}


		}
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			System.out.println("yes");
			for (JButton btn : buttons) {
				if (e.getSource() == btn) {
					if (track == 0)
					{ track = 1;
							btn.setText("F");
					bombCount--;}
					else if (track == 1)
					{ track = 0;
						btn.setText("");
						bombCount++;

					}
				}

				}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}