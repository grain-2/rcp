/**
 *@author MengQingChang
 *Copyright 2007-12-13 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
 
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.Expense;
import com.mengqingchang.patientims.model.Patient;
 

public class SearchPatientExpenseInforTableProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		Expense expense  = (Expense) element;
		String rs;
		Patient patient=expense.getPatient();
	
		switch (columnIndex) {
		case 0:
		 	rs =  patient.getId().toString();
			break;
		case 1:
		 	rs =  patient.getName();
			break;
		case 2:
			rs = expense.getExpenseIllustrate() ;
			break;
		case 3:
			rs=expense.getExpenseName() ;
			break;
		case 4:
			rs = expense.getUnitPrice()+""  ;
			break;
		case 5:
			rs=expense.getNumber()+"";
			break;
		case 6:
			rs=expense.getOccurExpense()+"";
			break;
		case 7:
			rs=expense.getTakeDate()+"";
			break;
		case 8:
			Doctor doctor=expense.getDoctor();
			rs=doctor.getName();
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
