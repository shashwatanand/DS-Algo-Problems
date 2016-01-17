package com.shashwat.treeviewer.editable;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

import com.shashwat.treeviewer.editable.model.TreeData;
import com.shashwat.treeviewer.editable.treeviewSupport.TreeviewerCellEditor;
import com.shashwat.treeviewer.editable.treeviewSupport.TreeviewerContentProvider;
import com.shashwat.treeviewer.editable.treeviewSupport.TreeviewerLabelProvider;

public class TreeviewerShell {
	private Map<TreeData, TreeData[]> data;

	public TreeviewerShell(Shell shell) {
		this.data = new LinkedHashMap<>();
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
		//treeviewer.setLabelProvider(new TreeviewerLabelProvider());
		treeviewer.setInput(this.data);
		
		TreeViewerEditor.create(treeviewer, new ColumnViewerEditorActivationStrategy(treeviewer){
			@Override
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION;
			}
		}, TreeViewerEditor.DEFAULT);
		
		TextCellEditor cellEditor = new TreeviewerCellEditor(treeviewer.getTree());
		//enableEditingFirst(treeviewer, cellEditor);
		
		enableEditingSecond(treeviewer);
	}

	private void enableEditingSecond(final TreeViewer treeviewer) {
		final TreeViewerColumn column = new TreeViewerColumn(treeviewer, SWT.NONE);
		column.getColumn().setWidth(150);
		column.setLabelProvider(new TreeviewerLabelProvider());
		column.setEditingSupport(new EditingSupport(treeviewer) {
			
			@Override
			protected void setValue(Object element, Object value) {
				if (element instanceof TreeData) {
					TreeData treeData = (TreeData) element;
					treeData.setData(value.toString());
				}
				treeviewer.update(element, null);
			}
			
			@Override
			protected Object getValue(Object element) {
				return element.toString();
			}
			
			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TreeviewerCellEditor(treeviewer.getTree());
			}
			
			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
	}

	private void enableEditingFirst(TreeViewer treeviewer, TextCellEditor cellEditor) {
		treeviewer.setColumnProperties(new String[] {"Column"});
		treeviewer.setLabelProvider(new TreeviewerLabelProvider());
		treeviewer.setCellEditors(new CellEditor[] {cellEditor});
		treeviewer.setCellModifier(new ICellModifier() {
			
			@Override
			public void modify(Object element, String property, Object value) {
				if (element instanceof TreeItem) {
					TreeItem treeItem = (TreeItem)element;
					TreeData treeData = (TreeData)treeItem.getData();
					treeData.setData(value.toString());
					treeItem.setText(value.toString());
				}
			}
			
			@Override
			public Object getValue(Object element, String property) {
				return element.toString();
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				return true;
			}
		});
	}
}
