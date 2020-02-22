/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.sort;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.viewers.Viewer;

import com.mengqingchang.patientims.model.Expense;
 

public class PatientExpenseInforSort extends ViewerSorter {
	private int column;

	public void doSort(int column) {
		this.column = column;
	}

	public int compare(Viewer viewer, Object e1, Object e2) {
		Expense exp1 = (Expense) e1;
		Expense exp2 = (Expense) e2;
		switch (column) {
		case 1: {
			Long str1 = exp1.getId();
			Long str2 = exp2.getId();
			int ExpenseIDDesc = str2.compareTo(str1);
			return ExpenseIDDesc;
		}
		case -1: {
			Long str1 = exp1.getId();
			Long str2 = exp2.getId();
			int ExpenseIDAsc = str1.compareTo(str2);
			return ExpenseIDAsc;
		}
		case 8: {
			String str1 = exp1.getTakeDate() + "";
			String str2 = exp2.getTakeDate() + "";
			int ExpenseTakeDateDesc = str2.compareTo(str1);
			return ExpenseTakeDateDesc;
		}
		case -8: {
			String str1 = exp1.getTakeDate() + "";
			String str2 = exp2.getTakeDate() + "";
			int ExpenseTakeDateAsc = str1.compareTo(str2);
			return ExpenseTakeDateAsc;
		}
		}
		return 0;
	}
}
