import java.awt.Image;

public class Slingshot {
	
	//FIELDS
	private Image slingshotImg;
	private static final double GRAVITY = 9.81;
	private int height, width;
	private int length;
	int velocity;
	
	//CONSTRUCTORS
	public Slingshot() {
		
	}
	
	public Slingshot(Image slingshot, int h, int w) {
		slingshotImg = slingshot;
		height = h;
		width = w;
		length = 0;
		velocity = 0;
	}	
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public int calculateDistance(int length, double angle) {
		
		velocity = (int) (length * GRAVITY);
		this.length = length;
		int distance = (int) (Math.pow(velocity, 2) * Math.sin(2 * angle) / GRAVITY);
		
		distance = distance + (int) (height * Math.sin(90 - angle) / Math.sin(angle));
		
		return distance;
	} 
	
	public int getVelocity() {
		velocity = (int) (length * GRAVITY);
		return velocity;
	}
	
/*	public int calculateMaxHeight(int length, double angle, TimeTracker time) {
		
		this.length = length;
		int maxHeight = (int) (height + (velocity * time / 2.0) + (0.5 * GRAVITY * Math.pow(time, 2)));
		
		return maxHeight;
	}*/
	
	//METHODS
	
	
	
}
