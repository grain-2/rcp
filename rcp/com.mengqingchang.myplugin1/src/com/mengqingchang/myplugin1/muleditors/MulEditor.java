/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.muleditors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MulEditor extends MultiPageEditorPart {
	private Text text;
	private StyledText styledText;
	private Label lable;

	// 为多页编辑器创建并添加新的编辑页
	protected void createPages() {
		// 自定义方法创建编辑页
		createPage0();
		createPage1();
		createPage2();
	}

	private void createPage0() {
		styledText = new StyledText(getContainer(), SWT.NONE);
		// 在多页编辑器上创建并添加新页，它包含给定的空间。
		addPage(styledText);
		// 按照给定的索引为页面设置文本标签
		setPageText(0, "PageOne");
		
	}

	private void createPage1() {
		text = new Text(getContainer(), SWT.NONE);
		addPage(text);
		setPageText(1, "PageTwo");
		//此处无法引入包
//		WorkbenchHelp.setHelp(text, "com.mengqingchang.myplugin1.mulEditorId");
	}

	private void createPage2() {
		lable = new Label(getContainer(), SWT.NONE);
		lable.setText("标签");
		addPage(lable);
		setPageText(2, "PageThree");
	}

	/**
	 * （非 Javadoc）
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */

	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	/**
	 * （非 Javadoc）
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */

	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	/**
	 * （非 Javadoc）
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */

	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
