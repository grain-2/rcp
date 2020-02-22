/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import com.mengqingchang.patientims.dialogs.AddPatientInforWizard;

public class PatientEditorActionDelegate implements IEditorActionDelegate {
	private IEditorPart part;

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub
		part = targetEditor;
	}

	@Override
	public void run(IAction action) {

		AddPatientInforWizard wizard = new AddPatientInforWizard();
		WizardDialog dialog = new WizardDialog(
				Display.getDefault().getShells()[0], wizard);
		dialog.setPageSize(-1, 130);
		dialog.open();

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
