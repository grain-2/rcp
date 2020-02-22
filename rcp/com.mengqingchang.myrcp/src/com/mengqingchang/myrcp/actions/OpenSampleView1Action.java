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
	// ����SampleView1��ͼ��idֵ
	private final String viewId = "com.mengqingchang.myrcp.view1";

	public OpenSampleView1Action(IWorkbenchWindow window) {
		this.window = window;
		// ���ò˵����ı��������ò˵�����ӿ�ݼ�������
		this.setText("&SampleView1@Ctrl+Alt+S");
		// ����������ʾ����Ϣ
		setToolTipText("Open SampleView1");
		// ��ӹ�����ͼ�갴ť
		setImageDescriptor(com.mengqingchang.myrcp.MyRcpPlugin
				.getImageDescriptor("/icons/view1.gif"));
	}

	public void run() {
		if (window != null) {
			try {
				// ����ͼ
				window.getActivePage().showView(viewId);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error",
						"Error opening view:" + e.getMessage());
			}
		}
	}
}
