package com.shashwat.treeviewer.editable;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;

import com.shashwat.treeviewer.editable.model.TreeData;
import com.shashwat.treeviewer.editable.treeviewSupport.TreeviewerContentProvider;
import com.shashwat.treeviewer.editable.treeviewSupport.TreeviewerLabelProvider;

public class TreeviewerShell {
	private Map<TreeData, TreeData[]> data;

	public TreeviewerShell(Shell shell) {
		this.data = new HashMap<>();
		init(shell);
	}

	private void init(Shell shell) {
		initData();
		createUi(shell);
	}


	private void initData() {
		this.data.put(new TreeData("parent1"), new TreeData[] {
			new TreeData("child1"),
			new TreeData("child2")
		});
		
		this.data.put(new TreeData("parent2"), new TreeData[] {
			new TreeData("child1"),
			new TreeData("child2")
		});
	}
	

	private void createUi(Shell shell) {
		TreeViewer treeviewer = new TreeViewer(shell);
		treeviewer.setContentProvider(new TreeviewerContentProvider());
		treeviewer.setLabelProvider(new TreeviewerLabelProvider());
		treeviewer.setInput(this.data);
	}
}
