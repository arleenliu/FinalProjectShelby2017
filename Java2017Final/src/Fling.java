import javax.swing.JFrame;

public class Fling {
	
	
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen panel = new GameScreen(1);
		//TitleScreen titlePanel = new TitleScreen();
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);

		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);

	}
	
}
