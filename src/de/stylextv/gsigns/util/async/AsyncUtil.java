package de.stylextv.gsigns.util.async;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncUtil {
	
	private static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
	
	private static CopyOnWriteArrayList<ScheduledTask> tasks = new CopyOnWriteArrayList<>();
	
	public static ScheduledTask loopAsync(Runnable r, long delay) {
		return loopAsync(r, 0, delay);
	}
	
	public static ScheduledTask loopAsync(Runnable r, long initialDelay, long delay) {
		ScheduledTask t = new ScheduledTask(r, initialDelay, delay);
		
		return runTask(t);
	}
	
	public static ScheduledTask runLaterAsync(Runnable r, long delay) {
		ScheduledTask t = new ScheduledTask(r, delay);
		
		return runTask(t);
	}
	
	public static ScheduledTask runAsync(Runnable r) {
		return runLaterAsync(r, 0);
	}
	
	public static void addTask(ScheduledTask t) {
		tasks.add(t);
	}
	
	public static void removeTask(ScheduledTask t) {
		tasks.remove(t);
	}
	
	public static void shutdown() {
		for(ScheduledTask t : tasks) {
			
			t.kill();
		}
	}
	
	private static ScheduledTask runTask(ScheduledTask t) {
		THREAD_POOL.execute(t);
		
		return t;
	}
	
	public static void sleep(long delay) {
		sleep(delay, TimeUnit.MILLISECONDS);
	}
	
	public static void sleep(long delay, TimeUnit u) {
		if(delay <= 0) return;
		
		long l = TimeUnit.NANOSECONDS.convert(delay, u);
		
		try {
			
			long millis = l / 1000000;
			long nanos = l % 1000000;
			
			Thread.sleep(millis, (int) nanos);
			
		} catch (InterruptedException ex) {}
	}
	
}
