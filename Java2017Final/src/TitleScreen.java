import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TitleScreen extends Screen {
	
	private Image catImg;
	private boolean showTitle;
	
	public TitleScreen() {
		catImg = (new ImageIcon("booboo.jpg").getImage());
		showTitle = true;
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(catImg, 0, 0, 800, 600, this);
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
	
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TitleScreen panel = new TitleScreen();
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);
		
		panel.addMouseListener(panel);

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