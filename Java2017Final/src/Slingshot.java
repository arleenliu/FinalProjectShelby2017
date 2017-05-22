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
	private int x1, y1, x2, y2;

	// CONSTRUCTORS
	// to be deleted later

	public int calculateCurrentXVelocity() {
		return xVelocity;
	}

	public Slingshot() {
		x1 = 95;
		y1 = 340;
		x2 = 95;
		y2 = 340;
		
		length = 0;
		angle = 0;
		jumpNum = 0;
		velocityI = (int) (length * GRAVITY);
		velocityF = 0;
		yVelocityF = 0;
		yVelocityI = (int) (velocityI * Math.sin(angle));
		xVelocity = (int) (velocityI * Math.cos(angle));
		objectHeight = 0;
	}

	public void setVelocity() {
		if (Character.getHasHitTop()){
			calculateFinalVelocity();
			velocityI = (int) (-velocityF / 2.0);
			velocityF = 0;
		}
		
		if (Character.getHasHitBottom()){
			this.angle = -angle;
		}

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
	
	public void setXY(int x, int y) {
		x2 = x;
		y2 = y;
		
		length = (int) Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
		angle = Math.atan((y1 - y2) / (double) (x1 - 2));
	
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
