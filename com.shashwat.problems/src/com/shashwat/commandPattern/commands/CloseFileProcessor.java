package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.FileProcessor;

public class CloseFileProcessor implements Command {
	private FileProcessor fileProcessor;
	
	public CloseFileProcessor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.closeFile();
	}
}
