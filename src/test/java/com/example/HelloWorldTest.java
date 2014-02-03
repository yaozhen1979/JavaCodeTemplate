package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
	
	
    Greeter greeter;
	
	@Before
	public void setUp() throws Exception {
		greeter = new Greeter();
	}

	@After
	public void tearDown() throws Exception {
		greeter = null;
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
		assertEquals("Hello world!", greeter.sayHello());
	}

}
