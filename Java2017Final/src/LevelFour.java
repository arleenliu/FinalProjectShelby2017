import java.awt.Color;
import java.util.ArrayList;

public class LevelFour {
	//FIELDS
	Obstacle ob1, ob2, ob3, ob4;
	
	//CONSTRUCTORS
	
	public LevelFour (){
		
		ob1 = new Obstacle (100, 0, 200, 0, 150, 250, Color.BLACK);
		ob2 = new Obstacle (200, 600, 300, 600, 250, 320, Color.BLACK);
		ob3 = new Obstacle (300, 0, 400, 0, 350, 270, Color.BLACK);
		ob4 = new Obstacle (400, 600, 500, 600, 450, 320, Color.BLACK);
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		ArrayList<Obstacle> x = new ArrayList<Obstacle>();
		x.add(ob1);
		x.add(ob2);
		x.add(ob3);
		x.add(ob4);
		
		return x;
	}

	
}
