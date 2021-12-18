package de.stylextv.gsigns.command.execute;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.stylextv.gsigns.command.CommandManager;
import de.stylextv.gsigns.command.execute.result.CommandResult;
import de.stylextv.gsigns.util.chat.ChatUtil;

public class PluginCommandExecutor implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command c, String name, String[] args) {
		PluginCommandSender s = new PluginCommandSender(sender);
		
		CommandResult result = CommandManager.onPluginCommand(s, args);
		
		if(result.hasMessage()) {
			
			String message = result.getMessage();
			
			ChatUtil.sendMessage(sender, message);
		}
		
		return true;
	}
	
}
