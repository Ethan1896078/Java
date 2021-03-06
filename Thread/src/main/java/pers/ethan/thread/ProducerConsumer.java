package pers.ethan.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class ProducerConsumer {
	private static int MAX_SIZE = 10;
	
	/*
	 * 这个例子只是用来说明通过共享对象来实现线程间通信，并未采取线程安全措施
	 */
	public static void main(String[] args) {
		class Counter{
			int count = 0;
		}
		
		class Producer implements Runnable{
			private Queue<Integer> queue;
			
			Producer(Queue<Integer> queue){
				this.queue = queue;
			}

			public void run() {
				int i = 0;
				synchronized (queue) {
					while (true) {
						while (queue.size() >= MAX_SIZE) {
							try {
								queue.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						int newObject = new Random().nextInt();
						queue.add(newObject);
						System.out.println(Thread.currentThread().getName() + " ---> " + newObject);
						queue.notifyAll();
					}
				}	
			}
		}
		
		class Consumer implements Runnable{
			private Queue<Integer> queue;

			Consumer(Queue<Integer> queue){
				this.queue = queue;
			}
			
			public void run() {
				synchronized (queue) {
					while (true) {
						while (queue.size() <= 0) {
							try {
								queue.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						Integer removedObject = queue.remove();
						System.out.println(Thread.currentThread().getName() + " -> " + removedObject);
						queue.notifyAll();
					}
				}
			}
			
		}
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		new Thread(new Producer(queue), "Producer").start();;
		new Thread(new Consumer(queue), "Consumer").start();
		
	}
	
}
