package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.FileProcessor;

public class OpenFileProcessor implements Command {
	private FileProcessor fileProcessor;
	
	public OpenFileProcessor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.openFile();
	}
}
