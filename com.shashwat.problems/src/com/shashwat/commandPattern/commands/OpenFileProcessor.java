package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.processors.IFileProcessor;

public class OpenFileProcessor implements Command {
	private IFileProcessor fileProcessor;
	
	public OpenFileProcessor(IFileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.openFile();
	}
}
