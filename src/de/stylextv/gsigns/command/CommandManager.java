package de.stylextv.gsigns.command;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

import de.stylextv.gsigns.command.argument.ArgumentList;
import de.stylextv.gsigns.command.commands.CancelCommand;
import de.stylextv.gsigns.command.commands.CreateCommand;
import de.stylextv.gsigns.command.commands.HelpCommand;
import de.stylextv.gsigns.command.commands.VersionCommand;
import de.stylextv.gsigns.command.execute.PluginCommandExecutor;
import de.stylextv.gsigns.command.execute.PluginCommandSender;
import de.stylextv.gsigns.command.execute.result.CommandResult;

public class CommandManager {
	
	private static final Command[] COMMANDS = new Command[] {
			new CreateCommand(),
			new CancelCommand(),
			new HelpCommand(),
			new VersionCommand()
	};
	
	private static final String[] PLUGIN_COMMANDS = new String[] {
			"gsigns", "gs"
	};
	
	public static CommandResult onPluginCommand(PluginCommandSender sender, String[] args) {
		if(args.length == 0) return CommandResult.COMMAND_NOT_FOUND;
		
		String name = args[0];
		
		Command c = getCommand(name);
		
		if(c == null) return CommandResult.COMMAND_NOT_FOUND;
		
		args = Arrays.copyOfRange(args, 1, args.length);
		
		ArgumentList list = new ArgumentList(args);
		
		return c.execute(sender, list);
	}
	
	public static void registerPluginCommands() {
		for(String s : PLUGIN_COMMANDS) {
			
			registerPluginCommand(s);
		}
	}
	
	private static void registerPluginCommand(String name) {
		PluginCommand c = Bukkit.getPluginCommand(name);
		
		c.setExecutor(new PluginCommandExecutor());
	}
	
	public static Command getCommand(String name) {
		for(Command c : COMMANDS) {
			if(c.nameEquals(name)) return c;
		}
		
		return null;
	}
	
	public static Command[] getCommands() {
		return COMMANDS;
	}
	
}
