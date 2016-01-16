package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.processors.IFileProcessor;

public class WriteFileProcessor implements Command {
	private IFileProcessor fileProcessor;
	
	public WriteFileProcessor(IFileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.writeFile();
	}
}
