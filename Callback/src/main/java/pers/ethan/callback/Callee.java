package pers.ethan.callback;

public class Callee {
	// 关键点之一，被调对象中必须有一个主调对象的引用
	private Callback caller;
	
	public void setCaller(Callback caller) {
		this.caller = caller;
	}

	public void add(int a, int b){
		try {
			System.out.println("Callee : give me 2 second to get the result...");
			Thread.sleep(2000);
			int result = a + b;
			// 关键点之二，调用主调对象的回调方法
			caller.callbackMethod(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
