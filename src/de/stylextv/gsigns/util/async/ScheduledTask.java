package de.stylextv.gsigns.util.async;

import de.stylextv.gsigns.util.ExceptionUtil;

public class ScheduledTask implements Runnable {
	
	private static final long WAIT_TIME = 5;
	
	private static final long INVALID_DELAY = -1;
	
	private Runnable runnable;
	
	private long delay;
	
	private long initialDelay;
	
	private Thread thread;
	
	private boolean killed;
	
	private boolean active;
	
	public ScheduledTask(Runnable r, long initialDelay) {
		this(r, initialDelay, INVALID_DELAY);
	}
	
	public ScheduledTask(Runnable r, long initialDelay, long delay) {
		this.runnable = r;
		this.delay = delay;
		this.initialDelay = initialDelay;
		
		AsyncUtil.addTask(this);
	}
	
	public void kill() {
		killed = true;
		
		if(thread == null) return;
		
		thread.interrupt();
		
		waitFor();
		
		AsyncUtil.removeTask(this);
	}
	
	public void waitFor() {
		while(isActive()) {
			
			AsyncUtil.sleep(WAIT_TIME);
		}
	}
	
	@Override
	public void run() {
		if(isKilled()) return;
		
		thread = Thread.currentThread();
		
		active = true;
		
		AsyncUtil.sleep(initialDelay);
		
		while(!isKilled()) {
			
			ExceptionUtil.catchEverything(runnable);
			
			if(delay == INVALID_DELAY) break;
			
			AsyncUtil.sleep(delay);
		}
		
		active = false;
	}
	
	public Runnable getRunnable() {
		return runnable;
	}
	
	public long getDelay() {
		return delay;
	}
	
	public long getInitialDelay() {
		return initialDelay;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public boolean isKilled() {
		return killed;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
