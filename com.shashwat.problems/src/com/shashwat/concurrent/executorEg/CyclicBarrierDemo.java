package com.shashwat.concurrent.executorEg;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static class Task implements Runnable {
		private CyclicBarrier barrier;
		
		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " is crossed the barrier");
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} catch(BrokenBarrierException bbe) {
				bbe.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello world");
			}
		});
		
		Thread t1 = new Thread(new Task(cyclicBarrier), "Thread 1");
		Thread t2 = new Thread(new Task(cyclicBarrier), "Thread 2");
		Thread t3 = new Thread(new Task(cyclicBarrier), "Thread 3");
		Thread t4 = new Thread(new Task(cyclicBarrier), "Thread 4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
