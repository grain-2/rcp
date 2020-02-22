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

	// ���öԻ��������Ϣ
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getShell().setText("�޸Ĳ�����Ϣ");
		// ���ñ���
		setTitle("�޸Ĳ��˲�����Ϣ");
		// ���öԻ�����ʽЧ��
		setMessage("�����Ҫ�޸Ĳ��˲�����Ϣ", IMessageProvider.INFORMATION);
		// setMessage("����TitleAreaDialog", IMessageProvider.ERROR);
		// setMessage("����TitleAreaDialog", IMessageProvider.WARNING);
		// setMessage("����TitleAreaDialog", IMessageProvider.NONE);
		return contents;
	}

	// �����Ի����ϵ�����
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(2, false));
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("���ң�");
		deparCombo = CreateCombo.createAllDeparCombo(composite, SWT.NONE);
		deparCombo.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("������");
		roomCombo = CreateCombo.createAllSickRoomCombo(composite, SWT.NONE);
		roomCombo.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("������");
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
        //����OK��ťִ������Ĳ���
		if (IDialogConstants.OK_ID == buttonId) {

			String de = deparCombo.getText();
			String tsr = roomCombo.getText();
			String tsb = bedCombo.getText();
			// ------��֤������Ϣ�ĺϷ���-------
			if (de == null || de.equals("")) {
				setErrorMessage("����������Ϊ��");
				return;

			}
			if (tsr == null || tsr.equals("")) {
				setErrorMessage("�����Ų���Ϊ��");
				return;
			}
			if (tsb == null || tsb.equals("")) {
				setErrorMessage("�����Ų���Ϊ��");
				return;
			}
			getValue(patient);

		}
		okPressed();
		// ����Cancel��ťִ�����²���
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	// ��ȡ�Կ��е����ݣ���ֲ����Ӧ��ʵ�����Է����С�
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
	 * ��SWT.RESIZE��SWT.MAX��SWT.MIN�ֱ����ô���Ϊ���Ա��С�����ڿ��� �󻯡���С��
	 */
	 
	 // protected int getShellStyle() { return super.getShellStyle() | SWT.RESIZE |
	 // SWT.MAX | SWT.MIN; }
	  /** ������ť����ȷ�ϡ�ȡ����ť /*
	 
	/*
	 * protected void createButtonsForButtonBar(Composite parent) {
	 * createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
	 * true); createButton(parent, IDialogConstants.CANCEL_ID,
	 * IDialogConstants.CANCEL_LABEL, true); }
	 */
}
