package main;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GameFrame extends JFrame {
	
	GameFrame() {
		
		GamePanel panel = new GamePanel();
		panel.setBackground(Color.black);
		this.add(panel);
		this.setTitle("Snake Game");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
