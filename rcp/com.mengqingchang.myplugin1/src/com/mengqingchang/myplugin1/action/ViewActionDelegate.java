/**
 *@author MengQingChang
 *Copyright 2007-10-30,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

import com.mengqingchang.myplugin1.views.View2;

public class ViewActionDelegate implements IViewActionDelegate {

	private View2 view2;

	public ViewActionDelegate() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	// 对视图进行初始化
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		this.view2 = (View2) view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	// 操作的触发实现
	public void run(IAction action) {
	MessageDialog.openInformation(null, "Hello", "This is View Action!!!!");
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
