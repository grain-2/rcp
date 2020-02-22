/**
 *@author MengQingChang
 *Copyright  2007-11-23,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class SampleEditorMenuAction implements IEditorActionDelegate {

	// /private IEditorPart part;
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub
		// part = targetEditor;
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		MessageDialog.openInformation(null, "Hello",
				"This is Editor Action!!!!");

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
