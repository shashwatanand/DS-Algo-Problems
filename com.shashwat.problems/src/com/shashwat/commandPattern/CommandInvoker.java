package com.shashwat.commandPattern;

import com.shashwat.commandPattern.commands.Command;

public class CommandInvoker {
	private Command command;
	
	public CommandInvoker(Command command) {
		this.command = command;
	}
	
	public void execute() {
		this.command.exexute();
	}
}
