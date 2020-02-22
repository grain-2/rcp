/**
 *@author MengQingChang
 *Copyright 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class OpenSearchView extends Action implements IWorkbenchAction {
	private IWorkbenchWindow window;
	// ����������Search����ͼ��idֵ
	String searchViewID = "patientims.views.SearchView";

	public OpenSearchView(IWorkbenchWindow window) {
		this.window = window;
		// ���ò˵����ı��������ò˵�����ӿ�ݼ�������
		this.setText("&Search@Ctrl+F");
		// ����������ʾ����Ϣ
		setToolTipText("Open Search View");
		// ��ӹ�����ͼ�갴ť
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/search.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// ����ͼ
				window.getActivePage().showView(searchViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
	public void dispose() {
		window = null;

	}
}

 
