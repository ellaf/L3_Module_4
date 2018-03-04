package threads;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	public static void main(String[] args) {
		

		Thread t1 = new Thread(()->makeThread(0));
		t1.start();
		



	}
	
	public static void makeThread(int i) {
		
		if(i > 49) {
				
		}else {
		i++;
		
		try {
			int j = i;
		Thread a = new Thread(()->makeThread(j));
		a.start();
		a.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from thread " + i + "!");
		}
	}
}
