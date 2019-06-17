package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameBoard extends JPanel implements KeyListener{
	
	Puck puck;
	GreenPaddle player;
	BluePaddle os;
	GameOver gameover;
	Goal goal;
	static int scorePlayer = 0;
	static int scoreOs = 0;
	
	public GameBoard(){
		
		super();
		
		puck = new Puck(217,300,"images//puck.png");
		player = new GreenPaddle(210,550,"images//player1.png");
		os = new BluePaddle(210,25,"images//player2.png");
		gameover = new GameOver(150,350,"images//gameover.png");
		goal = new Goal(180,190 ,"images//goal.png" );
		
		PuckMover pm = new PuckMover(puck,this,player,os);
		pm.start();
		
		super.setFocusable(true);
		super.addKeyListener(this);
	}
	
	public void paint(Graphics g){
		
		ImageIcon background = new ImageIcon("images//background.jpg");
		g.drawImage(background.getImage(), 0, 0, null);
		
		puck.draw(g);
		player.draw(g);
		os.draw(g);
		
		g.setColor(Color.BLUE);
		
		g.drawString(""+scoreOs,450,300);
		g.drawString(""+scorePlayer,450,350);
		g.drawString("||",450,325);
		
		if(scorePlayer < 3 || scoreOs < 3){
			
			if(puck.getY() < -30)
			goal.draw(g);
	
			else if(puck.getY() > 650)
			goal.draw(g);
		}
		
		else if(scorePlayer == 3 || scoreOs == 3){
			
			gameover.draw(g);
			super.setFocusable(false);
			
			if(scorePlayer == 3){
				
				g.drawString("Player 1 Win The Match",185,170);
			}
		
			else if(scoreOs == 3){
				g.drawString("Player 2 Win The Match",185,170);
			}
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == e.VK_D){
		
			if(os.getX() < 400)
				   os.setX(os.getX() + 7);
		}
		
		else if( e.getKeyCode() == e.VK_RIGHT){
			
			if(player.getX() < 400)
				player.setX(player.getX() + 7);
		}
		
		
		else if(e.getKeyCode() == e.VK_A){
			
			if(os.getX() > 15 )
				   os.setX(os.getX() - 7);
		}
		
		else if(e.getKeyCode() == e.VK_LEFT){
			
			if(player.getX() > 15)
				player.setX(player.getX() - 7);
		}

		else if(e.getKeyCode() == e.VK_SPACE){
			puck.setX(217);
			puck.setY(300);
			
			player.setX(210);
			player.setY(550);
			
			os.setX(210);
			os.setY(25);
			
			
			PuckMover pm = new PuckMover(puck,this,player,os);
			pm.start();
			
			puck.setY(puck.getY() + 1);
			
			/*player.setX(210);
			player.setY(550);
			
			os.setX(210);
			os.setY(25);*/
			
		}
		
		
		super.repaint();

		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}