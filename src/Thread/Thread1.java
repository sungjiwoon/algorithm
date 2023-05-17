package Thread;
public class Thread1 {
	public static void main(String[] args) throws Exception {
		
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		
		System.out.println(t1.isAlive() + " " + t2.isAlive());
		
		//1. 동시에 같은 숫자가 나오는 start 
		t1.start();
		t2.start();
		
		t1.join();
		System.out.println(t1.isAlive() + " " + t2.isAlive());
		
//		System.out.println("---------");
		//2. 번갈아 가며 나오는 run
//		t1.run();
//		t2.run();
//		System.out.println(t1.isAlive() + " " + t2.isAlive());
//		
//		RunnableTest rt1 = new RunnableTest();
//		RunnableTest rt2 = new RunnableTest();
//		Thread th1 = new Thread(rt1);
//		Thread th2 = new Thread(rt2);
//		System.out.println(th1.isAlive() + " " + th2.isAlive());
//		th1.start();
//		th2.start();
//		th1.join();
//		System.out.println(th1.isAlive() + " " + th2.isAlive());
//		
//		th1.run();
//		th2.run();
//		System.out.println("=============");
//		System.out.println(th1.isAlive() + " " + th2.isAlive());
		
	}
}
