package com.model2.pojo;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7880660554292495826L;
	//学号
	private Integer stuId;
	//姓名
	private String stuName;
	//专业
	private String major;
	//性别
	private String gender;
	//生日
	private String birthday;
	
	public Student() {
		super();
	}
	public Student(Integer stuId, String stuName, String major, String gender, String birthday) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.major = major;
		this.gender = gender;
		this.birthday = birthday;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer id) {
		this.stuId = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", major=" + major + ", gender=" + gender
				+ ", birthday=" + birthday + "]";
	}
	
	
}
