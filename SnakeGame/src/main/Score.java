package main;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score {
	int score;
	Score() {
		score = 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		
		g.drawString("Score:" + String.valueOf(score), GamePanel.GAME_WIDTH / 2 - (GamePanel.UNIT_SIZE + 40), 50);
		
	}

}
