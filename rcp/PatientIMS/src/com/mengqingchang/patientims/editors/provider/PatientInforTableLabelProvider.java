/**
 *@author MengQingChang
 *Copyright   2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.editors.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;

public class PatientInforTableLabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub
	 
		Patient patient = (Patient) element;
		SickRoom sickRoom=patient.getSickRoom();
		SickBed sickBed=patient.getSickBed();
		Department department=patient.getDepartment();
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
	    	 rs = department.getDepartment();
		 
			break;
     	case 6:  
	 		rs = sickRoom.getSickRoomId()+"";
	 		break;
		case 7:  
		   rs=sickBed.getSickBedId()+"";
	  	   break;
	 	case 8:
			rs = patient.getAddress();
			break;
		case 9:
			rs=patient.getLogDate()+"";
			break;
		default:
			rs="";
		}
		return rs==null?"":rs;
		
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		 
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
