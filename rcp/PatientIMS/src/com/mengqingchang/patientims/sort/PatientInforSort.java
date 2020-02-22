/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.sort;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.viewers.Viewer;
import com.mengqingchang.patientims.model.Patient;
public class PatientInforSort extends ViewerSorter {
	private int column;
	public void doSort(int column){
		this.column=column;
	}
   public int compare(Viewer viewer,Object e1,Object e2){
	 Patient pat1=(Patient)e1;
	 Patient pat2=(Patient)e2;
	  switch(column){
	 case 1:{
		 Long str1=pat1.getId();
		 Long str2=pat2.getId();
		 int PatientIDDesc=str2.compareTo(str1);
		 return PatientIDDesc;
	 }
	 case -1:{
		 Long str1=pat1.getId();
		 Long str2=pat2.getId();
		 int PatientIDAsc=str1.compareTo(str2);
		 return PatientIDAsc;
	 }
	 case 2:{
		 String str1=pat1.getName();
		 String str2=pat2.getName();
		 int PatientNameDesc=str2.compareTo(str1);
		 return PatientNameDesc;
	 }
	 case -2:{
		 String str1=pat1.getName();
		 String str2=pat2.getName();
		 int PatientNameAsc=str1.compareTo(str2);
		 return PatientNameAsc;
	 }
	 case 3:{
		 String str1=pat1.getSex();
		 String str2=pat2.getSex();
		 int PatientSexDesc=str2.compareTo(str1);
		 return PatientSexDesc;
	 }
	 case -3:{
		 String str1=pat1.getSex();
		 String str2=pat2.getSex();
		 int PatientSexAsc=str1.compareTo(str2);
		 return PatientSexAsc;
	 }
	 case 4:{
		 String str1=pat1.getAge()+"";
		 String str2=pat2.getSex()+"";
		 int PatientAgeDesc=str2.compareTo(str1);
		 return PatientAgeDesc;
	 }
	 case -4:{
		 String str1=pat1.getAge()+"";
		 String str2=pat2.getAge()+"";
		 int PatientAgeAsc=str1.compareTo(str2);
		 return PatientAgeAsc;
	 }
	 case 5:{
		 String str1=pat1.getPhone();
		 String str2=pat2.getPhone();
		 int PatientPhoneDesc=str2.compareTo(str1);
		 return PatientPhoneDesc;
	 }
	 case -5:{
		 String str1=pat1.getPhone();
		 String str2=pat2.getPhone();
		 int PatientPhoneAsc=str1.compareTo(str2);
		 return PatientPhoneAsc;
	 }
	
	 case 6:{
		 String str1=pat1.getDepartment().getDepartment()+"";
		 String str2=pat1.getDepartment().getDepartment()+"";
		 int PatientDeparDesc=str2.compareTo(str1);
		 return PatientDeparDesc;
	 }
     case 9:{
		 String str1=pat1.getAddress();
		 String str2=pat2.getAddress();
		 int PatientAddressDesc=str2.compareTo(str1);
		 return PatientAddressDesc;
	 }
	 case -9:{
		 String str1=pat1.getAddress();
		 String str2=pat2.getAddress();
		 int PatientAddressAsc=str1.compareTo(str2);
		 return PatientAddressAsc;
	 }
	 case 10:{
		 String str1=pat1.getLogDate()+"";
		 String str2=pat2.getLogDate()+"";
		 int PatientLogTimeDesc=str2.compareTo(str1);
		 return PatientLogTimeDesc;
	 }
	 case -10:{
		 String str1=pat1.getLogDate()+"";
		 String str2=pat2.getLogDate()+"";
		 int PatientLogTimeAsc=str1.compareTo(str2);
		 return PatientLogTimeAsc;
	 }
	 }return 0;
   }
}
