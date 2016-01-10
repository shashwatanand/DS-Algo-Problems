package com.shashwat.concurrent.executorEg;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SampleExecutor implements Executor {
	private final Queue<Runnable> queue;
	private Runnable task;
	public SampleExecutor() {
		this.queue = new ArrayDeque<Runnable>();
	}
	
	private synchronized void next() {
		if ((this.task = this.queue.poll()) != null) {
			new Thread(this.task).start();
		}
	}

	@Override
	public synchronized void execute(final Runnable command) {
		this.queue.offer(new Runnable() {
			@Override
			public void run() {
				try {
					command.run();
				} finally {
					next();
				}
			}
		});
		if (this.task == null) {
			next();
		}
	}
}
