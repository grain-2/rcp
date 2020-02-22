/**
 *@author MengQingChang
 *Copyright 2007-11-10,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.startup;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;

public class EasyStartup implements IStartup {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	@Override
	public void earlyStartup() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "启动加载", "Eclipse启动时必须加载和启动插件");

			}
		});
	}

}
