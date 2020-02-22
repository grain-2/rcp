/**
 *@author MengQingChang
 *Copyright 2007-10-30,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class EditorActionDelegate implements IEditorActionDelegate {

	private IEditorPart part;

	public EditorActionDelegate() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IEditorPart)
	 */
	// ¼¤»îÖ¸¶¨±à¼­Æ÷
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		part = targetEditor;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		MessageDialog.openInformation(null, "Hello",
				"This is Editor Action!!!!");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
