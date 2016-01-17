package com.shashwat.treeviewer.editable.treeviewSupport;

import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.shashwat.treeviewer.editable.model.TreeData;

public class TreeviewerContentProvider implements ITreeContentProvider {
	private Map<TreeData, TreeData[]> dataMap;
	
	@Override
	public void dispose() {}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	@SuppressWarnings({"unchecked" })
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Map) {
			this.dataMap = (Map<TreeData, TreeData[]>)inputElement;
			return this.dataMap.keySet().toArray();
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TreeData && this.dataMap.containsKey(parentElement)) {
			Object object = this.dataMap.get(parentElement);
			if (object instanceof Object[]) {
				return (Object[])object;
			}
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
