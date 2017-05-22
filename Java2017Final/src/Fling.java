import javax.swing.JComponent;
import javax.swing.JFrame;

public class Fling extends JFrame{
	
	//title is 6, level is 7, game is 8, result is 9
	public static int Screen;
	private static TitleScreen titlePanel;
	private static ResultScreen resultPanel;
	private static LevelScreen levelPanel;
	private static GameScreen panel;
	private static Fling w;
	
	//levels one-five are 1-5
	public static int level;
	
	public Fling(String name) {
		Screen = 6;
		
	}

	public static void main(String[] args)
	{
		w = new Fling("Fling");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new GameScreen(level);
		titlePanel = new TitleScreen();
		resultPanel = new ResultScreen();
		levelPanel = new LevelScreen();
		
		w.add(levelPanel);
		w.add(panel);
		w.add(resultPanel);
		w.add(titlePanel);
		
		if(Screen == 6) {
			w.getComponent(0);
		}
		else if(Screen == 7)
			w.getComponent(1);
		else if(Screen == 8)
			w.getComponent(2);
		else if(Screen == 9)
			w.getComponent(3);
		
		w.setResizable(false);
		w.setVisible(true);

		panel.addMouseListener(panel);
		panel.addMouseMotionListener(panel);
		titlePanel.addMouseListener(titlePanel);
		resultPanel.addMouseListener(resultPanel);
		levelPanel.addMouseListener(levelPanel);
		
		w.run();
	}
	
	public void run(){
		
		while (true){
			if(Screen == 6) {
				w.getComponent(0);
			}
			else if(Screen == 7)
				w.getComponent(1);
			else if(Screen == 8)
				w.getComponent(2);
			else if(Screen == 9)
				w.getComponent(3);

			System.out.println(Screen + "");
			
		}
		
	}
	
}
