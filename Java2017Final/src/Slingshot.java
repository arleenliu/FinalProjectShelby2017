// Arleen

public class Slingshot {

	// FIELDS
	// subject to change
	public static final double GRAVITY = 9.81;
	private int length;
	// velocityI calculation will be figured out later
	private int velocityI, velocityF;
	private int xVelocity, yVelocityI, yVelocityF;
	private int jumpNum;
	private int objectHeight;
	private double angle;

	// CONSTRUCTORS
	// to be deleted later
	public Slingshot() {

	}

	public int calculateCurrentXVelocity() {
		return xVelocity;
	}

	public Slingshot(int length, double angle, int initialHeight) {
		this.length = length;
		this.angle = angle;
		jumpNum = 0;
		velocityI = (int) (length * GRAVITY);
		velocityF = 0;
		yVelocityF = 0;
		yVelocityI = (int) (velocityI * Math.sin(angle));
		xVelocity = (int) (velocityI * Math.cos(angle));
		objectHeight = 0;
	}

	public void setVelocity() {
		calculateFinalVelocity();

		velocityI = (int) (-velocityF / 2.0);
		velocityF = 0;

	}

	public int getInitialVelocity() {
		return velocityI;
	}

	public int getInitialYVelocity() {
		return yVelocityI;
	}

	public int getXVelocity() {
		return xVelocity;
	}
	
	public void setObjectHeight(int heightI, int heightF) {
		objectHeight = heightF - heightI;
	}

	public int getObjectHeight() {
		return objectHeight;
	}

	/*
	 * public int calculateDistance(double angle) {
	 * 
	 * 
	 * xVelocity = (int) (velocityI * Math.cos(angle));
	 * 
	 * int distance = (int) (timeTaken * xVelocity);
	 * 
	 * setVelocity();
	 * 
	 * return distance; }
	 */

	public void calculateFinalVelocity() {

		yVelocityI = (int) (velocityI * Math.sin(angle));
		xVelocity = (int) (velocityI * Math.cos(angle));
		yVelocityF = (int) (Math.sqrt(Math.pow(yVelocityI, 2) - 2 * GRAVITY * (-objectHeight)));
		velocityF = -(int) (Math.sqrt(Math.pow(xVelocity, 2) + Math.pow(yVelocityF, 2)));

	}

	public void incrementJumpNum() {
		jumpNum++;
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
