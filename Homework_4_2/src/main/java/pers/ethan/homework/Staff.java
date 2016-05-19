package pers.ethan.homework;

public abstract class Staff {
	/** 姓名 */
	private String name;
	/** 年龄 */
	private int age;
	/** 月薪 */
	private double salary; 
	/** 入职时间 */
	private String joindedDate;
	
	/**
	 * desc:工作
	 * <p>创建人：huangzhe , 2016年5月19日下午5:32:00</p>
	 */
	public abstract void work();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJoindedDate() {
		return joindedDate;
	}

	public void setJoindedDate(String joindedDate) {
		this.joindedDate = joindedDate;
	}
}
