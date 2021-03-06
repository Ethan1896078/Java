package pers.ethan.nestedclass;

public class OutterOfMemberClass {
	/** 外围类类变量 */
	public static int staticVariableOfOutter;
	/** 外围类实例变量 */
	private int instanceVariableOfOutter;
	
	// 成员类之内部类
	private class InnerClass{
		/* 
		 * 两种方式可以使内部类包含类变量：
		 * 1.继承一个包含类变量的类（如下的HasBusiClass）或实现一个包含类变量的接口（如下的HasBusiInterface）
		 * 2.用final修饰
		 * */
//		public static int staticVariableOfInner;	// 内部类只能定义实例变量，而不能定义类变量。
		public static final int staticFinalVariableOfInner = 1;	// 可以定义由final修饰的类变量
		public int instanceVariableOfInner;	// 内部类可以定义实例变量
		
//		public static void staticMethodOfInner(){}	// 内部类只能定义普通方法，而不能定义静态方法
		public void instanceMethodOfInner(){	// 内部类可以定义普通方法
			System.out.println(staticVariableOfOutter);	// 内部类可以直接访问外部类的类变量
			System.out.println(instanceVariableOfOutter);	// 内部类可以直接访问外围类的实例变量，甚至是私有的
		}
	}
	
	// 成员类之静态类
	static class StaticMemberClass{
		public static int staticVariableOfStaticMemberClass;	// 静态类可以定义类变量
		public int instanceVariableOfStaticMemberClass;	// 静态类可以定义实例变量
		
		public static void staticMethodOfStaticMemberClass(){}	// 静态类可以不仅可以定义普通方法，还可以定义静态方法
		public void instanceMethodOfStaticMemberClass(){	// 静态类也可以定义普通方法
			System.out.println(staticVariableOfOutter);	// 静态类可以直接访问外部类的类变量
//			System.out.println(instanceVariableOfOutter);	// 静态类不可以直接访问外围类的实例变量
		}
	}
	
	public static void main(String[] args) {
		OutterOfMemberClass outterOfMemberClass = new OutterOfMemberClass();	
		InnerClass innerClass = outterOfMemberClass.new InnerClass();	// 每一个内部类的对象实例都有一个外围类的对象实例
		innerClass.instanceMethodOfInner();
//		System.out.println(outterOfMemberClass.instanceVariableOfInner);	// 外围类是不能访问成员类的成员，即使是公有的
		System.out.println(innerClass.instanceVariableOfInner);	// 可以通过内部类实例来访问内部类中的实例变量
	}
	
}

class HasStaticClass{
	public static int staticVariable = 1;
}

interface HasStaticInterface{
	public static int staticVariable = 1;
}

