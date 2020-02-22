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
	// 设置功能导航（Navigator）视图的id值
	String navigatorViewID = "patientims.views.NaviagtorView";

	public OpenNavigatorView(IWorkbenchWindow window) {
		this.window = window;
		// 设置菜单项文本，并给该菜单项添加快捷键及键绑定
		this.setText("&Navigator@Ctrl+N");
		// 工具栏上提示性信息
		setToolTipText("Open Navigator View");
		// 添加工具栏图标按钮
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/navigator.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// 打开视图
				window.getActivePage().showView(navigatorViewID);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
