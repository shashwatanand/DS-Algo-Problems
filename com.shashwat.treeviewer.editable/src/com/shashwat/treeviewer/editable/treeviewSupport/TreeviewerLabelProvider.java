package com.shashwat.treeviewer.editable.treeviewSupport;

import org.eclipse.jface.viewers.ColumnLabelProvider;

public class TreeviewerLabelProvider extends ColumnLabelProvider {
	@Override
	public String getText(Object element) {
		return element.toString();
	}
}
