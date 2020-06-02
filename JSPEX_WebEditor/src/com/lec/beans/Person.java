package com.lec.beans;

// Person(bean 객체)
public class Person {
	private String name;
	private int age;
	private int id;
	private String gender;
	
	public Person() {  // 기본 생성자 없다면 --->  jsp 파일에서 자바빈 객체 생성이 안 된다. 
		super();
	}

	public Person(String name, int age, int id, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	// 우선순위가 얘부터 호풀하려고 한다. 
	public void setname(String name) {
		this.name = name;
	}
	

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

} // end class

