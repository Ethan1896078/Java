package pers.ethan.callback;

public class SeniorCaller implements Callback{

	// 主调函数必须实现回调接口，并实现其回调函数
	public void callbackMethod(int result) {
		System.out.println("Caller : now I know the result is " + result);
	}

	public static void main(String[] args) {
		SeniorCaller caller = new SeniorCaller();
		final Callee callee = new Callee();
		callee.setCaller(caller);
		new Thread(new Runnable() {
			
			public void run() {
				askCallee(callee, 1, 2);
			}
			
		}).start();
		
		caller.doSomethingElse();
	}
	
	private static void askCallee(Callee callee, int arg1, int arg2){
		System.out.println("Caller : ask Callee " + arg1 + " + " + arg2 + " = ?");
		callee.add(arg1, arg2);
	}

	private void doSomethingElse() {
		System.out.println("Caller : do something else");
	}
}
