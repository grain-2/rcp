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
	// 设置费用信息视图的id值
	String OpenExpenseInforViewID = "patientims.views.SearchPatientExpenseInforView";

	public OpenExpenseInforView(IWorkbenchWindow window) {
		this.window = window;
		// 设置菜单项文本，并给该菜单项添加快捷键及键绑定
		this.setText("&ExpenseInfor@Ctrl+E");
		// 添加工具栏图标按钮
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/search.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// 打开视图
				window.getActivePage().showView(OpenExpenseInforViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
