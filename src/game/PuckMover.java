package game;

import java.awt.Rectangle;

import javax.swing.*;

public class PuckMover extends Thread{
	
	Puck puck;
	GameBoard gameboard;
	GreenPaddle player;
	BluePaddle os;
	
	int direction=0;
	
	public PuckMover(Puck puck, GameBoard gameboard, GreenPaddle player, BluePaddle os) {
		
		super();
		this.puck = puck;
		this.gameboard = gameboard;
		this.player = player;
		this.os = os;
	
	}

	
	public void run(){
		
		while(true){
			
			if(puck.getY() > 600){
				
				
				GameSound.goalSound();
				GameBoard.scoreOs++;
				gameboard.repaint();
	
				break;
			}
			
			else if(puck.getY() >= 0)
					
				puck.setY(puck.getY() + 1);
			
			
			else if(puck.getY() < -10){
				
				GameSound.goalSound();
				GameBoard.scorePlayer++;
				gameboard.repaint();
				
				break;
			}
			
			
			
			checkCollisionForPlayer();
			
			
			try {
				Thread.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			gameboard.repaint();
		}
		
		
	}
	
	public void checkCollisionForPlayer(){
		
		Rectangle puckRect = new Rectangle(puck.getX(),puck.getY(),45,45);
		Rectangle playerRect = new Rectangle(player.getX(),player.getY(),64,64);
		
			
		if(playerRect.intersects(puckRect)== true){
			
			GameSound.puckHitSound();
			 
			direction = -3 + (int)(Math.random() * 7);
			
			
		/*
			if(playerRect.getX() <= 23 ){
				
				direction = 1;
				System.out.println("a1");
			}
			
			
			else if(playerRect.getX() >= 41 ){
				
				direction = -1;
				System.out.println("b1");
			}
			
			else if (playerRect.getX() > 23 && playerRect.getX() < 41){
				
				direction = 0;
				System.out.println("c1");
			}
		*/	
			
			movePuckUp(direction);
			
			
		}

		else if (puck.getY() > 580){
			
			if(puck.getX() > 0 && puck.getX() < 80 || puck.getX() > 350 && puck.getX() < 460){
				
				GameSound.puckHitSound();
			
				movePuckUp(direction);
			}
			
			
			
		}
		
		
		
	}
	
	public void checkCollisionForOs(){
		
		Rectangle puckRect = new Rectangle(puck.getX(),puck.getY(),45,45);
		Rectangle osRect = new Rectangle(os.getX(),os.getY(),64,64);
		
		
		if(osRect.intersects(puckRect) == true){
			
			GameSound.puckHitSound();	
			
			direction = -3 + (int)(Math.random() * 7);
		/*	
			if(osRect.getX() <= 23 ){
				
				direction = -1; 
				
				System.out.println("a");
			}
			
			
			else if(osRect.getX() >= 41 ){
				
				direction = 1;
				System.out.println("b");
			}
			
			else if (osRect.getX() > 23 && osRect.getX() < 41){
				
				direction = 0;
				System.out.println("c");
			}
			*/
			
			movePuckDown(direction);
			
		}
		
		else if (puck.getY() <= 20){
			
		 if(puck.getX() > 0 && puck.getX() < 80 || puck.getX() > 350 && puck.getX() < 460){
				
				GameSound.puckHitSound();
			
				movePuckDown(direction);
			}
			
			
		}	
			
		
		
	}
	
	public void movePuckUp(int direction){
		
		while(puck.getY() < 600 && puck.getY() > -50){
			
			if(direction == 0)
				
				puck.setY(puck.getY() - 1);
			
			
			else if(direction == 1){
				
				puck.setX(puck.getX() - 1);
				puck.setY(puck.getY() - 1);
				
				if(puck.getX() < 10){
				
					direction = -1;
					GameSound.puckHitSound();
				}
				
				
			}
			
			else if(direction == -1){
				
				puck.setX(puck.getX() + 1);
				puck.setY(puck.getY() - 1);
				
				
				if(puck.getX() > 425){
					
					direction = 1;
					GameSound.puckHitSound();
				}
			}
			
			else if(direction == -2){
				
				puck.setX(puck.getX() + 2);
				puck.setY(puck.getY() - 1);
				
				
				if(puck.getX() > 425){
					
					direction = 1;
					GameSound.puckHitSound();
				}
			}
			
			else if(direction == 2){
				
				puck.setX(puck.getX() - 1);
				puck.setY(puck.getY() - 2);
				
				
				if(puck.getX() < 0){
				
					direction = -1;
					GameSound.puckHitSound();
				}
					
			}
			

			else if(direction == -3){
				
				puck.setX(puck.getX() + 3);
				puck.setY(puck.getY() - 1);
				
				if(puck.getX() > 425){
					
					direction = 2;
					GameSound.puckHitSound();
				}
				
			}
			
			else if(direction == 3){
				
				puck.setX(puck.getX() - 1);
				puck.setY(puck.getY() - 3);
				
				if(puck.getX() < 0){
					
					direction = -2;
					GameSound.puckHitSound();
				}
				
			}
			
			
			checkCollisionForOs();
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			gameboard.repaint();
			
		}
		
	}
	
	public void movePuckDown(int direction){
		
		while(puck.getY() > -50 && puck.getY() < 700){
			
			if(direction==0){
				puck.setY(puck.getY() + 1);
			}
			
			else if(direction == -1){
				
				puck.setX(puck.getX() - 1);
				puck.setY(puck.getY() + 1);
				
				if(puck.getX() < 10){
					
					direction = 1;
					GameSound.puckHitSound();
				}
				
			}
			
			
			else if(direction == 1){
				
				puck.setX(puck.getX() + 1);
				puck.setY(puck.getY() + 1);
				
				if(puck.getX() > 425){
					
					direction = -1;
					GameSound.puckHitSound();
				}
				
			}
			
			else if(direction == -2){
				
				puck.setX(puck.getX() - 2);
				puck.setY(puck.getY() + 1);
				
				
				if(puck.getX() < 0){
					
					direction = 1;
					GameSound.puckHitSound();
				}
			}
			
			else if(direction == 2){
				
				puck.setX(puck.getX() + 1);
				puck.setY(puck.getY() + 2);
				
				
				if(puck.getX() > 425){
					
					direction = -1;
					GameSound.puckHitSound();
				}
			}
			
			else if(direction == -3){
				
				puck.setX(puck.getX() - 3);
				puck.setY(puck.getY() + 2);
				
				
				if(puck.getX() < 0){
					
					direction = 2;
					GameSound.puckHitSound();
				}
			}

			else if(direction == 3){
			
			puck.setX(puck.getX() + 1);
			puck.setY(puck.getY() + 3);
			
			
			if(puck.getX() > 425){
				
				direction = -2;
				GameSound.puckHitSound();
				
				}
		    }


			
			checkCollisionForPlayer();
			try {
				Thread.sleep(5);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			gameboard.repaint();
			
		}
		
	}
	
	

}