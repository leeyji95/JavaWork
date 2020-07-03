package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee") // 전체적인 <employee>
public class EmployeeVO {
	
	@XmlAttribute
	private Integer id;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private int age;
	
	@XmlElement
	private int [] score;
	private double point;
	
	
	
	public EmployeeVO() {
		super();
	}
	public EmployeeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	protected Integer getId() {
		return id;
	}
	protected void setId(Integer id) {
		this.id = id;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	protected int[] getScore() {
		return score;
	}
	protected void setScore(int[] score) {
		this.score = score;
	}
	protected double getPoint() {
		return point;
	}
	protected void setPoint(double point) {
		this.point = point;
	}
	
	
	
}
