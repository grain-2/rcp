/**
 *@author MengQingChang
 *Copyright 2007-12-26,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import com.mengqingchang.patientims.actions.OpenSearchView;
import com.mengqingchang.patientims.navigator.model.NavigatorEntityElement;
import com.mengqingchang.patientims.navigator.model.NavigatorEntityFactory;
import com.mengqingchang.patientims.navigatorTreeViewer.TreeViewerContentProvider;
import com.mengqingchang.patientims.navigatorTreeViewer.TreeViewerLabelProvider;

public class NavigatorView extends ViewPart {

	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		// ����TreeViewer
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// ���������ṩ��
		tv.setContentProvider(new TreeViewerContentProvider());
		// ���ñ�ǩ�ṩ��
		tv.setLabelProvider(new TreeViewerLabelProvider());
		// ��setInput������������
		tv.setInput(NavigatorEntityFactory.TreeEntityElement());
		// �����Զ��巽���������ͼ��������ť
		fillViewToolBarAction();
		// �����Զ��巽���������ͼ�����������˵�
		fillViewToolBarContextMenu();
		/**
		 * �����Զ��巽����ʵ��˫�������ڵ����Ӧ�ı༭�����ܡ�
		 */
		hookDoubleClickAction();

	}

	// �����ͼ������
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// ���幤����
		IToolBarManager toolBar = bars.getToolBarManager();
		drillDownAdapter = new DrillDownAdapter(tv);
		// Ϊ��������ӡ�goback"��"gohomo"��"gointo"������
		drillDownAdapter.addNavigationActions(toolBar);
	}

	// �Զ��巽���������ͼ�����������˵���
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// ����˵�
		IMenuManager toolBarMenu = bars.getMenuManager();

		// Ϊ�����������˵����"goback"��"gohome"��"gointo"������
		drillDownAdapter.addNavigationActions(toolBarMenu);
	}

	private void hookDoubleClickAction() {
		tv.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				String editorId = null;
				ISelection selection = tv.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				NavigatorEntityElement object = (NavigatorEntityElement) obj;
				IEditorInput editorInput = object.getEditorInput();
				IWorkbenchPage workbenchPage = getViewSite().getPage();
				// ����Ҫ�򿪵ı༭������
				if (object.getName().equals("���˵���")) {
					// ���ñ༭��id��idΪplugin.xml�����õ�idֵ��
					editorId = "PatientIMS.editor1";
					/*
					 * �������(�Ѿ�������ı༭������ ��������Ϊ��ǰ�ı༭����
					 */
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						// ����༭����û�д򿪣��������༭��
						try {// �򿪱༭���ķ���
							editor = workbenchPage.openEditor(editorInput,
									editorId);
						} catch (Exception ex) {
							System.out.println(ex);
						}

					}
				}
				if (object.getName().equals("�����Ϣ")) {

					editorId = "PatientIMS.editor2";
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorId);
						} catch (Exception ex) {
							System.out.println(ex);
						}

					}

				} else if (object.getName().equals("������Ϣ")) {
					editorId = "PatientIMS.editor3";
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorId);

						} catch (Exception ex) {
							System.out.println(ex);
						}

					}
				}

				else if (object.getName().equals("��Ϣ��ѯ")) {
					//��������ͼ
					createShowViewAction(getSite().getWorkbenchWindow()).run();
				} else
					;
			}
		});
	}
    //���ô�Search����������ͼ����
	public static IWorkbenchAction createShowViewAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		IWorkbenchAction action = new OpenSearchView(window);
		return action;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
