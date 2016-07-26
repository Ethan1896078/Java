package pers.ethan.thread.exception;

import java.util.concurrent.atomic.AtomicInteger;

public class OccurException {
	public static void main(String[] args) {
		final AtomicInteger threadCounter = new AtomicInteger(0);
		final AtomicInteger count = new AtomicInteger(0);
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					threadCounter.incrementAndGet();
					while (count.incrementAndGet() < 100) {
						
						System.out.println(Thread.currentThread().getName() + " -> " + threadCounter.intValue());
						
						try {
							synchronized (threadCounter) {
								if (threadCounter.intValue() < 6) {
									throw new RuntimeException(Thread.currentThread().getName() + " occur exception");
								}
							}
						} catch (Exception e) {
						}
					}
					threadCounter.decrementAndGet();							
				}
			}).start();
		}
		
		while (threadCounter.intValue() != 0) {
		}
		
		System.out.println("finish");
	}
}
