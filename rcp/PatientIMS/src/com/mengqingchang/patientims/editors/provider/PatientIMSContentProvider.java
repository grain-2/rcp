/**
 *@author MengQingChang
 *Copyright 2007-12-8 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.editors.provider;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class PatientIMSContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return ((List) inputElement).toArray();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

}
