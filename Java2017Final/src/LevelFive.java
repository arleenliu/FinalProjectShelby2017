import java.awt.Color;
import java.util.ArrayList;

public class LevelFive {
	//FIELDS
	Obstacle ob1;
	
	//CONSTRUCTORS
	
	public LevelFive (){
		
		ob1 = new Obstacle (15, 0, 270, 0, 150, 100, Color.GREEN);
		
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		ArrayList<Obstacle> x = new ArrayList<Obstacle>();
		x.add(ob1);
		
		return x;
	}

	
}