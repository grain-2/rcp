/**
 *@author MengQingChang
 *Copyright 2007-10-26,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class HelloWorldAction implements IWorkbenchWindowActionDelegate {

	public HelloWorldAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		MessageDialog.openInformation(null,"Hello","HelloWorld Plugin!!!!");	

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
