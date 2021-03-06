package pers.ethan.thread;

public class ThreadLocalDemo {
	private static class Student{
		private int age;
	}
	
	private static class MyRunnable implements Runnable{
		private ThreadLocal<Student> threadLocalStudent = new ThreadLocal<ThreadLocalDemo.Student>(){
			@Override
			// 注意，这里只能通过重写initialValue来设置初始值，而不能在MyRunnable的构造方法里通过set设置。
			protected Student initialValue() {
				Student student = new Student();
				student.age = 1;
				return student;
			}
		};
		
		public void run() {
			while (true) {
				Student student = threadLocalStudent.get();
				student.age++;
				threadLocalStudent.set(student);
				System.out.println(Thread.currentThread().getName() + " -> " + student.age);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
	}
}
