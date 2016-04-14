package com.shashwat.concurrent.producerConsumerProblem;

import java.util.Random;

public class Producer extends Thread {
	private IntegerBuffer buffer;
	
	public Producer(IntegerBuffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random rand = new Random();
		while(true) {
			int number = rand.nextInt();
			buffer.add(number);
			System.out.println("Produced : " + number);
		}
	}
}
