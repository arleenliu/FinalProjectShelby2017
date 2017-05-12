import java.awt.Image;

public class Character {
	//FIELDS
	private int x; //location of character
	private int y;
	private Image characImg;
	private boolean isDead;

	
	//CONSTRUCTORS
	public Character (int xLoc, int yLoc, Image character){
		x = xLoc;
		y = yLoc;
		characImg = character;
		isDead = false;
	}
	
	
	//METHODS
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
	
	public void die(int windowHeight){
		if (y >= windowHeight){
			isDead = true;
		}
	}
	public boolean isOnTarget(){
	
		return true;
	}
	public void launch(){
		
	}
	public void bounce(){
		
	}
	
	

	
	
}
