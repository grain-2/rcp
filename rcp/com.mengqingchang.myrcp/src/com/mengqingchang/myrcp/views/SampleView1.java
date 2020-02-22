/**
 *@author MengQingChang
 *Copyright  2007-11-21,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.ui.part.ViewPart;

import com.mengqingchang.myrcp.actions.ViewToolbarAction;
import com.mengqingchang.myrcp.editors.SampleEditorInput;

public class SampleView1 extends ViewPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */

	private List list;
	// ����SampleView2��ͼID
	 public static final String ViewID = "com.mengqingchang.myrcp.view2";

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		// ����һ���б����
		list = new List(parent, SWT.NONE);
		// �����б���
		list
				.setItems(new String[] { "SampleView2", "SampleEditor",
						"MulEditor" });
		// �����Զ���,ʵ����ͼ�Ľ���
		hookClickAction();
		// ��ӹ�������ť
		fillViewToolBarAction();
		// �����Զ��巽���������ͼ�����������˵�
		fillViewToolBarContextMenu();
		// �����Զ��巽����Ϊ�б���������Ĳ˵�
		fillListContextMenu();

	}

	// �Զ��巽���������ͼ��������ť
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// ���幤����
		IToolBarManager toolBar = bars.getToolBarManager();
		// ��Ӳ���Ϊ��������ť
		toolBar.add(new ViewToolbarAction());
	}

	// �Զ��巽���������ͼ�����������˵���
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// ����˵�
		IMenuManager toolBarMenu = bars.getMenuManager();
		// ��Ӳ���Ϊ�����˵�

		toolBarMenu.add(new ViewToolbarAction());

	}

	// �Զ��巽��,Ϊ�б���������Ĳ˵�
	private void fillListContextMenu() {
		MenuManager menuManger = new MenuManager();
		Menu menu = menuManger.createContextMenu(list);
		// Ϊ�б����ò˵�
		list.setMenu(menu);
		// ��Ӳ���Ϊ�б������Ĳ˵�
		menuManger.add(new ViewToolbarAction());
	}

	private void hookClickAction() {
		list.addMouseListener(new MouseAdapter() {
			SampleEditorInput sampleEditorInput = new SampleEditorInput();
			// ���IWorkbenchPage����
			IWorkbenchPage workbenchPage = getViewSite().getPage();

			public void mouseDoubleClick(MouseEvent e) {

				IEditorInput editorInput = null;
				String editorID = null;
				// ����б�ĵڶ�������ֵ
				if (list.getSelectionIndex() == 1) {
					editorInput = sampleEditorInput;
					// ����SampleEditor�༭��idֵ����plugin.xml�ж����idֵ
					editorID = "com.mengqingchang.myrcp.editor1";
					// ����SampleEditor�༭��
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					// ����˱༭���Ѿ����ڣ��򽫱༭������Ϊ��ǰ״̬��
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else
						// ������༭�������ڣ����һ���༭����
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorID);
						}catch(Exception ex) {
			                   System.out.println(ex);
		                 }

				}

			}

			public void mouseDown(MouseEvent e) {

				// ���Ҫ��ʾ���ݵ���ͼ����
				IViewPart viewPart = workbenchPage.findView(ViewID);
				// ת����ͼ����
				SampleView2 view2 = (SampleView2) viewPart;
				// ��������
				view2.setContent(list.getSelection()[0]);
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
