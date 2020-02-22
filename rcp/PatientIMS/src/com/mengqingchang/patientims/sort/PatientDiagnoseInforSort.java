/**
 *@author MengQingChang
 *Copyright 2007-12-29 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.sort;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.mengqingchang.patientims.model.Diagnose;

public class PatientDiagnoseInforSort extends ViewerSorter {
	private int column;

	public void doSort(int column) {
		this.column = column;
	}

	public int compare(Viewer viewer, Object e1, Object e2) {
		Diagnose dia1 = (Diagnose) e1;
		Diagnose dia2 = (Diagnose) e2;
		switch (column) {
		case 1: {
			Long str1 = dia1.getId();
			Long str2 = dia2.getId();
			int DiagnoseIDDesc = str2.compareTo(str1);
			return DiagnoseIDDesc;
		}
		case -1: {
			Long str1 = dia1.getId();
			Long str2 = dia2.getId();
			int DiagnoseIDAsc = str1.compareTo(str2);
			return DiagnoseIDAsc;
		}
		case 5: {
			String str1 = dia1.getTreatDate() + "";
			String str2 = dia2.getTreatDate() + "";
			int DiagnoseDateDesc = str2.compareTo(str1);
			return DiagnoseDateDesc;
		}
		case -5: {
			String str1 = dia1.getTreatDate() + "";
			String str2 = dia2.getTreatDate() + "";
			int DiagnoseDateAsc = str1.compareTo(str2);
			return DiagnoseDateAsc;
		}
		}
		return 0;
	}
}
