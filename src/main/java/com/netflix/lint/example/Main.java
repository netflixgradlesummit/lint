package com.netflix.lint.example;

import com.google.common.base.Joiner;

public class Main {
	public static void main(String[] args) {
		Joiner joiner = Joiner.on(" and ");
		System.out.println("Hello " + joiner.join("Gradle", "Netflix") + "!");
	}
}
