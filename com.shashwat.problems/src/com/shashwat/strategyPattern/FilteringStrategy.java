package com.shashwat.strategyPattern;

public interface FilteringStrategy {
	boolean isFilterable(Message message);
}
