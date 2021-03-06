package pers.ethan.homework;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.lang3.SerializationUtils;

public class DeepCopy {
	public static void main(String[] args) {
		C c = new C(3);
		B b = new B(2, c);
		A a = new A(1, b);
		
		// 已知数据结构，手动深复制
		A aCopyByManual = deepCopyByManual(a);
		System.out.println("手动深复制~");
		System.out.println(a);
		System.out.println(aCopyByManual);
		add(aCopyByManual);
		System.out.println(a);
		System.out.println(aCopyByManual);
		System.out.println();
		
		// 编译时未知数据结构，利用（反射 + 递归）进行深复制，但是要求深复制的类必须包含午餐构造函数，限定太大。
		
		// 利用Serializeble进行深复制
		A aCopyBySerializeble = deepCopyBySerializeble(a);
		System.out.println("利用Serializeble深复制~");
		System.out.println(a);
		System.out.println(aCopyBySerializeble);
		add(aCopyBySerializeble);
		System.out.println(a);
		System.out.println(aCopyBySerializeble);
	}
	
	public static A deepCopyByManual(A a){
		C cCopy = new C(a.b.c.cInt);
		B bCopy = new B(a.b.bInt, cCopy);
		A aCopy = new A(a.aInt, bCopy);
		return aCopy;
	}
	
	public static A deepCopyByReflection(A a){
		return null;
	}
	
	public static A deepCopyBySerializeble(A a){
		byte[] serialize = SerializationUtils.serialize(a);
		return SerializationUtils.deserialize(serialize);
	}
	
	public static void add(A a){
		a.aInt *= 10;
		a.b.bInt *= 10;
		a.b.c.cInt *= 10;
	}
	
}



class A implements Serializable{
	private static final long serialVersionUID = 2617804898444606796L;
	
	public int aInt;
	public B b;
	
	public A(int aInt, B b) {
		this.aInt = aInt;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "{aInt=" + aInt + ", b=" + b + "}";
	}
}

class B implements Serializable{
	private static final long serialVersionUID = 1681530566578520992L;
	
	public int bInt;
	public C c;
	
	public B(int bInt, C c) {
		this.bInt = bInt;
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "[bInt=" + bInt + ", c=" + c + "]";
	}
}

class C implements Serializable{
	private static final long serialVersionUID = -1997380538263994819L;
	
	public int cInt;
	
	public C(int cInt){
		this.cInt = cInt;
	}
	
	@Override
	public String toString() {
		return "(cInt=" + cInt + ")";
	}
}

