package pers.ethan.homework;


public class WithFinalize{
	private String name;
	
	public WithFinalize(String name) {
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(name + " finalize...");
		super.finalize();
	}
	
	public static void main(String[] args) {
		WithFinalize withFinalize = null;
		/**
		 * 当循环次数很小时，如不足10000，jvm有足够的内存来存储，不会立即调用GC；但是可以通过System.gc()主动提醒JVM去调用GC
		 * 当循环次数足够大时，如100000，jvm的内存不足了，需要通过GC来释放一些未被引用的堆内存
		 */
		for (int i = 0; i < 10000; i++) {
			withFinalize = new WithFinalize("No." + i);
		}
		System.gc();
	}
	
}
