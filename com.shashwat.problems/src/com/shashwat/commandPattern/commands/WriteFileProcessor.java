package com.shashwat.commandPattern.commands;

import com.shashwat.commandPattern.FileProcessor;

public class WriteFileProcessor implements Command {
	private FileProcessor fileProcessor;
	
	public WriteFileProcessor(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}
	
	@Override
	public void exexute() {
		this.fileProcessor.writeFile();
	}
}
