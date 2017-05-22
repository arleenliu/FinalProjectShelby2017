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
		shelbyFace = (new ImageIcon("shelbyface.png").getImage());
		
		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);

		score = 3;

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

		Font newFont = new Font("Arial Narrow", Font.PLAIN, 35);
		g.setFont(newFont);
		g.drawString("Your score is " + score + " out of 5 stars", 180, 300);
		
		String phrase = "";
		
		if(score == 1)
			phrase = "Wow you are almost as terrible as Arleen";
		else if(score == 2)
			phrase = "Okay??? I guess";
		else if(score == 3)
			phrase = "Nice";
		else if(score == 4)
			phrase = "Very nice";
		else if(score == 5)
			phrase = "Congratulations!! You get a Pusheen";
		
		Font f2 = new Font("Arial Narrow", Font.PLAIN, 26);
		g.setFont(f2);
		g.drawString(phrase, 185, 360);
		
		Font f3 = new Font("Arial Narrow", Font.PLAIN, 18);
		g.setFont(f3);
		g.drawString("Click on Shelby to continue", 615, 455);
		g.drawImage(shelbyFace, 700, 480, 70, 80, this);
	}

	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 700 && xClick <= 770 && yClick >= 480 && yClick <= 560)
			Fling.Screen = 7;
	}
}
