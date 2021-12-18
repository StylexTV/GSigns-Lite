package de.stylextv.gsigns.util.chat;

import org.bukkit.command.CommandSender;

import de.stylextv.gsigns.Constants;
import de.stylextv.gsigns.command.execute.PluginCommandSender;

public class ChatUtil {
	
	private static final String PREFIX = Constants.NAME_COLOR + "§lGS §8| §7";
	
	public static void sendMessage(PluginCommandSender sender, String s, Object... objects) {
		sendMessage(sender.getSender(), s, objects);
	}
	
	public static void sendMessage(CommandSender sender, String s, Object... objects) {
		s = PREFIX + String.format(s, objects);
		
		sender.sendMessage(s);
	}
	
}
