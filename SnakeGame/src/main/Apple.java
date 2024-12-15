package main;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Apple extends Rectangle{
	Random random;
	
	int numberOfCols = GamePanel.GAME_WIDTH / GamePanel.UNIT_SIZE;
	int numberOfRows = GamePanel.GAME_HEIGHT  / GamePanel.UNIT_SIZE;
	
	
	int appleCol;
	int appleRow;
	
	int appleX;
	int appleY;
	
	Apple() {
		
		random = new Random();
		appleCol = random.nextInt(numberOfCols);
		appleRow = random.nextInt(numberOfRows);
		
		appleX = appleCol * GamePanel.UNIT_SIZE;
		appleY = appleRow * GamePanel.UNIT_SIZE;
		System.out.println("Apple X: " + appleX);
		System.out.println("Apple Y: " + appleY);

	}
	
	
	public int getAppleX() {
		return appleX;
	}
	
	public int getAppleY() {
		return appleY;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(appleX, appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
	}
	
}
