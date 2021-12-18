package de.stylextv.gsigns.packet;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.entity.Player;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketListener;

public class PacketManager {
	
	private static ProtocolManager manager;
	
	public static void start() {
		manager = ProtocolLibrary.getProtocolManager();
	}
	
	public static void addListener(PacketListener l) {
		manager.addPacketListener(l);
	}
	
	public static void removeListener(PacketListener l) {
		manager.removePacketListener(l);
	}
	
	public static void sendPacket(Player p, PacketContainer c) {
		try {
			
			manager.sendServerPacket(p, c);
			
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}
	
}
