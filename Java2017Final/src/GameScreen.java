import java.awt.Color.*;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Helen
//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel {

	private Slingshot slingshot;
	private Character character;
	private Target target;
	
	private GameScreen () {
		slingshot = new Slingshot();
		character = new Character();
		target = new Target();
		
		Color SKYBLUE = new Color(30, 155, 255);
		setBackground(SKYBLUE);
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	}


	public static void main(String[] args)
	{
		JFrame w = new JFrame("Game Screen!!");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen panel = new GameScreen();
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);
	}
}
