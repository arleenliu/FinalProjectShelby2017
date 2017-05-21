import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TitleScreen extends Screen {
	
	private boolean showTitle;
	
	public TitleScreen() {
		showTitle = true;
		
	}
	
	public void paintComponent(Graphics g) {
		Color NEWGREEN = new Color(60, 222, 120);
		g.setColor(NEWGREEN);
		Font f1 = new Font("Arial", Font.BOLD, 45);
		g.setFont(f1);
		g.drawString("FLING", 50, 80);
		
		Color LESSGREEN = new Color(60, 179, 113);
		g.setColor(LESSGREEN);
		Font f2 = new Font("Arial Narrow", Font.PLAIN, 25);
		g.setFont(f2);
		g.drawString("Click anywhere near the cat to proceed", 430, 520);
		
		if(showTitle == false) 
			g.drawString("test test test", 300, 400);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();
		
		if(xClick >= 100 && xClick <= 700 && yClick >= 80 && yClick <= 550)
			showTitle = !showTitle;
		
		repaint();
	}

}