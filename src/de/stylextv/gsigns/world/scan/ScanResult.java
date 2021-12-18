package de.stylextv.gsigns.world.scan;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ScanResult<T> extends ArrayList<T> {
	
	public ScanResult(List<T> matches) {
		addAll(matches);
	}
	
	public T first() {
		return get(0);
	}
	
}
