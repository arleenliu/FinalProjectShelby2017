import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

//will have shelby's face + results
//find star image clipart? three out of five depending on time
public class ResultScreen extends Screen {

	private int score;
	private Image starImg;
	private Image shelbyFace, catImg;

	public ResultScreen() {
		starImg = (new ImageIcon("starImg.png").getImage());
		shelbyFace = (new ImageIcon("shelbyface.JPG").getImage());
		catImg = (new ImageIcon("booboo.jpg").getImage());

		score = 5;

		//int time = getTime()? method in timetracker?

		/*if(time >= this)
			score = 1;
		else if(time >= something)
			score = 2; 
		etc etc
		 */
	}

	public void paintComponent(Graphics g) {		
		g.drawImage(catImg, 0, 0, 800, 600, this);

		for(int i = 0; i < score; i++) {
			g.drawImage(starImg, 250 + 60*i, 200, 50, 50, this);
		}

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

	}

	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 100 && xClick <= 700 && yClick >= 80 && yClick <= 550)
			Fling.Screen = 7;
	}
}
