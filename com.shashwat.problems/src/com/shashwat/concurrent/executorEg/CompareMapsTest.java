package com.shashwat.concurrent.executorEg;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CompareMapsTest {
	private final static int THEAD_POOL_SIZE = 4;
	
	public static void main(String[] args) {
		Map<String, Integer> hashTableObjs = new Hashtable<String, Integer>();
		Map<String, Integer> hashMapObjs = new HashMap<String, Integer>();
		Map<String, Integer> concurrenthashMapObjs = new ConcurrentHashMap<String, Integer>();
		
	}
}
