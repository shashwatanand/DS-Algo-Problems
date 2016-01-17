package com.shashwat.treeviewer.editable.model;

public class TreeData {
	private String data;
	
	public TreeData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		//return "TreeData [data=" + data + "]";
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}
