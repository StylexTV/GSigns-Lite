package de.stylextv.gsigns.world.scan.entity.filters;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.stylextv.gsigns.world.scan.entity.EntityFilter;

public class EntityTypeFilter extends EntityFilter {
	
	private EntityType type;
	
	public EntityTypeFilter(EntityType type) {
		this.type = type;
	}
	
	@Override
	public boolean test(Entity e) {
		EntityType t = e.getType();
		
		return t.equals(type);
	}
	
	public EntityType getType() {
		return type;
	}
	
}
