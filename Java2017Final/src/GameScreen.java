import java.awt.Color.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Helen
//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements MouseListener {

	private Slingshot slingshot;
	//private Character character;
	private Target target;

	private boolean helperObj, drawHelperObj;
	private int xClick, yClick;

	private GameScreen () {
		slingshot = new Slingshot();
		//character = new Character();
		target = new Target();		

		helperObj = false;

		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		//platform for character
		Color PALEGREEN = new Color(160, 255, 100);
		g.setColor(PALEGREEN);
		g.fillRect(0, 400, 150, 200);		

		//platform for target
		g.fillRect(500, 300, 150, 300);

		//screen w/ all the things
		Color LIGHTGRAY = new Color(211, 211, 211);
		g.setColor(LIGHTGRAY);
		g.fillRect(650, 0,  150, height);
		g.setColor(Color.WHITE);
		g.fillRect(700, 150, 50, 20);

		if(drawHelperObj == true) {
			g.fillRect(xClick, yClick, 50, 20);
		}
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

		panel.addMouseListener(panel);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		xClick = e.getX();
		yClick = e.getY();
		int button = e.getButton();

		if(button == MouseEvent.BUTTON1) {
			if(helperObj == false) {
				if(xClick>= 700 && xClick<=750 && yClick>=150 && yClick <=170)
					helperObj = true;
			}
			//if true, which means have already clicked on a block
			else {
				drawHelperObj = true;
				helperObj = false;
			}
		}
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
