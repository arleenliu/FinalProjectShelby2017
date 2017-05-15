import java.awt.Color;
import java.awt.Graphics;

//delete this later prob
public class HelperObject {

	int x, y;
	int width;
	int height;
	
	public HelperObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void draw(Graphics g, Color colour) {
		g.setColor(colour);
		g.fillRect(x, y, width, height);
	}
}
