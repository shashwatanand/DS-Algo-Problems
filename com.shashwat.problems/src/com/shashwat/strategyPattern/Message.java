package com.shashwat.strategyPattern;

public class Message {
	private MessageType type;
	private int size;
	private String content;

	/**
	 * @param type
	 * @param size
	 * @param content
	 */
	public Message(MessageType type, int size, String content) {
		super();
		this.type = type;
		this.size = size;
		this.content = content;
	}

	/**
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [type=" + type + ", size=" + size + ", content=" + content + "]";
	}
}
