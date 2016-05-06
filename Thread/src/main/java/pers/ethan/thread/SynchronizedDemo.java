package pers.ethan.thread;

import java.util.Iterator;

public class SynchronizedDemo {
	
	private static int count;
	
	/**
	 * 静态同步方法
	 * @param value
	 */
	public static synchronized void add1(int value){
		count += value;
		System.out.println(Thread.currentThread().getName() + " ----> " + count);
	}
	
	/**
	 * 实例同步方法
	 * @param value
	 */
	public synchronized void add2(int value){
		this.count += value;
		System.out.println(Thread.currentThread().getName() + " ----> " + count);
	}
	
	/**
	 * 静态方法中的同步块
	 * @param value
	 */
	public static void add3(int value){
		synchronized (SynchronizedDemo.class) {
			count += value;
			System.out.println(Thread.currentThread().getName() + " ----> " + count);
		}
	}
	
	/**
	 * 实例方法中的同步块
	 * @param value
	 */
	public void add4(int value){
		synchronized (this) {
			this.count += value;
			System.out.println(Thread.currentThread().getName() + " ----> " + count);
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new MyThread());
			thread.start();
		}
		
	}
}

class MyThread implements Runnable{
	
	private static SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

	public void run() {
		while (true) {
//			SynchronizedDemo.add1(1);
			synchronizedDemo.add2(1);
		}
	}
	
}
