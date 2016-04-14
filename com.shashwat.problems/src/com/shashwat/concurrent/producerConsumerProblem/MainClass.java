package com.shashwat.concurrent.producerConsumerProblem;

public class MainClass {
	public static void main(String[] args) {
		IntegerBuffer buffer = new IntegerBuffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		p.start();
		c.start();
	}
}
