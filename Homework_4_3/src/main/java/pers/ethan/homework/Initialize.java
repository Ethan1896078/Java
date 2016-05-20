package pers.ethan.homework;

class Child extends Parent{
	public static Someone someone;
	
	public Child() {
		System.out.println("constructor in Child");
	}
	
	static{
		System.out.println("static block1 in Child");
	}
	
	{
		System.out.println("normal block in Child");
	}
	
	static{
		System.out.println("static block2 in Cihld");
	}
	
	public static Someone someone2;
	
}


public class Initialize {
	public static Someone someone = new Someone(1);
	
	static{
		System.out.println("static block in public class");
	}

	public Initialize() {
		System.out.println("constructor in public class");
	}
	
	public static void main(String[] args) {
//		Child child = new Child();
//		Someone someone = new Someone();
	}

}

class Someone{
	static{
		System.out.println("static block in Someone");
	}
	
	public Someone() {
		System.out.println("no args constructor in Someone");
	}
	
	public Someone(int i){
		System.out.println("1 args constructor in Someone");
	}
}


class Parent{
	public static Someone someone;
	
	static{
		System.out.println("static block in Parent");
	}
	
	public Parent() {
		System.out.println("constructor in Parent");
	}
}

