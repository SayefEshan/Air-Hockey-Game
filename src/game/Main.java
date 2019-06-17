package game;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		GameBoard gb = new GameBoard();
		
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("Air Hockey");
		gameFrame.setSize(495,678);
		gameFrame.setLocation(250, 30);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.add(gb);
		gameFrame.setVisible(true);

	}

}
