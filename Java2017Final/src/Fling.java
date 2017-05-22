import java.awt.Component;

import javax.swing.JFrame;

public class Fling {
	
	//title is 6, level is 7, game is 8, result is 9
	public static int Screen;
	//levels one-five are 1-5
	public static int level;
	
	public Fling() {
		Screen = 6;
	}
	
	public void returnScreen() {
		System.out.println(Screen + "");
	}
	
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameScreen panel = new GameScreen(level);
		TitleScreen titlePanel = new TitleScreen();
		ResultScreen resultPanel = new ResultScreen();
		LevelScreen levelPanel = new LevelScreen();
		
		System.out.println(Screen + "");

		
		if(Screen != 6)
			w.add(titlePanel);
		/*else if(Screen == 7)
			w.add(levelPanel);
		else if(Screen == 8)
			w.add(panel);
		else if(Screen == 9)
			w.add(resultPanel); */
		
		w.setResizable(false);
		w.setVisible(true);

		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);
		levelPanel.addMouseListener(levelPanel);
	}
	
}
