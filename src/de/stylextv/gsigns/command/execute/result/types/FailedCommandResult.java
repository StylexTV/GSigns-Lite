package de.stylextv.gsigns.command.execute.result.types;

import de.stylextv.gsigns.command.execute.result.CommandResult;

public class FailedCommandResult extends CommandResult {
	
	public FailedCommandResult(String message) {
		super("§c" + message);
	}
	
}
