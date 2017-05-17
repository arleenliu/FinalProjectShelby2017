import java.awt.Image;

public class Character {
	//FIELDS
	private int x; //location of character
	private int y;
	private Image charImg;
	private boolean isDead;

	
	//CONSTRUCTORS
	public Character (int xLoc, int yLoc, Image character){
		x = xLoc;
		y = yLoc;
		charImg = character;
		isDead = false;
	}
	
	
	//METHODS
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	
	public void die(){
		isDead = true;
	}
	public boolean isOnTarget(){
	
		return true;
	}
	public void launch(int angle, int distance){
		
	}
	
	
	//code this later
	public void bounce(){
		
	}
	
	

	
	
}
