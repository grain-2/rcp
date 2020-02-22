/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorActionBarContributor;

public class MyEditorContributor extends EditorActionBarContributor {
	private Action toobarAction;

	public MyEditorContributor() {
		makeActions();
	}

	public void makeActions() {
		toobarAction = new Action() {
			// ��run��������Ӿ������
			public void run() {
			}
		};
		// �����ʾ�Ա�ǩ����
		toobarAction.setToolTipText("��������ť����");
		// ��ӹ�������ťͼ��
		toobarAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJS_TASK_TSK));
	}

	// ��ӹ���̨�˵�����
	public void contributeToMenu(IMenuManager menuManager) {
	}

	// ����̨����������
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// ���÷ָ��
		toolBarManager.add(new Separator());
		// ��ӹ�������ť
		toolBarManager.add(toobarAction);
	}

}
