package io.zhaoyang.java24hr.lesson17;

public class MarketNews extends Thread {
	public MarketNews(String threadName) {
		super(threadName);
	}
	
	public void run() {
		System.out.println("The stock market is improving!");
	}
}
