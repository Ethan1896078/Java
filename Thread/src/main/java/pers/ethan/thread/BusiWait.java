package pers.ethan.thread;


public class BusiWait {
	
	/*
	 * 这个例子只是用来说明通过共享对象来实现线程间通信，并未采取线程安全措施
	 */
	public static void main(String[] args) {
		class Counter{
			int count = 0;
		}
		
		class CountRunnable1 implements Runnable{
			private Counter counter;
			
			CountRunnable1(Counter countter){
				this.counter = countter;
			}

			public void run() {
				while (counter.count <= 100) {
					// 负责偶数自增
					if (counter.count % 2 == 0) {
						System.out.println("    " + Thread.currentThread().getName() + " -> " + counter.count++);
					}
				}
			}
			
		}
		
		class CountRunnable2 implements Runnable{
			private Counter counter;

			CountRunnable2(Counter countter){
				this.counter = countter;
			}
			
			public void run() {
				while (counter.count <= 100) {
					// 负责奇数自增
					if (counter.count % 2 == 1 ) {
						System.out.println(Thread.currentThread().getName() + " -> " + counter.count++);
					}
				}
			}
			
		}
		
		Counter counter = new Counter();
		new Thread(new CountRunnable1(counter)).start();
		new Thread(new CountRunnable2(counter)).start();
	}
	
}
