import java.awt.Color.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Helen
//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements MouseListener {

	private Slingshot slingshot;
	private Character character;
	private Target target;
	private Image charImg;

	private boolean helperObj, drawHelperObj;
	private int xClick, yClick;
	private int objWidth, objHeight;
	private int slingX, slingY;

	private GameScreen () {
		slingshot = new Slingshot();
		//charImg = (new ImageIcon("sunImg.png").getImage());
		charImg = (new ImageIcon("trashcanCharacter.png").getImage());
		character = new Character(150, 200, charImg);
		target = new Target();		

		helperObj = false;
		objWidth = 60;
		objHeight = 30;
		
		slingX = 60;
		slingY = 335;

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
		
		//slingshot body
		Color BROWN = new Color(185, 155, 75);
		g.setColor(BROWN);
		g.fillRect(90, 330, 20, 70);
		//sling shot string/line
		Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(8));
		g2.drawLine(90, 340, slingX, slingY	);
		
		
		//character
		g.drawImage(charImg, 150, 200, 50, 50, this);
		

		//platform for target
		g.fillRect(500, 300, 150, 300);

		//screen w/ all the things
		Color LIGHTGRAY = new Color(211, 211, 211);
		g.setColor(LIGHTGRAY);
		g.fillRect(650, 0,  150, height);

		g.setColor(Color.WHITE);
		g.fillRect(700, 150, objWidth, objHeight);

		if(drawHelperObj == true) {
			new HelperObject(xClick, yClick, objWidth, objHeight).draw(g, Color.WHITE);
			drawHelperObj = false;
			helperObj = false;
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
	//right click to rotate? or have different helper obj? ignore rotation for now
	public void mousePressed(MouseEvent e) {
		xClick = e.getX();
		yClick = e.getY();
		int button = e.getButton();

		if(button == MouseEvent.BUTTON1) {
			if(helperObj == false) {
				if(xClick>= 700 && xClick<=700+objWidth && yClick>=150 && yClick <=150+objHeight)
					helperObj = true;
			}
			//if true, which means have already clicked on a block
			else {
				drawHelperObj = true;
				repaint();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
