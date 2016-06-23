package com.netflix.nebula.lint.rule.java;

import com.google.common.base.Joiner;

public class Main {
	public static void main(String[] args) {
		System.out.println(new Main().sayHello("Gradle", "Netflix"));
	}

	String sayHello(String... to) {
		Joiner joiner = Joiner.on(" and ");
		return "Hello " + joiner.join(to) + "!";
	}
}
