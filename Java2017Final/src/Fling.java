import java.awt.CardLayout;

import javax.swing.JFrame;

public class Fling extends JFrame{
	
	//title is 6, level is 7, game is 8, result is 9
	public static int Screen;
	private static TitleScreen titlePanel;
	private static ResultScreen resultPanel;
	private static LevelScreen levelPanel;
	private static GameScreen panel;
	private static CardLayout cl;
	
	//levels one-five are 1-5
	public static int level;
	
	public Fling() {
		Screen = 6;

		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new GameScreen(level);
		titlePanel = new TitleScreen();
		resultPanel = new ResultScreen();
		levelPanel = new LevelScreen();
		cl = new CardLayout();
		
		this.setLayout(cl);
		
		this.add(titlePanel, "Title");
		this.add(levelPanel, "Level");
		this.add(panel, "Game");
		this.add(resultPanel, "Results");

		//cl.show(this, "Title");
		
	}

	public static void main(String[] args)
	{
		
		Fling w = new Fling();
		// this.setResizable(false);
		// this.setVisible(true);


		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);
		levelPanel.addMouseListener(levelPanel);
		
		if (Screen == 6){
			cl.show(w, "Title");
		}
		else if(Screen == 7)
			cl.show(w, "Level");
		else if(Screen == 8)
			cl.show(w, "Game");
		else if(Screen == 9)
			cl.show(w, "Results");
		
		w.setResizable(false);
		w.setVisible(true);
		w.run();
	}
	
	public void run(){
		
		while (true){
//			if(Screen == 6) {
//				cl.show(w, "Title");
//			}
//			else if(Screen == 7)
//				cl.show(w, "Level");
//			else if(Screen == 8)
//				cl.show(w, "Game");
//			else if(Screen == 9)
//				cl.show(w, "Results");
			
		}
		
	}
	
}
