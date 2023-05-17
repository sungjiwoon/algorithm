package Thread;

public class ThreadTest extends Thread{
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(500); //0.5ÃÊ ´ë±â 
				System.out.println("Thread : " + i);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
