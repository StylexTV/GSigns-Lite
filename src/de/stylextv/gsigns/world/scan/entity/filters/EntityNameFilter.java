package de.stylextv.gsigns.world.scan.entity.filters;

import org.bukkit.entity.Entity;

import de.stylextv.gsigns.world.scan.entity.EntityFilter;

public class EntityNameFilter extends EntityFilter {
	
	private String name;
	
	public EntityNameFilter(String name) {
		this.name = name;
	}
	
	@Override
	public boolean test(Entity e) {
		String s = e.getCustomName();
		
		if(s == null) return false;
		
		return s.equals(name);
	}
	
	public String getName() {
		return name;
	}
	
}
