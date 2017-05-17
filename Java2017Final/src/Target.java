import java.awt.Color;
import java.awt.Graphics;

public class Target {
	private int xLoc, yLoc, size;
	
	public Target (){
		size = 50;
		xLoc = 725;
		yLoc = 225;
	}
	
	public void drawTarget(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(xLoc, yLoc, size, size-10);
	}
}
