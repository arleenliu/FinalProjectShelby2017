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

	public static void main(String[] args)
	{
		w = new Fling("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		
		GameScreen panel = new GameScreen(level);
		TitleScreen titlePanel = new TitleScreen();
		ResultScreen resultPanel = new ResultScreen();
		LevelScreen levelPanel = new LevelScreen();
				

		if(Screen == 6) {

			w.getComponent(0);
		}	else if(Screen == 7)
			w.getComponent(1);
		else if(Screen == 8)
			w.getComponent(2);
		else if(Screen == 9)
			w.getComponent(3);
	}

	public static void main(String[] args)
	{
		
		
			w.add(titlePanel);
			System.out.println(Screen + "");
			System.out.println(level + "");

	
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
