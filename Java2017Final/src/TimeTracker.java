import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimeTracker implements ActionListener {

	private int time;
	private boolean characterDead;
	
	public TimeTracker() {
		time = 0;
	    Timer clock = new Timer(1000, this); 
	    clock.start();
	    
	    
	    
	    //if(this.returnStatus() == true)
	    	clock.restart();
	}

	
	public int getTime() {
		return time;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		time++;
	}
}
