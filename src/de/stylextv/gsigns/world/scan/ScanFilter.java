package de.stylextv.gsigns.world.scan;

import java.util.function.Predicate;

public class ScanFilter<T> implements Predicate<T> {
	
	private Predicate<T> predicate;
	
	public ScanFilter() {}
	
	public ScanFilter(Predicate<T> predicate) {
		this.predicate = predicate;
	}
	
	@Override
	public boolean test(T t) {
		return predicate.test(t);
	}
	
}
