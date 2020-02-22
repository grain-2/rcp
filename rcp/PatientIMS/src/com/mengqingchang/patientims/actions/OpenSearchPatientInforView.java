/**
 *@author MengQingChang
 *Copyright 2007-12-11 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class OpenSearchPatientInforView extends Action {

	private IWorkbenchWindow window;
	// ���ò�����Ϣ��ͼ��idֵ
	String searchPatientInforViewID = "patientims.views.SearchPatientInforView";

	public OpenSearchPatientInforView(IWorkbenchWindow window) {
		this.window = window;
		// ���ò˵����ı��������ò˵�����ӿ�ݼ�������
		this.setText("&PatientInfor@Ctrl+P");
		// ��ӹ�����ͼ�갴ť
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/search.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// ����ͼ
				window.getActivePage().showView(searchPatientInforViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
