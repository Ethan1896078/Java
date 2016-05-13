package pers.ethan.callback;

public class Caller implements Callback{

	// 主调函数必须实现回调接口，并实现其回调函数
	public void callbackMethod(int result) {
		System.out.println("Caller : the result is " + result);
	}

	public static void main(String[] args) {
		Caller caller = new Caller();
		Callee callee = new Callee();
		callee.setCaller(caller);
		callee.add(1, 2);
	}
}
