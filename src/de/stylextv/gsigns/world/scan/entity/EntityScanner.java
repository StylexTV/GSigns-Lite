package de.stylextv.gsigns.world.scan.entity;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.bukkit.World;
import org.bukkit.entity.Entity;

public class EntityScanner {
	
	public static EntityScanResult scanWorld(World w) {
		return scanWorld(w, EntityFilter.ALL);
	}
	
	public static EntityScanResult scanWorld(World w, Predicate<Entity> p) {
		List<Entity> entities = w.getEntities();
		
		Stream<Entity> stream = entities.stream();
		
		stream = stream.filter(p);
		
		entities = stream.toList();
		
		return new EntityScanResult(entities);
	}
	
}
