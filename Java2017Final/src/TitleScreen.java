import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TitleScreen extends Screen {
	
	private Image titleImg;
	private boolean nextScreen;
	
	public TitleScreen() {
		titleImg = (new ImageIcon("FlingTitleScreen.png").getImage());
		nextScreen = true;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(titleImg, 0, 0, 800, 600, this);
		
		Font newFont = new Font("Arial", Font.BOLD, 20);
		g.setFont(newFont);
		g.drawString("Click on the unicorn Pusheen to continue!", 185, 330);
		
		if(nextScreen == true) {
			g.drawString("test test test", 300, 400);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();
		
		if(xClick >= 460 && xClick <= 700 && yClick >= 410 && yClick <= 550) {
			nextScreen = !nextScreen;
		}
		
		repaint();
	}

}