import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TitleScreen extends Screen {

	private Image titleImg;

	public TitleScreen() {
		titleImg = (new ImageIcon("FlingTitleScreen.png").getImage());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(titleImg, 0, 0, 800, 600, this);

		Font newFont = new Font("Arial", Font.BOLD, 20);
		g.setFont(newFont);
		g.drawString("Click on the unicorn Pusheen to continue!", 185, 330);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 460 && xClick <= 700 && yClick >= 410 && yClick <= 550) {
			Fling.Screen = 7;
			System.out.println("asdad");
		}
	}


}