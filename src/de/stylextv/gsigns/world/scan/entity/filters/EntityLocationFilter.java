package de.stylextv.gsigns.world.scan.entity.filters;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import de.stylextv.gsigns.world.scan.entity.EntityFilter;

public class EntityLocationFilter extends EntityFilter {
	
	private Location loc;
	
	public EntityLocationFilter(Location loc) {
		this.loc = loc;
	}
	
	@Override
	public boolean test(Entity e) {
		Location l = e.getLocation();
		
		int x = l.getBlockX();
		int y = l.getBlockY();
		int z = l.getBlockZ();
		
		return x == loc.getBlockX() && y == loc.getBlockY() && z == loc.getBlockZ();
	}
	
	public Location getLocation() {
		return loc;
	}
	
}
