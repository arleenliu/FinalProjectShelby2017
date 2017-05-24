import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;

public class Character {
	// FIELDS
	private int x; // location of character
	private int y;
	private int charWidth;
	private int charHeight;
	// private int xChange, yChange;
	private Image charImg;
	// private boolean isDead;
	private double beginTime;
	private static boolean hasHitBottom, hasHitTop;
	private boolean hasDied;
	private Slingshot ss;
	private HelperObject currObj;
	private int indexOfCurrObj;
	
	private double xVel, yVel;
	

	// CONSTRUCTORS
	public Character(int xCoor, int yCoor, int w, int h, Image character, Slingshot ss) {
		x = xCoor;
		y = yCoor;
		//xChange = 0;
		//yChange = 0;
		xVel = 0;
		yVel = 0;
		charImg = character;
		beginTime = 0;
		this.ss = ss;
		hasHitBottom = false;
		hasHitTop = false;
		hasDied = false;
		charWidth = w;
		charHeight = h;
		currObj = new HelperObject(0, 0, 60, 10);
		indexOfCurrObj = -1;
	}

	// METHODS
	public int getX() {
		return x;
	}

	public double getXVel() {
		return xVel;
	}
	
	public double getYVel() {
		return yVel;
	}
	
	public void setYVel(double yVel) {
		this.yVel = yVel;
	}
	
	public void setXVel(double xVel) {
		this.xVel = xVel;
	}
	
	public void setInitialTime(double beginTime) {
		this.beginTime = beginTime;
		
	}

	public int getY() {
		return y;
	}

	public boolean isOnTarget() {

		return true;
	}

	public void launch() {
		//double timeDiff = (currentTime - beginTime) * 50;
		// ss.incrementJumpNum();
		// ss.setVelocity();

		yVel += Slingshot.GRAVITY;
		
		x += xVel;
		y += yVel;
		
		// xChange = (int) (ss.getXVelocity() * timeDiff);
		// yChange = (int) (ss.getInitialYVelocity() * timeDiff - 0.5 * Slingshot.GRAVITY * Math.pow(timeDiff, 2));

		// int dummy = 0;
		// dummy += 1;

	}

	public void checkHasCollided(ArrayList<HelperObject> helpers, ArrayList<Obstacle> obstacles, int screenWidth,
			int screenHeight) {

		if (x <= -50 || x >= screenWidth - 150 || y <= 0 || y >= screenHeight) {
			hasDied = true;
		}

		for (int i = 0; i < obstacles.size(); i++) {

			Polygon obstacle = obstacles.get(i).getPolygon();

			// obstacle.addPoint(obstacles.get(i).getX1(),
			// obstacles.get(i).getY1());
			// obstacle.addPoint(obstacles.get(i).getX2(),
			// obstacles.get(i).getY2());
			// obstacle.addPoint(obstacles.get(i).getX3(),
			// obstacles.get(i).getY3());

			if (obstacle.intersects(x, y, charWidth, charHeight)) {

				hasDied = true;

				// break;

			}
		}

		for (int i = 0; i < helpers.size(); i++) {
			if (x > helpers.get(i).getX() && x + (charWidth / 2.0) < helpers.get(i).getX() + 60) {
				if (y + charHeight >= helpers.get(i).getY()) {
					hasHitTop = true;

					indexOfCurrObj = i;
					currObj = helpers.get(i);

					break;
				}

				if (y <= helpers.get(i).getY()) {
					hasHitBottom = true;

					indexOfCurrObj = i;
					currObj = helpers.get(i);

					break;
				}

				// ss.setVelocity();
			}
		}
			
			
		}

		/*
		 * int x1 = obstacles.get(i).getX1(); int x2 = obstacles.get(i).getX2();
		 * int x3 = obstacles.get(i).getX3(); int y1 = obstacles.get(i).getY1();
		 * int y2 = obstacles.get(i).getY2(); int y3 = obstacles.get(i).getY3();
		 * 
		 * int m1y = - (y3 - y1); int m1x = (x3 - x1); int m2y = - (y3 - y2);
		 * int m2x = (x3 - x2);
		 * 
		 * int c1 = m1x * x3 + m1y * y3; int c2 = m2x * x3 + m2y * y3;
		 * 
		 * if (m1x * (x + xChange + charWidth) + m1y * (y - yChange +
		 * charHeight) == c1 || m1x * (x + xChange) + m1y * (y - yChange +
		 * charHeight) == c1 || m1x * (x + xChange + charWidth) + m1y * (y -
		 * yChange) == c1 || m1x * (x + xChange) + m1y * (y - yChange) == c1) {
		 * hasDied = true; }
		 * 
		 * if (m2x * (x + xChange + charWidth) + m2y * (y - yChange +
		 * charHeight) == c2 || m2x * (x + xChange) + m2y * (y - yChange +
		 * charHeight) == c2 || m2x * (x + xChange + charWidth) + m2y * (y -
		 * yChange) == c2 || m2x * (x + xChange) + m2y * (y - yChange) == c2) {
		 * hasDied = true; }
		 */

		// ss.setVelocity();
		// x += xChange;
		// y =

	public static boolean getHasHitTop() {
		return hasHitTop;
	}

	public static boolean getHasHitBottom() {
		return hasHitBottom;
	}

	public boolean getHasDied() {
		return hasDied;
	}

	public void setXY(int x, int y) {
		this.x = x - 23;
		this.y = y - 23;
		
		
		xVel = ss.getXVelocity() * 15;
		
		// if (!ss.getIsNegative()) {
		// yVel = -(ss.getInitialYVelocity() + 15);
		// } else {
			yVel = ss.getInitialYVelocity() - 15;
		// }
		
		hasDied = false;
	}

	// code this later

	public HelperObject getCurrObj() {
		return currObj;
	}

	public int getIndexOfCurrObj() {
		return indexOfCurrObj;
	}
	
	public void reset() {
		hasHitBottom = false;
		hasHitTop = false;
		hasDied = false;
		
		x = 65 - 23;
		y = 370 - 23;
		
		// xVel = 0;
		yVel = 0;
	}

	public void draw(Graphics g, int x, int y, int sizeX, int sizeY) {
		g.drawImage(charImg, x, y, sizeX, sizeY, AllScreen.panel);

	}

}
