package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

	private final static Set<Characteristics> characteristics = new HashSet<>();
	static {
		characteristics.add(Characteristics.IDENTITY_FINISH);
	}

	private final Function<? super T, ? extends K> classifier;

	public GroupingBy(Function<? super T, ? extends K> classifier) {
		this.classifier = classifier;
	}

	@Override
	public Supplier<Map<K, List<T>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<K, List<T>>, T> accumulator() {
		return (map, el) -> {
			K val = classifier.apply(el);
			List<T> l = map.get(val);
			if (l == null) {
				l = new ArrayList<>();
				map.put(val, l);
			}
			l.add(el);
		};
	}

	@Override
	public BinaryOperator<Map<K, List<T>>> combiner() {
		return (l, r) -> {
			r.forEach((key, val) -> {
				l.merge(key, val, (left, right) -> {
					left.addAll(right);
					return left;
				});
			});
			return l;
		};
	}

	@Override
	public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
		return x -> x;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return characteristics;
	}

}
