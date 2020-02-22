package com.myplugin.helloworld.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * SampleAction操作类继承了IWorkbenchWindowActionDelegate接口
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	/**
	 * 构造函数
	 */
	public SampleAction() {
	}

	// 操作被触发，打开一个信息提示对话框
	public void run(IAction action) {
		MessageDialog.openInformation(window.getShell(), "Helloworld Plug-in",
				"Hello, Eclipse world");
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * 销毁系统资源
	 */
	public void dispose() {
	}

	/**
	 * 缓冲窗口对象为了能够为信息对话提供父类窗体
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}