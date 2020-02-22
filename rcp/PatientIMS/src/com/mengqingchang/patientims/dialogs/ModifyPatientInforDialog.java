/**
 *@author MengQingChang
 *Copyright 2007-12-18 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;
import com.mengqingchang.patients.createcombo.CreateCombo;

public class ModifyPatientInforDialog extends TitleAreaDialog {
	private Combo deparCombo;
	private Combo roomCombo;
	private Combo bedCombo;
	private Patient patient;

	public ModifyPatientInforDialog(Shell parentshell) {
		super(parentshell);
	}

	// 设置对话框标题信息
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getShell().setText("修改病房信息");
		// 设置标题
		setTitle("修改病人病房信息");
		// 设置对话框样式效果
		setMessage("添加所要修改病人病房信息", IMessageProvider.INFORMATION);
		// setMessage("这是TitleAreaDialog", IMessageProvider.ERROR);
		// setMessage("这是TitleAreaDialog", IMessageProvider.WARNING);
		// setMessage("这是TitleAreaDialog", IMessageProvider.NONE);
		return contents;
	}

	// 建立对话框上的内容
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(2, false));
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("科室：");
		deparCombo = CreateCombo.createAllDeparCombo(composite, SWT.NONE);
		deparCombo.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("病房：");
		roomCombo = CreateCombo.createAllSickRoomCombo(composite, SWT.NONE);
		roomCombo.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("病床：");
		bedCombo = CreateCombo.createAllSickBedCombo(composite, SWT.BORDER);
		bedCombo.setLayoutData(layoutData);

		return composite;
	}

	/*
	 * public String getDepar(){
	 * 
	 * System.out.println(dearCombo.getText()); return dearCombo.getText(); }
	 * public int getSickRoomID(){ String tsr=roomText.getText();
	 * 
	 * return Integer.valueOf(tsr); } public int getSickBedID(){ String
	 * tsb=bedText.getText();
	 * 
	 * return Integer.valueOf(tsb); }
	 */

	protected void buttonPressed(int buttonId) {
        //单击OK按钮执行下面的操作
		if (IDialogConstants.OK_ID == buttonId) {

			String de = deparCombo.getText();
			String tsr = roomCombo.getText();
			String tsb = bedCombo.getText();
			// ------验证输入信息的合法性-------
			if (de == null || de.equals("")) {
				setErrorMessage("科室名不能为空");
				return;

			}
			if (tsr == null || tsr.equals("")) {
				setErrorMessage("病房号不能为空");
				return;
			}
			if (tsb == null || tsb.equals("")) {
				setErrorMessage("病床号不能为空");
				return;
			}
			getValue(patient);

		}
		okPressed();
		// 单击Cancel按钮执行以下操作
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	// 获取对框中的数据，并植入相应的实体属性方法中。
	private void getValue(Patient patient) {

		String de = deparCombo.getText();
		Department department = (Department) deparCombo.getData(de);
		patient.setDepartment(department);

		String sr = roomCombo.getText();
		SickRoom sickRoom = (SickRoom) roomCombo.getData(sr);
		patient.setSickRoom(sickRoom);

		String sb = bedCombo.getText();
		SickBed sickBed = (SickBed) bedCombo.getData(sb);
		patient.setSickBed(sickBed);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * 用SWT.RESIZE、SWT.MAX、SWT.MIN分别设置窗口为可以变大小、窗口可最 大化、最小化
	 */
	 
	 // protected int getShellStyle() { return super.getShellStyle() | SWT.RESIZE |
	 // SWT.MAX | SWT.MIN; }
	  /** 建立按钮——确认、取消按钮 /*
	 
	/*
	 * protected void createButtonsForButtonBar(Composite parent) {
	 * createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
	 * true); createButton(parent, IDialogConstants.CANCEL_ID,
	 * IDialogConstants.CANCEL_LABEL, true); }
	 */
}
