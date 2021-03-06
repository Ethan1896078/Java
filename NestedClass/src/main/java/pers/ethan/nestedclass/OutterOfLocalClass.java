package pers.ethan.nestedclass;

public class OutterOfLocalClass {
	/** 外围类类变量 */
	public static int staticVariableOfOutter;
	/** 外围类实例变量 */
	private int instanceVariableOfOutter;
	
	public static void staticMethod(final int arg1, int arg2){
		final int finalVariableOfStaticMethod = 1;
		int nonFinalVariableOfStaticMethod = 1;
		
		class LocalClassOfStaticMethod{
			public void method() {
				System.out.println(arg1);	// 内部类可以访问外围块的final形参
//				System.out.println(arg2);	// 内部类不可以访问外围块的非final形参
				System.out.println(finalVariableOfStaticMethod);	// 内部类可以访问外围块的final局部变量
//				System.out.println(nonFinalVariableOfStaticMethod); 	// 内部类不可以访问外围块的非final局部变量
				System.out.println(staticVariableOfOutter);	// 静态方法可以访问类变量，其访问权也传承给内部类了 
//				System.out.println(instanceVariableOfOutter);	// 静态方法不可以访问实例变量，也无法将其访问权传承给内部
			}
		}
	}
	
	public void nonStaticMethod(final int arg1, int arg2){
		final int finalVariableOfNonStaticMethod = 1;
		int nonFinalVariableOfNonStaticMethod = 1;
		
		class LocalClassOfNonStaticMEthod{
			public void method(){
				System.out.println(arg1);	// 内部类可以访问外围块的final形参
//				System.out.println(arg2);	// 内部类不可以访问外围块的非final形参
				System.out.println(finalVariableOfNonStaticMethod);	// 内部类可以访问外围块的final局部变量
//				System.out.println(nonFinalVariableOfNonStaticMethod); 	// 内部类不可以访问外围块的非final局部变量
				System.out.println(staticVariableOfOutter);	// 普通方法可以访问类变量，其访问权也传承给内部类了 
				System.out.println(instanceVariableOfOutter);	// 普通方法可以访问实例变量，其访问权也传承给内部类了 
			}
		}
	}
	
}
