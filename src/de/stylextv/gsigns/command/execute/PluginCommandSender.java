package de.stylextv.gsigns.command.execute;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommandSender {
	
	private CommandSender sender;
	
	public PluginCommandSender(CommandSender sender) {
		this.sender = sender;
	}
	
	public boolean isPlayer() {
		return sender instanceof Player;
	}
	
	public Player getPlayer() {
		return (Player) sender;
	}
	
	public CommandSender getSender() {
		return sender;
	}
	
}
