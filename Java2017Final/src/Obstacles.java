import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Obstacles {
	
	int x1, x2, x3;
	int y1, y2, y3;
	
	public Obstacles(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;

	}
	
	public void drawObstacle(Graphics g, Color colour) {
		g.setColor(colour);
		
		Polygon obstacle = new Polygon();
		obstacle.addPoint(x1, y1);
		obstacle.addPoint(x2, y2);
		obstacle.addPoint(x3, y3);
		
		g.fillPolygon(obstacle);
		
	}

}