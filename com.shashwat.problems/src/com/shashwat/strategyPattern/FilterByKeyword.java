package com.shashwat.strategyPattern;

public class FilterByKeyword implements FilteringStrategy {
	private String keyword;

	public FilterByKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public boolean isFilterable(Message message) {
		return message.getContent() != null && 
				message.getContent().contains(this.keyword);
	}
	
	@Override
	public String toString() {
		return "Filtering by keyword: " + this.keyword;
	}
}
