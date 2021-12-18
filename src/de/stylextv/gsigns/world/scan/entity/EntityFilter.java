package de.stylextv.gsigns.world.scan.entity;

import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.stylextv.gsigns.world.scan.ScanFilter;
import de.stylextv.gsigns.world.scan.entity.filters.EntityLocationFilter;
import de.stylextv.gsigns.world.scan.entity.filters.EntityNameFilter;
import de.stylextv.gsigns.world.scan.entity.filters.EntityTypeFilter;

public class EntityFilter extends ScanFilter<Entity> {
	
	// TODO check if entity is of type 'EntityLiving' and has health left
	public static final EntityFilter ALIVE = new EntityFilter((e) -> {
		return !e.isDead();
	});
	
	public static final EntityFilter ALL = new EntityFilter((e) -> {
		return true;
	});
	
	public EntityFilter() {}
	
	public EntityFilter(Predicate<Entity> predicate) {
		super(predicate);
	}
	
	public static EntityFilter atLocation(Location loc) {
		return new EntityLocationFilter(loc);
	}
	
	public static EntityFilter withName(String name) {
		return new EntityNameFilter(name);
	}
	
	public static EntityFilter ofType(EntityType type) {
		return new EntityTypeFilter(type);
	}
	
}
