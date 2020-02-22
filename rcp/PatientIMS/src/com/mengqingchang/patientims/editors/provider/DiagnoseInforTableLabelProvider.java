/**
 *@author MengQingChang
 *Copyright 2007-12-10 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.editors.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
 
import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.Patient;

public class DiagnoseInforTableLabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Diagnose diagnose  = (Diagnose) element;
	 	Patient patient=diagnose.getPatient();
		String rs;
		switch (columnIndex) {
		case 0:
			
		 	rs =  diagnose.getId().toString();
			break;
		case 1:
		 	rs =  patient.getName();
			break;
		case 2:
			rs = diagnose.getSickName();
			break;
		case 3:
			rs =diagnose.getTherapeutic() ;
			break;
		case 4:
			rs =diagnose.getTreatDate()+"" ;
			break;
		case 5:
			Doctor doctor=diagnose.getDoctor();
			rs = doctor.getName() ;
			break;
		default:
			rs="";
		}
		return rs==null?"":rs;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
