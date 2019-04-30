package com.model2.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserDaoImplTest {

	UserDaoImpl udi = new UserDaoImpl(); 
	@Test
	public void TestfindUser() {
	
		assertTrue(udi.findUser("Ð¡°×", "741811"));
		assertTrue(udi.findUser("ÕÔÈð", "741852"));
		assertTrue(udi.findUser("xiaohong", "741"));
	}
}
