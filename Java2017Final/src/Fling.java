import javax.swing.JFrame;

public class Fling {
	
	//levels one - five are 1-5
	//title is 6, level is 7, game is 8, result is 
	public static int Screen;
	
	public Fling() {
		Screen = 6;
	}
	
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen panel = new GameScreen(1);
		TitleScreen titlePanel = new TitleScreen();
		ResultScreen resultPanel = new ResultScreen();
		LevelScreen levelPanel = new LevelScreen();
		w.add(panel);
		w.setResizable(false);
		w.setVisible(true);

		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);
		levelPanel.addMouseListener(levelPanel);
	}
	
}
