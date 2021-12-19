package de.stylextv.gsigns.command.commands;

import de.stylextv.gsigns.Constants;
import de.stylextv.gsigns.command.Command;
import de.stylextv.gsigns.command.argument.ArgumentList;
import de.stylextv.gsigns.command.execute.PluginCommandSender;
import de.stylextv.gsigns.command.execute.result.CommandResult;
import de.stylextv.gsigns.util.chat.ChatUtil;

public class VersionCommand extends Command {
	
	public VersionCommand() {
		super("version", "Shows the installed version of GSigns.", "ver", "v");
	}
	
	@Override
	public CommandResult execute(PluginCommandSender sender, ArgumentList args) {
		String s = Constants.COLORED_NAME + " " + Constants.VERSION + " §7by §e" + Constants.AUTHOR;
		
		ChatUtil.sendMessage(sender, "Installed: " + s);
		
		return CommandResult.SUCCESS;
	}
	
}
