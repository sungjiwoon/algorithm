package Thread;

public class RunnableTest implements Runnable {
	public void run() {
		try { 
			for (int i = 0; i < 5; i++) {
				Thread.sleep(200); //0.2���� ���ð� 
				System.out.println("runnable ������  " + i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
