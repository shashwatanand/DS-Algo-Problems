package com.shashwat.concurrent.executorEg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompareMapsTest {
	private final static int THEAD_POOL_SIZE = 4;
	
	public static void main(String[] args) throws InterruptedException {
		Map<String, Integer> hashTableObjs = new Hashtable<String, Integer>();
		Map<String, Integer> hashMapObjs = new HashMap<String, Integer>();
		Map<String, Integer> concurrenthashMapObjs = new ConcurrentHashMap<String, Integer>();
		
		performTest(hashTableObjs);
		performTest(hashMapObjs);
		performTest(Collections.synchronizedMap(hashMapObjs));
		performTest(concurrenthashMapObjs);
	}

	private static void performTest(Map<String, Integer> mapObjs) throws InterruptedException {
		System.out.println("Performing test for : " + mapObjs.getClass());
		for(int index = 0; index < 10; index++) {
			long startTime = System.nanoTime();
			ExecutorService service = Executors.newFixedThreadPool(THEAD_POOL_SIZE);
			for (int i = 0; i < THEAD_POOL_SIZE; i++) {
				service.execute(new Runnable() {
					
					@Override
					public void run() {
						for (int i = 0; i < 60000; i++) {
							Integer randomNumber = (int)Math.floor(Math.random() * 250000);
							mapObjs.put(String.valueOf(randomNumber), randomNumber);
						}
					}
				});
			}
			service.shutdown();
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
			long endTime = System.nanoTime();
			long totalTime = (endTime - startTime) / 1000000L;
			System.out.println("Records add in " + totalTime + " ms");
		}
	}
}
