// Arleen

public class Slingshot {

	// FIELDS
	// subject to change
	public static final double GRAVITY = 0.1;
	public static final double SCALE = 0.01;
	private int length;
	// velocityI calculation will be figured out later
	private double velocityI, velocityF;
	private double xVelocity, yVelocityI, yVelocityF;
	private int jumpNum;
	private int objectHeight;
	private double angle;
	private int x1, y1, x2, y2;

	// CONSTRUCTORS
	// to be deleted later

	public double calculateCurrentXVelocity() {
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
		objectHeight = 0;
		velocityF = 0;
		yVelocityF = 0;
	}
	
	private void calculateInitialVelocity() {
		velocityI = (length * SCALE);
		yVelocityI =  (velocityI * Math.sin(angle));
		xVelocity =  (velocityI * Math.cos(angle));
	}

	public void setVelocity() {
		if (Character.getHasHitTop()){
			calculateFinalVelocity();
			velocityI =  (-velocityF);
			velocityF = 0;
		}
		
		if (Character.getHasHitBottom()){
			this.angle = -angle;
			velocityF = velocityI;
		}

	}

	public double getInitialVelocity() {
		return velocityI;
	}

	public double getInitialYVelocity() {
		return yVelocityI;
	}

	public double getXVelocity() {
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

		yVelocityI =  (velocityI * Math.sin(angle));
		xVelocity =  (velocityI * Math.cos(angle));
		yVelocityF =  (Math.sqrt(Math.pow(yVelocityI, 2) - 2 * GRAVITY * (-objectHeight)));
		velocityF = - (Math.sqrt(Math.pow(xVelocity, 2) + Math.pow(yVelocityF, 2)));

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
		angle = Math.atan((y1 - y2) / (double) (x1 - x2));
	
		calculateInitialVelocity();
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
