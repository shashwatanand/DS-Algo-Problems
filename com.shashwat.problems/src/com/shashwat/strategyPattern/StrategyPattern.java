package com.shashwat.strategyPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StrategyPattern {
	public static void main(String[] args) {
		List<Message> messages = new ArrayList<>();
		messages.add(new Message(MessageType.TEXT, 100, "Test Message 1"));
		messages.add(new Message(MessageType.XML, 200, "<tag>Test Message 2</tag>"));
		messages.add(new Message(MessageType.TEXT, 500, "Test Message 3"));
		messages.add(new Message(MessageType.TEXT, 100, "Wrong, Test Message 4"));
		
		messages = filter(messages, new FilterByType(MessageType.XML));
		messages = filter(messages, new FilterByKeyword("Wrong"));
		messages = filter(messages, new FilterBySize(200));
	}
	
	public static List<Message> filter(List<Message> messageList, 
			FilteringStrategy strategy) {
		Iterator<Message> itr = messageList.iterator();
		while(itr.hasNext()) {
			Message message = itr.next();
			if (strategy.isFilterable(message)) {
				System.out.println(strategy.toString() + message);
				itr.remove();
			}
		}
		return messageList;
	}
}
