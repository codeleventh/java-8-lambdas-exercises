package com.insightfullogic.java8.exercises.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class MapUsingReduce {

	public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {

		return stream.reduce(new ArrayList<O>(), (acc, x) -> {
			ArrayList<O> mut = new ArrayList<>(acc);
			mut.add(mapper.apply(x));
			return mut;
		}, (ax, ay) -> {
			ArrayList<O> ccat = new ArrayList<>(ax);
			ccat.addAll(ay);
			return ccat;
		});

	}


}
