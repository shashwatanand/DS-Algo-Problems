package com.shashwat.concurrent.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache<Key, Value> {
	private final int MAX_SIZE;
	private ConcurrentHashMap<Key, Value> map;
	private ConcurrentLinkedDeque<Key> queue;
	
	public LRUCache(final int maxSize) {
		this.MAX_SIZE = maxSize;
		this.map = new ConcurrentHashMap<Key, Value>(this.MAX_SIZE);
		this.queue = new ConcurrentLinkedDeque<Key>();		
	}
	
	public Value get(Key key) {
		return this.map.get(key);
	}
	
	public void  put(final Key key, final Value value) {
		if (this.map.containsKey(key)) {
			this.queue.remove(key);
		}
		while (this.queue.size() >= this.MAX_SIZE) {
			Key oldKey = this.queue.poll();
			if (null != oldKey) {
				this.map.remove(oldKey);
			}
		}
		this.queue.add(key);
		this.map.put(key, value);
	}
}
