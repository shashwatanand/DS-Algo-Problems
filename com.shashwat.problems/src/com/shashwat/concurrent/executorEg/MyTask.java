package com.shashwat.concurrent.executorEg;

public class MyTask implements Runnable {
	private final int SIZE = 5;
	private String id;

	public MyTask(String id) {
		this.id = id;
	}

	@Override
	public void run() {
		for(int index = 0; index < SIZE; index++) {
			System.out.println(this.id + " : " + index);
		}
	}
}
