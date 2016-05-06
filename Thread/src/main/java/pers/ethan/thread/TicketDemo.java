package pers.ethan.thread;

public class TicketDemo {
	
	private int count;
	
	
	public TicketDemo(int count) {
		this.count = count;
	}
	
	public synchronized void sell(){
		if (count > 0) {
			count--;
			System.out.println(Thread.currentThread().getName() + " ----> " + count);
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		final int totalTikectNum = 10000;
		final int siteNum = 10;
		TicketDemo ticketDemo = new TicketDemo(totalTikectNum);
		// 只有在多个线程共享ticketDemo的情况下才能通过ticketDemo来通信，同样只有多个线程共享ticketDemo才需要保证线程安全。
		TicketDemoRunnable ticketDemoRunnable = new TicketDemoRunnable(ticketDemo);
		for (int i = 0; i < siteNum; i++) {
			new Thread(ticketDemoRunnable).start();
		}
	}

}

class TicketDemoRunnable implements Runnable{
	
	private TicketDemo ticketDemo;
	
	TicketDemoRunnable(TicketDemo ticketDemo){
		this.ticketDemo = ticketDemo;
	}
	
	public void run() {
		while (true) {
			ticketDemo.sell();
		}
	}
	
}
