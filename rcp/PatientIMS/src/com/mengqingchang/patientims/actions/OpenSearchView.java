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
	// 设置搜索（Search）视图的id值
	String searchViewID = "patientims.views.SearchView";

	public OpenSearchView(IWorkbenchWindow window) {
		this.window = window;
		// 设置菜单项文本，并给该菜单项添加快捷键及键绑定
		this.setText("&Search@Ctrl+F");
		// 工具栏上提示性信息
		setToolTipText("Open Search View");
		// 添加工具栏图标按钮
		setImageDescriptor(com.mengqingchang.patientims.Activator
				.getImageDescriptor("/icons/search.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// 打开视图
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

 
