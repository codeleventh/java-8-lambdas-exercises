package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question1 {

	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (x, y) -> x + y);
	}

	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream()
				.flatMap(x -> Stream.of(x.getName(), x.getNationality()))
        .collect(Collectors.toList());
	}

	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
		return input.stream().filter(a -> a.getTracks().count() <= 3).collect(Collectors.toList());
	}
}
