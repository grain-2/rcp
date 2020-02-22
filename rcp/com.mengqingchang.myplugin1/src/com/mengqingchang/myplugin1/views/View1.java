/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

public class View1 extends ViewPart {
	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	public View1() {
		// TODO �Զ����ɹ��캯�����
	}

	public void createPartControl(Composite parent) {
		// ����TreeViewer
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// ���������ṩ��
		tv.setContentProvider(new TreeViewerContentProvider());
		// ���ñ�ǩ�ṩ��
		tv.setLabelProvider(new TreeViewerLabelProvider());
		// ��setInput������������
		tv.setInput(EntityFactory.TreeEntityElement());
		// �����Զ��巽���������ͼ��������ť
		fillViewToolBarAction();
		// �����Զ��巽���������ͼ�����������˵�
		fillViewToolBarContextMenu();
		// �����Զ��巽����Ϊ�鿴����������Ĳ˵�
		fillTreeViewContextMenu();
		// �����Զ���˫������
		hookDoubleClickAction();
		// tv.addDoubleClickListener(new MyDoubleClickListener());

	}

	// �Զ��巽������ӹ�������ť
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// ���幤����
		IToolBarManager toolBar = bars.getToolBarManager();
		drillDownAdapter = new DrillDownAdapter(tv);
		// Ϊ��������ӡ�goback������gohome������gointo��������
		drillDownAdapter.addNavigationActions(toolBar);
		// ��ӷָ��
		toolBar.add(new Separator());
		// ��Ӳ���
		toolBar.add(new ActionOne());
		toolBar.add(new ActionTwo());
	}

	// �Զ��巽������ӹ����������˵���
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// ����˵�
		IMenuManager toolBarMenu = bars.getMenuManager();
		toolBarMenu.add(new ActionOne());
		toolBarMenu.add(new ActionTwo());
		toolBarMenu.add(new Separator());
		// Ϊ�����������˵���ӡ�goback������gohome������gointo��������
		drillDownAdapter.addNavigationActions(toolBarMenu);
	}

	// �Զ��巽��,Ϊ���鿴����������Ĳ˵�
	private void fillTreeViewContextMenu() {
		MenuManager menuManger = new MenuManager();
		Menu menu = menuManger.createContextMenu(tv.getControl());
		tv.getControl().setMenu(menu);
		menuManger.add(new ActionOne());
		menuManger.add(new ActionTwo());
		menuManger.add(new Separator());
		// Ϊ�����Ĳ˵�����ӡ�goback������gohome������gointo��������
		drillDownAdapter.addNavigationActions(menuManger);
	}

	// ������
	class ActionOne extends Action {
		public ActionOne() {
			// ���ò����ı�
			setText("ActionOne");
			// ��ʾ�Ե��ַ���ǩ
			setToolTipText("ActionOne tooltip");
			// ����ͼ��
			ImageDescriptor imageDesc = WorkbenchImages
					.getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_NEW_PAGE);
			setHoverImageDescriptor(imageDesc);
			// Ҳ����������ķ�������ͼ��
			/**
			 * setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			 * getImageDescriptor(ISharedImages.IMG_OBJS_BKMRK_TSK));
			 */

		}

		public void run() {
			MessageDialog.openInformation(null, "Hello",
					"This is View Action!!!!");
		}
	}

	class ActionTwo extends Action {
		public ActionTwo() {
			setText("ActionTwo");
			// ��ʾ�Ե��ַ���Ϣ
			setToolTipText("ActionTwo tooltip");
			// ����ͼ��
			ImageDescriptor imageDesc = WorkbenchImages
					.getImageDescriptor(IWorkbenchGraphicConstants.IMG_OBJ_THEME_CATEGORY);
			setHoverImageDescriptor(imageDesc);

			/**
			 * setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			 * getImageDescriptor(ISharedImages.IMG_OBJS_BKMRK_TSK));
			 * 
			 */
		}

		public void run() {
			MessageDialog.openInformation(null, "Hello",
					"This is View Action!!!!");
		}
	}

	private void hookDoubleClickAction() {
		tv.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// ѡ�������Ԫ��
				IStructuredSelection strsel = (IStructuredSelection) event
						.getSelection();
				/*
				 * getFirstElement()��������������ѡ��ĵ�һ��Ԫ�أ� 
				 * ���ѡ��Ϊ�գ��򷵻�null��
				 */
				EntityElement entityelement = (EntityElement) strsel
						.getFirstElement();

				String editorId = null;

				IEditorInput editorInput = entityelement.getEditorInput();
				// �ж�˫���ڵ�ʱ��õĽڵ������Ƿ����"Ա������'��
				if (entityelement.getName().equals("Ա������")) {
					System.out.println(entityelement.getName());
					// ���ñ༭��id��idΪplugin.xml�����õ�idֵ��
					editorId = "com.mengqingchang.myplugin1.editor1";
					IWorkbenchPage workbenchPage = getViewSite().getPage();
					// ����Ҫ�򿪵ı༭������
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					/*
					 * �������(�Ѿ�������ı༭������
					 *  ��������Ϊ��ǰ�ı༭����
					 */
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
			}
		});
	}

	public void setFocus() {
		// TODO �Զ����ɷ������
	}
}
