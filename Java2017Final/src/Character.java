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

	
	//CONSTRUCTORS
	public Character (int xCoor, int yCoor, Image character, double beginTime){
		x = xCoor;
		y = yCoor;
		xChange = 0;
		yChange = 0;
		charImg = character;
		isDead = false;
		beginTime = 0;
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
	
	/*public void checkHasCollided(ArrayList<HelperObject> helpers, ArrayList<Obstacles> obstacles) {
		
	}
	*/
	
	
	//code this later
	public void bounce(){
		
	}
	
	

	
	
}
