package de.stylextv.gsigns.world.scan.entity;

import java.util.List;

import org.bukkit.entity.Entity;

import de.stylextv.gsigns.world.scan.ScanResult;

@SuppressWarnings("serial")
public class EntityScanResult extends ScanResult<Entity> {
	
	public EntityScanResult(List<Entity> matches) {
		super(matches);
	}
	
}
