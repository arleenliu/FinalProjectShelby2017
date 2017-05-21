import java.awt.*;
import javax.swing.*;

//will have shelby's face + results
//find star image clipart? three out of five depending on time
public class ResultScreen extends Screen {
	
	private int score;
	private Image starImg;
	private Image shelbyFace;
	
	public ResultScreen() {
		starImg = (new ImageIcon("starImg.png").getImage());
		shelbyFace = (new ImageIcon(" where shelby face?").getImage());
		
		//int time = getTime()? method in timetracker?
		
		/*if(time >= this)
			score = 1; 
		else if(time >= something)
			score = 2; 
		etc etc
		*/
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(starImg, 100,  200,  50, 50, this);
	}
	
	
	

}
