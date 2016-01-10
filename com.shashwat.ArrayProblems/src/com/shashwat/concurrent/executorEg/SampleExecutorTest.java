package com.shashwat.concurrent.executorEg;

import java.util.concurrent.Executor;

public class SampleExecutorTest {
	public static void main(String[] args) {
		MyTask task1 = new MyTask("First");
		MyTask task2 = new MyTask("Second");
		
		Executor executor =  new SampleExecutor();
		executor.execute(task1);
		executor.execute(task2);
	}
}
