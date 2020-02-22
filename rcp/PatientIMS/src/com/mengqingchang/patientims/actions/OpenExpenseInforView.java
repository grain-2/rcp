/**
 *@author MengQingChang
 *Copyright 2007-12-25 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

public class OpenExpenseInforView extends Action {
	private IWorkbenchWindow window;
	// ���÷�����Ϣ��ͼ��idֵ
	String OpenExpenseInforViewID = "patientims.views.SearchPatientExpenseInforView";

	public OpenExpenseInforView(IWorkbenchWindow window) {
		this.window = window;
		// ���ò˵����ı��������ò˵�����ӿ�ݼ�������
		this.setText("&ExpenseInfor@Ctrl+E");
		// ��ӹ�����ͼ�갴ť
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/search.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// ����ͼ
				window.getActivePage().showView(OpenExpenseInforViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
