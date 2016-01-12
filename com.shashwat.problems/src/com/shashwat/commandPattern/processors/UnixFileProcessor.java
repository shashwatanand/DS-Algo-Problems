package com.shashwat.commandPattern.processors;

public class UnixFileProcessor implements FileProcessor {
	@Override
	public void openFile() {
		System.out.println("Opening file in UNIX OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in UNIX OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in UNIX OS");
	}

}
