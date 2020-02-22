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

	// Ϊ��ҳ�༭������������µı༭ҳ
	protected void createPages() {
		// �Զ��巽�������༭ҳ
		createPage0();
		createPage1();
		createPage2();
	}

	private void createPage0() {
		styledText = new StyledText(getContainer(), SWT.NONE);
		// �ڶ�ҳ�༭���ϴ����������ҳ�������������Ŀռ䡣
		addPage(styledText);
		// ���ո���������Ϊҳ�������ı���ǩ
		setPageText(0, "PageOne");
		
	}

	private void createPage1() {
		text = new Text(getContainer(), SWT.NONE);
		addPage(text);
		setPageText(1, "PageTwo");
		//�˴��޷������
//		WorkbenchHelp.setHelp(text, "com.mengqingchang.myplugin1.mulEditorId");
	}

	private void createPage2() {
		lable = new Label(getContainer(), SWT.NONE);
		lable.setText("��ǩ");
		addPage(lable);
		setPageText(2, "PageThree");
	}

	/**
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */

	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	/**
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */

	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	/**
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */

	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
