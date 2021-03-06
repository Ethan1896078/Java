package pers.ethan.thread;

public class WaitThread {

	public static void main(String[] args) {
		class SharedClass{
		}
		
		class Wait implements Runnable{
			private SharedClass sharedInstance;
			
			public Wait(SharedClass sharedInstance) {
				this.sharedInstance = sharedInstance;
			}

			public void run() {
				synchronized(sharedInstance){
					System.out.println(Thread.currentThread().getName() + " -> before wait()" );
					try {
						sharedInstance.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " -> after wait()" );
				}
			}
		}
		
		class Notify implements Runnable{
			private SharedClass sharedInstance;
			
			public Notify(SharedClass sharedInstance) {
				this.sharedInstance = sharedInstance;
			}

			public void run() {
				synchronized (sharedInstance) {
					System.out.println(Thread.currentThread().getName() + " -> notifyALl()" );
					sharedInstance.notifyAll();
				}
			}
		}
		
		SharedClass sharedInstance = new SharedClass();
		/** 第一组用于说明wait、notify的作用 */
		// 只启动Wait线程时，只能输出WaitThread -> before wait()，说明在sharedInstance.wait()后立马放弃了对CPU的占用
		new Thread(new Wait(sharedInstance), "WaitThread").start();
		// 启动Notify线程时，正在等待sharedInstance的线程WaitThread被唤醒
		new Thread(new Notify(sharedInstance), "NotifyThread").start();
		
		/** 第二组用于说明sleep的作用 */
		/*new Thread(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> before sleep()" );
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " -> after sleep()" );
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("-");
				}
			}
		}).start();*/
		
		/** 第三组用于说明wait对锁的占用情况 */
		/*new Thread(new Wait(sharedInstance)).start();
		new Thread(new Wait(sharedInstance)).start();*/
	}

	
}
