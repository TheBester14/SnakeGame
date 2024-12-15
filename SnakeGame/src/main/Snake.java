package main;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Snake extends Rectangle {
	char direction;
	int bodyParts;
	int speed;
	int xParts[];
	int yParts[];

	
	Snake(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		direction = 'D';
		bodyParts = 6;
		this.speed = speed;
		xParts = new int[40];
		yParts = new int [40];
		
		
		// Initialize the snake parts for x and y
		
		for (int i = 0; i < bodyParts; i++) {
			xParts[i] = x; // Keep same x coordinate
			yParts[i] = y - (i * height);
		}

	}
	
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (direction != 'R') {
				direction = 'L';
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (direction != 'L') {
				direction = 'R';
			}
			break;
		case KeyEvent.VK_UP:
			if (direction != 'D') {
				direction = 'U';
			}
			break;
		case KeyEvent.VK_DOWN:
			if (direction != 'U') {
				direction = 'D';
			}
			break;
		}
		
	}
	
	public int getAppleXHead() {
		return xParts[0];
	}
	
	public int getAppleYHead() {
		return yParts[0];
	}
	
	public boolean checkOutOfBounds() {
		if (xParts[0] < 0) {
			return false;
		}
		if (xParts[0] > GamePanel.GAME_WIDTH - (GamePanel.UNIT_SIZE / 2)) {
			return false;
		}
		
		if (yParts[0] < 0) {
			return false;
		}
		
		if (yParts[0] > GamePanel.GAME_HEIGHT  - (GamePanel.UNIT_SIZE / 2)) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkSelfCollison() {
	    // Start from the last body part and go down to the segment right after the head
	    for (int i = bodyParts - 1; i > 0; i--) {
	        if (xParts[0] == xParts[i] && yParts[0] == yParts[i]) {
	            System.out.println("WOOPS");
	            return false;
	        }
	    }
	    return true;
	}

	
	public void move() {
		checkSelfCollison();
		checkOutOfBounds();
		for (int i = bodyParts - 1; i > 0 ; i--) {
			xParts[i] = xParts[i - 1];
			yParts[i] = yParts[i - 1];
		}
		
		switch (direction) {
		case 'U':
			yParts[0] -= speed;
			break;
		case 'D':
			yParts[0] += speed;
			break;
		case 'L':
			xParts[0] -= speed;
			break;
		case 'R':
			xParts[0] += speed;
			break;
		}
	}
	

	
	public void draw(Graphics g) {

		for (int i = 0 ; i < bodyParts; i++) {
			
			if (i == 0) {
				g.setColor(Color.green);
			} else {
				g.setColor(Color.red);
			}
			
			g.fillRect(xParts[i] , yParts[i], width, height);
		}
		

	}
}
