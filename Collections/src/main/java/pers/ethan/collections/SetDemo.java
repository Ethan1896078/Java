package pers.ethan.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		Student stu1 = new Student("Ethan", 27, 1); 
		Student stu2 = new Student("Ethan", 27, 1);
		System.out.println(stu1 == stu2);
		System.out.println(stu1.equals(stu2));
		set.add(stu1);
		System.out.println(set.contains(stu2));
		set.add(stu2);
		System.out.println(set.toString());
		System.out.println("------------------------------");
		Set<String> set2 = new HashSet<String>();
		String str1 = new String("Ethan");
		String str2 = new String("Ethan");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		set2.add(str1);
		System.out.println(set2.contains(str2));
		set2.add(str2);
		System.out.println(set2.toString());
	}
}

class Student{
	String name;
	int age;
	int sex;
	
	public Student(String name, int age, int sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public boolean equals(Object arg0) {
		Student stu = (Student) arg0;
		return this.name.equals(stu.name) && this.age == stu.age && this.sex == stu.sex;
	}
	
	
}
