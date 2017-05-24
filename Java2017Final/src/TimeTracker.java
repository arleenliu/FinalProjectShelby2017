import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimeTracker implements ActionListener {

	private static int time;
	private boolean characterDead; 
	private Timer clock;
	
	public TimeTracker(Character character) {
		time = 0;
	    clock = new Timer(1000, this); 
	    clock.start();
	    
	    if(character.getHasDied() == true) {
	    	clock.stop();
	    	time = -1;
	    }
	}

	
	public static int getTime() {
		int t1 = time;
		
		return t1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		time++;
	}
	public void startTimeTracker(){
		time = 0;
	    clock = new Timer(1000, this);
		clock.start();
	}
}
