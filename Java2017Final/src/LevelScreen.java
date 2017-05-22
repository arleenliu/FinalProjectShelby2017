import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class LevelScreen extends Screen {

	private Image level1, level2, level3, level4, level5;

	public LevelScreen() {
		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);
		
		level1 = (new ImageIcon("pusheen1.png").getImage());
		level2 = (new ImageIcon("pusheen2.png").getImage());
		level3 = (new ImageIcon("pusheen3.png").getImage());
		level4 = (new ImageIcon("pusheen4.png").getImage());
		level5 = (new ImageIcon("cheesecakeImg.png").getImage());		
	}

	public void paintComponent(Graphics g) {

		g.drawImage(level1, 100, 200, 200, 150, this);
		//g.draw
	}
	
	public void 
}