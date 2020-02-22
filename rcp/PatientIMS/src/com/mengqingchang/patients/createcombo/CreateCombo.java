/**
 *@author MengQingChang
 *Copyright 2007-12-13 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patients.createcombo;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Doctor;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;
import com.mengqingchang.patientims.model.Patient;
 
public class CreateCombo {
	public static Combo createAllDeparCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	 	 for (Department de : DataBaseOperate.getAllDeparCombo()) {
			 String depar = de.getDepartment();
			 combo.add(depar);
			 combo.setData(depar, de);
		 }
		return combo;
	}

	public static Combo createPatientIdCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	  for (Patient pi : DataBaseOperate.getPatientIdCombo()) {
		 	String patientId= pi.getId()+"";
			 combo.add( patientId);
			 combo.setData( patientId, pi);
		 }
		return combo;
	}

	public static Combo createAllSickRoomCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	 	 for (SickRoom sr : DataBaseOperate. getAllSickRoomCombo()) {
			 String sickRoom = sr.getSickRoomId()+"";
			 combo.add(sickRoom);
			 combo.setData(sickRoom, sr);
		 }
		return combo;
	}
	public static Combo createAllSickBedCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	 	 for (SickBed sb : DataBaseOperate.getAllSickBedCombo()) {
			 String sickBed = sb.getSickBedId()+"";
			 combo.add(sickBed);
			 combo.setData(sickBed, sb);
		 }
		return combo;
	}
	public static Combo createAllDoctorNameCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	 	 for (Doctor  dn : DataBaseOperate.getAllDoctorNameCombo()) {
			 String doctorName = dn.getName();
			 combo.add( doctorName);
			 combo.setData( doctorName, dn);
		 }
		return combo;
	}
	/*
	public static Combo createAllPatientIdCombo(Composite parent, int style) {
		Combo combo = new Combo(parent, style);
	 	 for (Patient  pi : DataBaseOperate.getAllPatientIdCombo()) {
			 String patientId = pi.getId()+"";
			 combo.add(patientId );
			 combo.setData(patientId , pi);
		 }
		return combo;
	}
	*/
}
