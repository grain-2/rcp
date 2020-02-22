/**
 *@author MengQingChang
 *Copyright  2007-11-23,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

import com.mengqingchang.myrcp.views.SampleView1;
 

public class ViewMenuAction implements IViewActionDelegate {

	private SampleView1 sampleView1;
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		this.sampleView1 = (SampleView1) view;
	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		MessageDialog.openInformation(null, "Hello", "This is View Action!!!!");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
