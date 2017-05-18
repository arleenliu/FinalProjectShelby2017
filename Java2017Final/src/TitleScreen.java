import java.awt.*;
import javax.swing.*;

public class TitleScreen extends JPanel {
	
	private Image catImg;
	
	public TitleScreen() {
		catImg = (new ImageIcon("booboo.jpg").getImage());
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(catImg, 0, 0, 800, 600, this);
		g.setColor(Color.CYAN);
		Font font1 = new Font("SansSerif", Font.BOLD | Font.ITALIC, 39);
		g.setFont(font1);
		g.drawString("Fling!!!", getWidth()/4, getHeight()/4);
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


	}

}