package de.stylextv.gsigns.command.commands;

import de.stylextv.gsigns.command.Command;
import de.stylextv.gsigns.command.argument.ArgumentList;
import de.stylextv.gsigns.command.execute.PluginCommandSender;
import de.stylextv.gsigns.command.execute.result.CommandResult;

public class CancelCommand extends Command {
	
	public CancelCommand() {
		super("cancel", "Cancels the creation process.");
	}
	
	@Override
	public CommandResult execute(PluginCommandSender sender, ArgumentList args) {
		
		
		return CommandResult.SUCCESS;
	}
	
}
