package pers.ethan.thread.visibility;

public class VolatileDemo {
	public static void main(String[] args) {
		Counter counter = new Counter();
		new Thread(counter).start();
		
		new Thread(new Viewer(counter)).start();
		
	}
	
}

class Counter implements Runnable{
	volatile int count = 0;

	public void run() {
		while (true) {
			System.out.println("Counter线程里：" + count++);
		}
	}
}

class Viewer implements Runnable{
	
	Counter counter;

	public Viewer(Counter counter){
		this.counter = counter;
	}
	
	public void run() {
		while (true) {
			System.out.println("Viewer线程里：" + counter.count);
		}
	}
	
}