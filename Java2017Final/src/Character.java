import java.awt.Image;
import java.util.ArrayList;

public class Character {
	//FIELDS
	private int x; //location of character
	private int y;
	private int charWidth;
	private int charHeight;
	private int xChange, yChange;
	private Image charImg;
	private boolean isDead;
	private double beginTime;
	private boolean hasHitBottom, hasHitTop, hasDied;;
	private Slingshot ss;

	
	//CONSTRUCTORS
	public Character (int xCoor, int yCoor, int w, int h, Image character, Slingshot ss, double beginTime){
		x = xCoor;
		y = yCoor;
		xChange = 0;
		yChange = 0;
		charImg = character;
		isDead = false;
		beginTime = 0;
		this.ss = ss;
		hasHitBottom = false;
		hasHitTop = false;
		hasDied = false;
		charWidth = w;
		charHeight = h;
	}
	
	//METHODS
	public int getX(){
		return x + xChange;
	}
	
	public int getY(){
		return y + yChange;
	}
	
	
	
	public void die(){
		isDead = true;
	}
	
	public boolean returnStatus() {
		return isDead;
	}
	public boolean isOnTarget(){
	
		return true;
	}
	public void launch(double currentTime) {
		double timeDiff = currentTime - beginTime;
		// ss.incrementJumpNum();
		ss.setVelocity();
		
		yChange = (int) (ss.getInitialYVelocity() * timeDiff - 0.5 * Slingshot.GRAVITY * Math.pow(timeDiff, 2));
		xChange = (int) (ss.getXVelocity() * timeDiff);
		
	}
	
	public void checkHasCollided(ArrayList<HelperObject> helpers, ArrayList<Obstacle> obstacles, int screenWidth, int screenHeight) {
		
		if (x + xChange <= 0 || x + xChange >= screenWidth || y + yChange <= 0 || y + yChange >= screenHeight) {
			hasDied = true;
		}
		
		for (int i = 0; i < helpers.size(); i++) {
			if (x + xChange > helpers.get(i).getX() && x + (charWidth / 2.0) + xChange < helpers.get(i).getX() + 60) {
				if (y + yChange + charHeight >= helpers.get(i).getY()) {
					hasHitTop = true;
				}
				
				if (y + yChange <= helpers.get(i).getY()) {
					hasHitBottom = true;
				}
				
				ss.setVelocity();
			}
		}
		
		for (int i = 0; i < obstacles.size(); i++) {
			//if (obstacles.get(i))
		}
		
		
		// ss.setVelocity();
		// x += xChange;
		// y = 
		
	}
	
	
	public boolean getHasHitTop() {
		return hasHitTop;
	}
	
	public boolean getHasHitBottom() {
		return hasHitBottom;
	}
	
	public boolean getHasDied() {
		return hasDied;
	}
	
	//code this later
	public void bounce(){
		
	}
	
}
