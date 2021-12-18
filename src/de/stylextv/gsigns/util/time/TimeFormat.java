package de.stylextv.gsigns.util.time;

import java.util.Date;

public class TimeFormat {
	
	public static String formatDate(long time) {
		return new Date(time).toString();
	}
	
	public static String formatDuration(long time) {
		return formatDuration(time, TimeUnit.MILLI_SECONDS);
	}
	
	public static String formatDuration(long amount, TimeUnit u) {
		String s = null;
		
		long time = TimeUnit.NANO_SECONDS.convert(amount, u);
		
		while(time != 0 || s == null) {
			
			TimeUnit unit = TimeUnit.getClosestUnit(time, TimeUnit.NANO_SECONDS);
			
			long l = unit.convert(time, TimeUnit.NANO_SECONDS);
			
			time -= TimeUnit.NANO_SECONDS.convert(l, unit);
			
			String s2 = l + " " + unit.getName(l);
			
			if(s != null) return s + " and " + s2;
			
			s = s2;
		}
		
		return s;
	}
	
}
