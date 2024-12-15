package main;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	public static final int GAME_WIDTH = 1280;
	public static final int GAME_HEIGHT = 720;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int UNIT_SIZE = 20;
	boolean running = true;
	
	
	Thread gameThread;
	Snake snake;
	Score score;
	Random random;
	Graphics graphics;
	Image image;
	Apple apple;
	
	
	
	GamePanel() {
		setInitialScore();
		setInitialApple();
		setInitialSnake();
	    this.setFocusable(true);
	    this.setPreferredSize(SCREEN_SIZE);
	    this.addKeyListener(new AL());

	    
	    gameThread = new Thread(this);
	    gameThread.start();
	}
	
	


	@Override
	public void run() {
		// Game Loop
				long lastTime = System.nanoTime();
				double amountOfTicks = 20.0;
				double ns = 1000000000 / amountOfTicks;
				double delta = 0;
				
				while (true) {
					long now = System.nanoTime();
					
					delta += (now - lastTime) / ns;
					lastTime = now;
					
					if (delta >= 1) {
							gameOver();
							checkAppleCollision();
							move();
							repaint();
							delta--;
							
					}
					
				}
				
		
	}
	

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void setInitialSnake() {
		snake = new Snake(200, 200, UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
	}
	
	public void setInitialApple() {
		apple = new Apple();
	}
	
	public void setInitialScore() {
		score = new Score();
	}
	
	public void move() {
		snake.move();
		
	}
	
	public void gameOver() {
		if (snake.checkOutOfBounds() == false || snake.checkSelfCollison() == false) {
			running = false;
		}
	}
	
	
	public void checkAppleCollision() {
		if (snake.getAppleXHead() == apple.getAppleX() && snake.getAppleYHead() == apple.getAppleY()) {
			snake.bodyParts++;
			score.score++;
			System.out.println("There was a collision the score is now: " + score.score);
			setInitialApple();
			
		}
	}
	
	public void draw(Graphics g) {
		
		if (running == true) {
			snake.draw(g);
			apple.draw(g);
			score.draw(g);
			
		} else {
			g.setColor(Color.white);
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			
			g.drawString("GAME OVER", GAME_WIDTH / 2 - 110, GAME_HEIGHT / 2);
		} 
		
		// OPTIONAL TO DRAW THE GRID
		//g.setColor(Color.white);
		//int numberOfCols = GAME_WIDTH/ UNIT_SIZE;
		//int numberOfRows = GAME_HEIGHT / UNIT_SIZE;
		//for (int i = 0; i < numberOfCols; i++) {
		//	g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, GAME_HEIGHT);
		//}
		
		//for (int i = 0; i < numberOfRows; i++) {
		//	g.drawLine(0, i * UNIT_SIZE, GAME_WIDTH, i * UNIT_SIZE);
		//}
	}
	
	
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			snake.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			
		}
	}

}
