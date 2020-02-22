/**
 *@author MengQingChang
 *Copyright  2007-11-19,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;

public class OpenAction extends Action {
	private IWorkbenchWindow window;

	public OpenAction(IWorkbenchWindow window) {
		this.window = window;
		//���ò˵����ı�����ݼ���
		this.setText("&Navigator@Ctrl+Alt+N");
		//����������ʾ�Ա�ǩ
		setToolTipText("Open View Action!");
		//���ò˵����������ťͼ��
		ImageDescriptor imgDes = WorkbenchImages
				.getImageDescriptor(IWorkbenchGraphicConstants.IMG_LCL_PIN_VIEW);
		this.setImageDescriptor(imgDes);

	}

	public void run() {
		MessageDialog.openInformation(window.getShell(), "Myrcp Plug-in",
				"Hello, Eclipse world");
	}
}
