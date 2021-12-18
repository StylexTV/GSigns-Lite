package de.stylextv.gsigns.util.time;

public class TimeUnit {
	
	private static final TimeUnit[] UNITS = new TimeUnit[9];
	
	public static final TimeUnit NANO_SECONDS = new TimeUnit("ns", 1);
	
	public static final TimeUnit MILLI_SECONDS = new TimeUnit("ms", 1000000);
	
	public static final TimeUnit SECONDS = new TimeUnit("second", "seconds", 1000000000);
	
	public static final TimeUnit MINUTES = new TimeUnit("minute", "minutes", 60000000000l);
	
	public static final TimeUnit HOURS = new TimeUnit("hour", "hours", 3600000000000l);
	
	public static final TimeUnit DAYS = new TimeUnit("day", "days", 86400000000000l);
	
	public static final TimeUnit WEEKS = new TimeUnit("week", "weeks", 604800000000000l);
	
	public static final TimeUnit MONTHS = new TimeUnit("month", "months", 2628002880000000l);
	
	public static final TimeUnit YEARS = new TimeUnit("year", "years", 31556952000000000l);
	
	private static int pointer;
	
	private String singular;
	private String plural;
	
	private long duration;
	
	public TimeUnit(String name, long duration) {
		this(name, name, duration);
	}
	
	public TimeUnit(String singular, String plural, long duration) {
		this.singular = singular;
		this.plural = plural;
		
		this.duration = duration;
		
		registerUnit(this);
	}
	
	public long convert(long time) {
		return convert(time, TimeUnit.MILLI_SECONDS);
	}
	
	public long convert(long amount, TimeUnit u) {
		long nanos = amount * u.getDuration();
		
		return nanos / duration;
	}
	
	public String getName(long amount) {
		return amount == 1 ? singular : plural;
	}
	
	public String getSingular() {
		return singular;
	}
	
	public String getPlural() {
		return plural;
	}
	
	public long getDuration() {
		return duration;
	}
	
	private static void registerUnit(TimeUnit u) {
		UNITS[pointer] = u;
		
		pointer++;
	}
	
	public static TimeUnit getClosestUnit(long time) {
		return getClosestUnit(time, TimeUnit.MILLI_SECONDS);
	}
	
	public static TimeUnit getClosestUnit(long amount, TimeUnit u) {
		long time = TimeUnit.NANO_SECONDS.convert(amount, u);
		
		for(int i = UNITS.length - 1; i > 0; i--) {
			
			TimeUnit unit = UNITS[i];
			
			if(time > unit.getDuration()) return unit;
		}
		
		return NANO_SECONDS;
	}
	
	public static TimeUnit[] getUnits() {
		return UNITS;
	}
	
}
