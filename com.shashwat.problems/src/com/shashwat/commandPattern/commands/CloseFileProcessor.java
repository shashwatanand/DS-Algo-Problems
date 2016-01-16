package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.processors.IFileProcessor;

public class CloseFileProcessor implements Command {
	private IFileProcessor fileProcessor;
	
	public CloseFileProcessor(IFileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.closeFile();
	}
}
