package com.shashwat.concurrent.producerConsumerProblem;

public class IntegerBuffer {
	private int index;
	private int[] buffer;
	private final int SIZE = 2;

	public IntegerBuffer() {
		this.buffer = new int[SIZE];
	}

	public synchronized void add(int number) {
		while (index == buffer.length - 1) {
			try {
				wait();
				System.out.println("IntegerBuffer.add() waiting");
			} catch (InterruptedException e) {
			}
		}
		buffer[index++] = number;
		notifyAll();
	}

	public synchronized int remove() {
		while (index == 0) {
			try {
				wait();
				System.out.println("IntegerBuffer.remove() waiting");
			} catch (InterruptedException e) {
			}
		}
		int returnVal = buffer[--index];
		notifyAll();
		return returnVal;
	}
}
