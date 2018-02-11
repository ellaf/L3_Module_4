package threads;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		
		OlympicRings_Threaded me = new OlympicRings_Threaded();
		
		Robot george = new Robot(400, 700);
		Robot mary = new Robot(800,700);
		Robot susan = new Robot(1200,700);
		Robot ed = new Robot(600, 850);
		Robot jane = new Robot(1000, 850);
	
		george.setPenColor(Color.BLUE);
		mary.setPenColor(Color.BLACK);
		susan.setPenColor(Color.RED);
		ed.setPenColor(Color.YELLOW);
		jane.setPenColor(Color.GREEN);
		
		new Thread(()->me.makeRing(susan)).start();
		new Thread(()->me.makeRing(george)).start();
		Thread t = new Thread(()->me.makeRing(ed));
				t.start();
		
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->me.makeRing(mary)).start();
		new Thread(()->me.makeRing(jane)).start();
	
		
	}
	
	public void makeRing(Robot f) {
		f.setPenWidth(7);
		f.setSpeed(10);
		f.turn(90);
		f.penDown();
		for (int i = 0; i < 360; i++) {
				f.turn(-1);
				f.move(3);
		}

		
	}
	
	
}

