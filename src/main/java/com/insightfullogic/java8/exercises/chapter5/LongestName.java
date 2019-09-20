package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class LongestName {

	private static Comparator<Artist> artistComparator =
			Comparator.comparingInt(s -> s.getName().length());

	public static Artist byReduce(List<Artist> artists) {
      return artists.stream().reduce(BinaryOperator.maxBy(artistComparator)).get();
	}

	public static Artist byCollecting(List<Artist> artists) {
		return artists.stream()
				.collect(Collectors.maxBy(artistComparator)).get();
	}

}
