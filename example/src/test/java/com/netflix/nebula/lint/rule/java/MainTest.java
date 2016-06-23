package com.netflix.nebula.lint.rule.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
	@Test
	public void helloMessage() {
		assertEquals("Hello Jon!", new Main().sayHello("Jon"));
	}
}
