import java.awt.Color.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Helen
//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements MouseListener, MouseMotionListener {

	private Slingshot slingshot;
	private Character character;
	private Target target;
	private Image charImg, slingImg;

	private int dragOffsetX, dragOffsetY;

	private boolean helperObj, drawHelperObj;
	private int xClick, yClick;
	private int objWidth, objHeight;
	private int slingX, slingY, dragX, dragY;
	private boolean slingClicked;

	private ArrayList<HelperObject> helpers;
	private ArrayList<Obstacle> obstacles;
	private int level;
	private LevelOne level1;
	private LevelTwo level2;
	private LevelThree level3;
	private LevelFour level4;
	private LevelFive level5;

	
	
	
	public GameScreen (int lvl) {
		//charImg = (new ImageIcon("sunImg.png").getImage());
		slingImg = (new ImageIcon("slingshot1.png").getImage());
		charImg = (new ImageIcon("trashcanCharacter.png").getImage());
		character = new Character(150, 200, charImg, 0);
		target = new Target(0, 0, 0);		

		helperObj = false;
		drawHelperObj = false;
		objWidth = 60;
		objHeight = 5;

		slingClicked = false;
		slingX = 60;
		slingY = 335;
		dragX = slingX;
		dragY = slingY;
		//sling = new Rectangle(slingX, slingY, 70, 10);	

		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);
		
		level1 = new LevelOne();
		level2 = new LevelTwo();
		level3 = new LevelThree();
		level4 = new LevelFour();
		level5 = new LevelFive();
		
		helpers = new ArrayList<>();
		level = lvl;
		if (level == 1){
			
			obstacles = level1.typeOfObstacles();
			
		} else if (level == 2){
			
			obstacles = level2.typeOfObstacles();

		} else if (level == 3){
			
			obstacles = level3.typeOfObstacles();
			
		} else if (level == 4){
			
			obstacles = level4.typeOfObstacles();
			
		} else if (level == 5){
			
			obstacles = level5.typeOfObstacles();
			
		}
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		//platform for character
		Color PALEGREEN = new Color(160, 255, 100);
		g.setColor(PALEGREEN);
		g.fillRect(0, 400, 150, 200);	

		//character
		if(slingClicked == true) {
			g.drawImage(charImg, dragX-23, dragY-23, 46, 46, this);
		}
		else
			g.drawImage(charImg, slingX-23, slingY-23, 46, 46, this);

		//slingshot
		//g.drawImage(slingImg, 60, 300, 70, 100, this);
		Color NEWYELLOW = new Color(241, 221, 56);
		g.setColor(NEWYELLOW);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		if(slingClicked == true) {
			g2.drawLine(95,  340, dragX, dragY);
		}
		else
			g2.drawLine(95, 340, slingX, slingY	);
		//slingshot body
		Color BROWN = new Color(185, 155, 75);
		g.setColor(BROWN);
		g.fillRect(90, 330, 10, 70);


		//g.fillRect(sling.x, sling.y, sling.width, sling.height);

		//platform for target
		g.setColor(PALEGREEN);
		g.fillRect(500, 300, 150, 300);

		//screen w/ all the thing
		Color LIGHTGRAY = new Color(211, 211, 211);
		g.setColor(LIGHTGRAY);
		g.fillRect(650, 0,  150, height);
		g.setColor(Color.GRAY);
		Font newFont = new Font("SansSerif", Font.PLAIN, 15);
		g.setFont(newFont);
		g.drawString("Click and drop", 660, 25);
		g.drawString("to use the blocks", 658, 40);
		
		//Obstacles
		
		for (int i = 0; i < obstacles.size(); i++){
			Obstacle obstacle = obstacles.get(i);
			obstacle.drawObstacle(g);
		}
		
		
		//Helper Objects
		if (helperObj){
			g.setColor(Color.CYAN);
			g.fillRect(700, 150, objWidth, objHeight);

		}
		else {
			g.setColor(Color.WHITE);
			g.fillRect(700, 150, objWidth, objHeight);
		
		}
			for (int i = 0; i < helpers.size(); i++){
			HelperObject obj = helpers.get(i);
			obj.draw(g, Color.WHITE);
			
			}
			
			//helperObj = false;
			//drawHelperObj = false;
		


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

				if(xClick >= 700 && xClick <= 700 + objWidth && yClick >= 150-10 && yClick <= 150 + objHeight + 10){
					
					helperObj = true;
				}
					repaint();

			}
			//if true, which means have already clicked on a block
			else {
				if (xClick < 650){
					helpers.add(new HelperObject(xClick, yClick, objWidth, objHeight));
					helperObj = false;
				}

			}
			
			repaint();
			
			
			if(slingClicked == false) {
				//if it's approximately near the slingshot bc too lazy for precise coordinates lol
				if(xClick>=50 && xClick<=120 && yClick>=300 && yClick<=400) {
					slingClicked = true;
					dragX = xClick;
					dragY = yClick;
				}
				else {
					//changeSling = true;
				}
			}

			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		slingClicked = false;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (slingClicked = true) {
			if (e.getX() < getWidth()*1/2) {
			dragX = e.getX();
			dragY= e.getY();
			repaint();
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
