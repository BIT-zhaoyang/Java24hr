package io.zhaoyang.java24hr.lesson17;

public class TestLambdaWaitNotify {
	
	private static Runnable getMktNewsRunnable1(Object whoToNotify) {
		// returning a closure
		return () -> {
			try {
				synchronized(whoToNotify) {
				for(int i = 0; i < 10; ++i) {
					Thread.sleep(1000);
					System.out.println("The market is improving " + i);
				}
				
				
					whoToNotify.notify();
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() +
						e.toString());
			}
		};
	}
	
	private static Runnable getMktNewsRunnable2(Object whoToNotify) {
		// returning a closure
		return () -> {
			try {
				synchronized(whoToNotify) {
				for(int i = 0; i < 5; ++i) {
					Thread.sleep(1000);
					System.out.println("The market is decreasing " + i);
				}
				
				
					whoToNotify.notify();
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() +
						e.toString());
			}
		};
	}

	public static void main(String[] args) {
		TestLambdaWaitNotify thisInstance = new TestLambdaWaitNotify();
		
		Runnable mktNewsRunnable1 = getMktNewsRunnable1(thisInstance);
		Runnable mktNewsRunnable2 = getMktNewsRunnable2(thisInstance);
		Thread marketNews1 = new Thread(mktNewsRunnable1, "");
		Thread marketNews2 = new Thread(mktNewsRunnable2, "");
		marketNews1.start();
		marketNews2.start();
		
		synchronized(thisInstance) {
			try {
				thisInstance.wait(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The main method of TestLambdaWaitNotify is finished");
	}

}
