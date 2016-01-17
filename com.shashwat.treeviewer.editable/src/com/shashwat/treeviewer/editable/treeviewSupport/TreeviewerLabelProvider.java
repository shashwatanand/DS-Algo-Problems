package com.shashwat.treeviewer.editable.treeviewSupport;

import org.eclipse.jface.viewers.LabelProvider;

public class TreeviewerLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		return element.toString();
	}
}
