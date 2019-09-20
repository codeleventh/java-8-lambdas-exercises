package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private Map<Integer, Long> numbers = new HashMap();

	public Fibonacci() {
		numbers.put(0, 0l);
		numbers.put(1, 1l);
		numbers.put(2, 1l);
		numbers.put(3, 2l);
		numbers.put(4, 3l);
		numbers.put(5, 5l);
		numbers.put(6, 8l);
	}

	public long fibonacci(int x) {
		return numbers.computeIfAbsent(x, n -> fibonacci(n - 1) + fibonacci(n - 2));
	}

}
