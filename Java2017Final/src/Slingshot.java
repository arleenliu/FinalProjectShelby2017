import java.awt.Image;

public class Slingshot {

	// FIELDS
	private Image slingshotImg;
	private static final double GRAVITY = 9.81;
	private int height, width;
	private int length;
	// velocityI calculation will be figured out later
	private int velocityI, velocityF;
	private int xVelocity, yVelocityI, yVelocityF;
	private int jumpNum;
	private double timeTaken;
	private int objectHeight;

	// CONSTRUCTORS
	// to be deleted later
	public Slingshot() {

	}
	
	public int calculateCurrentXVelocity() {
		return xVelocity;
	}

	public Slingshot(Image slingshot, int h, int w, int length) {
		slingshotImg = slingshot;
		height = h;
		width = w;
		this.length = length;
		setVelocity();
		velocityI = 0;
		velocityF = 0;
		jumpNum = 0;
		timeTaken = 0;
		objectHeight = 0;
	}

	private void setVelocity() {
		if (jumpNum == 0) {
			velocityI = (int) (length * GRAVITY);
		} else {
			velocityI = (int) (velocityF / 2.0);
			velocityF = 0;
		}
		
		jumpNum++;

	}

	public void setTimeTaken(double beginTime, double endTime) {
		timeTaken = endTime - beginTime;
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public void setObjectHeight(int heightI, int heightF) {
		objectHeight = heightF - heightI;
	}

	public int getObjectHeight() {
		return objectHeight;
	}

	public int calculateDistance(double angle) {
		
		
		xVelocity = (int) (velocityI * Math.cos(angle));

		int distance = (int) (timeTaken * xVelocity);

		setVelocity();
		jumpNum++;

		return distance;
	}

	public int calculateFinalVelocity(double angle) {

		yVelocityI = (int) (velocityI * Math.sin(angle));
		yVelocityF = (int) (Math.sqrt(Math.pow(yVelocityI, 2) - 2 * GRAVITY * objectHeight));
		velocityF = (int) (Math.sqrt(Math.pow(xVelocity, 2) + Math.pow(yVelocityF, 2)));

		return velocityF;
	}

	public int getJumpNum() {
		return jumpNum;
	}

	/*
	 * public int calculateMaxHeight(int length, double angle, TimeTracker time)
	 * {
	 * 
	 * this.length = length; int maxHeight = (int) (height + (velocity * time /
	 * 2.0) + (0.5 * GRAVITY * Math.pow(time, 2)));
	 * 
	 * return maxHeight; }
	 */

	// METHODS

}
