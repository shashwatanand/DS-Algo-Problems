package com.shashwat.strategyPattern;

public class FilterByType implements FilteringStrategy {
	private MessageType type;

	public FilterByType(MessageType type) {
		this.type = type;
	}

	@Override
	public boolean isFilterable(Message message) {
		return this.type == message.getType();
	}
	
	@Override
	public String toString() {
		return "Filtering by type: " + type;
	}
}
