package com.shashwat.strategyPattern;

public class FilterBySize implements FilteringStrategy {
	private int maxSize;

	public FilterBySize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public boolean isFilterable(Message message) {
		return this.maxSize < message.getSize();
	}
	
	@Override
	public String toString() {
		return "Filtering by maxSize: " + this.maxSize;
	}
}
