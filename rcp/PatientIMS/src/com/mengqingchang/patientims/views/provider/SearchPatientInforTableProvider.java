/**
 *@author MengQingChang
 *Copyright 2007-12-11 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;

public class SearchPatientInforTableProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
    	Patient patient = (Patient) element;
		Department department=patient.getDepartment();
		SickBed sickBed=patient.getSickBed ();
		SickRoom sickRoom=patient.getSickRoom ();
		Doctor doctor = patient.getDoctor();
		Diagnose diagnose=patient.getDiagnose ();
		String rs;
		switch (columnIndex) {
		case 0:
			rs = patient.getId().toString();
			break;
		case 1:
			rs = patient.getName();
			break;
		case 2:
			rs = patient.getSex();
			break;
		case 3:
			rs = "" + patient.getAge();
			break;
		case 4:
		 
			rs = patient.getPhone();
			break;
		case 5:
			rs=department.getDepartment();
		 
			break;
		case 6:
			rs=sickRoom.getSickRoomId()+"";
	 		break;
		case 7:
			rs=sickBed.getSickBedId()+"";
     		break;
		case 8:
			rs=diagnose.getSickName();
		 
			break;

		case 9:
			rs = diagnose.getTherapeutic();
			break;

		case 10:
			rs = doctor.getName();
			break;
		case 11:
			rs = patient.getAddress();
			break;
		case 12:
			rs = patient.getLogDate() + "";
			break;
		default:
			rs = "";
		}
		return rs == null ? "" : rs;
		 
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
