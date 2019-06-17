package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Goal {
	
	private int x,y;
    private String imagePath;
    
	public Goal (int x, int y, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void draw(Graphics g){
		
		ImageIcon goal = new ImageIcon(imagePath);
		g.drawImage(goal.getImage(), x, y, null);
		
	}

}
