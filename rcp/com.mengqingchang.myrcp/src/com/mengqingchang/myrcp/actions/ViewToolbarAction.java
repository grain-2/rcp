/**
 *@author MengQingChang
 *Copyright  2007-11-23,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

public class ViewToolbarAction extends Action {
	public ViewToolbarAction() {
		setText("&SampleAction@Ctrl+Alt+A");
		// 提示性的字符信息
		setToolTipText("Action tooltip");
		setImageDescriptor(com.mengqingchang.myrcp.MyRcpPlugin
				.getImageDescriptor("/icons/sample2.gif")); 
	}
	public void run() {
		MessageDialog.openInformation(null, "Hello",
				"This is View Action!!!!");
	}

}
