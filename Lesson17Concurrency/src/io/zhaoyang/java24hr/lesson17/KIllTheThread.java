package io.zhaoyang.java24hr.lesson17;

public class KIllTheThread {

	public static void main(String[] args) {
		PortfolioVolatile p = new PortfolioVolatile("Portfolio data");
		p.start();
		
		for(int i = 0; i < 50; ++i) {
			System.out.println("i = " + i);
		}
		
		p.stopMe();
	}

}

class PortfolioVolatile extends Thread {

	private volatile Thread stopMe;
	
	public PortfolioVolatile (String threadName) {
		super(threadName);
	}
	
	public void stopMe() {
		stopMe = null;
	}
	
	public void run() {
		stopMe = Thread.currentThread();
		
		while(stopMe == Thread.currentThread()) {
			System.out.println("The Portfolio thread is running");
		}
		System.out.println("The Portfolio thread was killed");
	}
}
