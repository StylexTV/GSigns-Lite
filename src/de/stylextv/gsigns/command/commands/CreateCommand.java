package de.stylextv.gsigns.command.commands;

import de.stylextv.gsigns.command.Command;
import de.stylextv.gsigns.command.argument.ArgumentList;
import de.stylextv.gsigns.command.execute.PluginCommandSender;
import de.stylextv.gsigns.command.execute.result.CommandResult;

public class CreateCommand extends Command {
	
	private static String[] USAGES = new String[] {
			"",
			""
	};
	
	public CreateCommand() {
		super("create", "Creates a sign from a given image or GIF.");
	}
	
	@Override
	public CommandResult execute(PluginCommandSender sender, ArgumentList args) {
		
		
		return CommandResult.SUCCESS;
	}
	
	@Override
	public String[] getUsages() {
		return USAGES;
	}
	
}
