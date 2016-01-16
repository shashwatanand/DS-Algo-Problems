package com.shashwat.commandPattern;

import com.shashwat.commandPattern.commands.CloseFileProcessor;
import com.shashwat.commandPattern.commands.OpenFileProcessor;
import com.shashwat.commandPattern.commands.WriteFileProcessor;
import com.shashwat.commandPattern.processors.IFileProcessor;

public class CommandTest {
	public static void main(String[] args) {
		IFileProcessor iFileProcessor = Util.getSystemFileReciver();
		if (iFileProcessor != null) {
			OpenFileProcessor open = new OpenFileProcessor(iFileProcessor);
			CommandInvoker invoker = new CommandInvoker(open);
			invoker.execute();
			
			WriteFileProcessor write = new WriteFileProcessor(iFileProcessor);
			invoker = new CommandInvoker(write);
			invoker.execute();
			
			CloseFileProcessor close = new CloseFileProcessor(iFileProcessor);
			invoker = new CommandInvoker(close);
			invoker.execute();
		}
	}
}
