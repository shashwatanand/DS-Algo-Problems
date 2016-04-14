package com.shashwat.concurrent.producerConsumerProblem;

public class Consumer extends Thread {
	private IntegerBuffer buffer;
	
	public Consumer(IntegerBuffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while(true) {
			int number = buffer.remove();
			System.out.println("Consumed : " + number);
		}
	}
}
