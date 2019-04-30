package com.model2.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.model2.pojo.Student;

public class StudentDaoImplTest {
	StudentDaoImpl sdi = new StudentDaoImpl();
	Student stu2;
	@Test
	public void TestSave() {
		Student stu = new Student(5, "丽丽", "外包", "女", "1998-5-6");
		assertTrue(sdi.save(stu));
	}
	@Test
	public void TestUpdate() {
		
		Student stu = new Student(4, "刘丽", "外包1", "女", "1997-5-6");
		assertTrue(sdi.update(stu));
	}
	@Test
	public void TestDelete() {
		Student stu = new Student(3, "刘丽", "外包1", "女", "1997-5-6");
		assertTrue(sdi.delete(stu));
	}
	@Test
	public void TestFindById() {
		stu2 = sdi.findById(1);
		System.out.println(stu2.getStuName());
		System.out.println(stu2.getBirthday());
		assertNotNull(stu2);
	}
	@Test
	public void TestFindAll() {
		List<Student> list = sdi.findAll();
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
}
