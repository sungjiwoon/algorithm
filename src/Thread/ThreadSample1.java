package Thread;

import java.util.ArrayList;

public class ThreadSample1 extends Thread {
	int seq;
	ThreadSample1(int seq) {
		this.seq = seq;
	}
	
	public void run() {
		System.out.println(this.seq+" thread start.");
	    try {
	    	Thread.sleep(1000);
	    }catch(Exception e) {
	    }
	        
	    System.out.println(this.seq+" thread end.");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Thread> threads = new ArrayList<>();
	        
		for(int i=1; i<=4; i++) {	            
			Thread t = new ThreadSample1(i);	            
			t.start();	            
			threads.add(t);	        
		}

	        
//		for(int i=0; i<threads.size(); i++) {	            
//			Thread t = threads.get(i);	            
//			try {	                
//				t.join(); // t 쓰레드가 종료할 때까지 기다린다.     
//			}catch(Exception e) {    
//			}    
//		}	        
		System.out.println("main end.");
	}

}
