package com.myplugin.helloworld.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * SampleAction������̳���IWorkbenchWindowActionDelegate�ӿ�
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	/**
	 * ���캯��
	 */
	public SampleAction() {
	}

	// ��������������һ����Ϣ��ʾ�Ի���
	public void run(IAction action) {
		MessageDialog.openInformation(window.getShell(), "Helloworld Plug-in",
				"Hello, Eclipse world");
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * ����ϵͳ��Դ
	 */
	public void dispose() {
	}

	/**
	 * ���崰�ڶ���Ϊ���ܹ�Ϊ��Ϣ�Ի��ṩ���ര��
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}