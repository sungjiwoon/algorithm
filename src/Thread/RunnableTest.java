package Thread;

public class RunnableTest implements Runnable {
	public void run() {
		try { 
			for (int i = 0; i < 5; i++) {
				Thread.sleep(200); //0.2초의 대기시간 
				System.out.println("runnable 스레드  " + i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
