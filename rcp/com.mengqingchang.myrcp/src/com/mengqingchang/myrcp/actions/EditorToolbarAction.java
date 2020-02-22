/**
 *@author MengQingChang
 *Copyright  2007-11-24,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;

public class EditorToolbarAction extends Action {
	public EditorToolbarAction () {
	 	setToolTipText("import Source code");
		setImageDescriptor(com.mengqingchang.myrcp.MyRcpPlugin
				.getImageDescriptor("/icons/import.gif")); 
	}
	public void run() {
		MessageDialog.openInformation(null, "Hello",
				"This is Editor Action!!!!");
	}
}
