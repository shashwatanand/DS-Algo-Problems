package com.shashwat.treeviewer.editable.treeviewSupport;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

public class TreeviewerCellEditor extends TextCellEditor {
	private int mHeight = 0;

	public TreeviewerCellEditor(Tree tree) {
		super(tree, SWT.BORDER);
		Text text = (Text)getControl();
		Font font = text.getFont();
		FontData[] fontData = font.getFontData();
		if (fontData != null && fontData.length > 0) {
			this.mHeight = fontData[0].getHeight() + 8;
		}
	}
	
	public LayoutData getLayoutData() {
		LayoutData layoutData = super.getLayoutData();
		if (this.mHeight > 0) {
			layoutData.minimumHeight = mHeight;
		}
		return layoutData;
	}
}
