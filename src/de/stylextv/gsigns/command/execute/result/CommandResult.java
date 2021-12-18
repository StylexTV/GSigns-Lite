package de.stylextv.gsigns.command.execute.result;

import de.stylextv.gsigns.command.execute.result.types.FailedCommandResult;

public class CommandResult {
	
	public static final CommandResult SUCCESS = new CommandResult();
	
	public static final CommandResult COMMAND_NOT_FOUND = new FailedCommandResult("Couldn't find command!");
	
	public static final CommandResult MISSING_PERMISSIONS = new FailedCommandResult("You lack the permission for this command!");
	
	public static final CommandResult NOT_A_PLAYER = new FailedCommandResult("This command is for players only!");
	
	private String message;
	
	public CommandResult() {}
	
	public CommandResult(String message) {
		this.message = message;
	}
	
	public boolean hasMessage() {
		return message != null;
	}
	
	public String getMessage() {
		return message;
	}
	
}
