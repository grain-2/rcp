/**
 *@author MengQingChang
 *Copyright 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

public class OpenNavigatorView extends Action {
	private final IWorkbenchWindow window;
	// ���ù��ܵ�����Navigator����ͼ��idֵ
	String navigatorViewID = "patientims.views.NaviagtorView";

	public OpenNavigatorView(IWorkbenchWindow window) {
		this.window = window;
		// ���ò˵����ı��������ò˵�����ӿ�ݼ�������
		this.setText("&Navigator@Ctrl+N");
		// ����������ʾ����Ϣ
		setToolTipText("Open Navigator View");
		// ��ӹ�����ͼ�갴ť
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/navigator.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// ����ͼ
				window.getActivePage().showView(navigatorViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
