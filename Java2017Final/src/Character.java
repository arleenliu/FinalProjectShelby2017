import java.awt.Image;
import java.util.ArrayList;

public class Character {
	//FIELDS
	private int x; //location of character
	private int y;
	private int xChange, yChange;
	private Image charImg;
	private boolean isDead;
	private double beginTime;
	private boolean hasHitBottom, hasHitTop, hasHitObstacle;

	
	//CONSTRUCTORS
	public Character (int xCoor, int yCoor, Image character, double beginTime){
		x = xCoor;
		y = yCoor;
		xChange = 0;
		yChange = 0;
		charImg = character;
		isDead = false;
		beginTime = 0;
		hasHitBottom = false;
		hasHitTop = false;
		hasHitObstacle = false;
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
	public void launch(Slingshot ss, double currentTime) {
		double timeDiff = currentTime - beginTime;
		ss.incrementJumpNum();
		ss.setVelocity();
		
		yChange = (int) (ss.getInitialYVelocity() * timeDiff - 0.5 * Slingshot.GRAVITY * Math.pow(timeDiff, 2));
		xChange = (int) (ss.getXVelocity() * timeDiff);
		
	}
	
	public void checkHasCollided(ArrayList<HelperObject> helpers, ArrayList<Obstacle> obstacles) {
		
	}
	
	
	//code this later
	public void bounce(){
		
	}
	
	

	
	
}
