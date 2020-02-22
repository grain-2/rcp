/**
 *@author MengQingChang
 *Copyright  2007-11-22,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

/**
 * @author MengQingChang
 * 
 */
public class OpenSampleView1Action extends Action {
	private final IWorkbenchWindow window;
	// 设置SampleView1视图的id值
	private final String viewId = "com.mengqingchang.myrcp.view1";

	public OpenSampleView1Action(IWorkbenchWindow window) {
		this.window = window;
		// 设置菜单项文本，并给该菜单项添加快捷键及键绑定
		this.setText("&SampleView1@Ctrl+Alt+S");
		// 工具栏上提示性信息
		setToolTipText("Open SampleView1");
		// 添加工具栏图标按钮
		setImageDescriptor(com.mengqingchang.myrcp.MyRcpPlugin
				.getImageDescriptor("/icons/view1.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// 打开视图
				window.getActivePage().showView(viewId);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
