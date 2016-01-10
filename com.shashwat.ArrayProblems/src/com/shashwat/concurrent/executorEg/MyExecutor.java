package com.shashwat.concurrent.executorEg;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {
	@Override
	public void execute(Runnable command) {
		command.run();
	}
}
