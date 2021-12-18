package de.stylextv.gsigns.world.sign.frame;

import java.util.function.Predicate;

import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;

import de.stylextv.gsigns.world.scan.entity.EntityFilter;
import de.stylextv.gsigns.world.scan.entity.EntityScanResult;
import de.stylextv.gsigns.world.scan.entity.EntityScanner;

public class VirtualFrame {
	
	private static final EntityFilter ITEM_FRAME_FILTER = EntityFilter.ofType(EntityType.ITEM_FRAME);
	
	private Location loc;
	
	private BlockFace facing;
	
	private Rotation rotation;
	
	private ItemFrame frame;
	
	public VirtualFrame(Location loc, BlockFace facing, Rotation r) {
		this.loc = loc;
		this.facing = facing;
		this.rotation = r;
		
		create();
	}
	
	public void create() {
		World w = getWorld();
		
		Predicate<Entity> p = ITEM_FRAME_FILTER.and(EntityFilter.atLocation(loc));
		
		EntityScanResult r = EntityScanner.scanWorld(w, p);
		
		if(!r.isEmpty()) {
			
			frame = (ItemFrame) r.first();
			
			return;
		}
		
		frame = (ItemFrame) w.spawnEntity(loc, EntityType.ITEM_FRAME);
		
		frame.setFacingDirection(facing);
		frame.setRotation(rotation);
	}
	
	public void destroy() {
		frame.remove();
	}
	
	public void show() {
		frame.setItem(null, false);
	}
	
	public World getWorld() {
		return loc.getWorld();
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public BlockFace getFacingDirection() {
		return facing;
	}
	
	public Rotation getRotation() {
		return rotation;
	}
	
	public ItemFrame getFrame() {
		return frame;
	}
	
}
