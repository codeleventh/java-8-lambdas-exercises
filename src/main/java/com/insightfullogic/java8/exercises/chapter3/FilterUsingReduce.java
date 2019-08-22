package com.insightfullogic.java8.exercises.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class FilterUsingReduce {

	public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
		return stream.reduce(new ArrayList(), (acc, x) -> {
			if (predicate.test(x)) {
				ArrayList<I> mut = new ArrayList<>(acc);
				mut.add(x);
				return mut;
			}
			return acc;
		}, (ax, ay) -> {
			ArrayList<I> ccat = new ArrayList<>(ax);
			ccat.addAll(ay);
			return ccat;
		});

	}
}
