package pers.ethan.socketserver;

public class DeepCopy {

	public static void main(String[] args) {
		Integer i1 = new Integer(0);
		Integer i2 = new Integer(0);
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
	}

}
