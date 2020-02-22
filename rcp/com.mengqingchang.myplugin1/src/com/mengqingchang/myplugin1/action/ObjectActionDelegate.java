/**
 *@author MengQingChang
 *Copyright 2007-10-30,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;

import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ObjectActionDelegate implements IObjectActionDelegate {

	public ObjectActionDelegate() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */

	public void run(IAction action) {
		MessageDialog.openInformation(null, "Hello",
				"This is Object Action!!!!");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

}
