package com.shashwat.commandPattern;

import com.shashwat.commandPattern.processors.IFileProcessor;
import com.shashwat.commandPattern.processors.UnixFileProcessor;
import com.shashwat.commandPattern.processors.WindowFileProcessor;

public class Util {
	public static IFileProcessor getSystemFileReciver() {
		String osName = System.getProperty("os.name");
		System.out.println("OS is " + osName);
		if (osName.contains("Windows")) {
			return new WindowFileProcessor();
		} else if (osName.contains("UNIX")) {
			return new UnixFileProcessor();
		}
		return null;
	}
}
