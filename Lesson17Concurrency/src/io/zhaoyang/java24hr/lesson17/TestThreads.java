package io.zhaoyang.java24hr.lesson17;

public class TestThreads {

	public static void main(String[] args) {
		MarketNews mn = new MarketNews("Market News");
		mn.start();
		
		Portfolio p = new Portfolio("Portfolio data");
		p.start();
		
		System.out.println("TestThread is finished");
	}

}
