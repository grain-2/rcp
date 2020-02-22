/**
 *@author MengQingChang
 *Copyright 2007-12-21 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.mengqingchang.patientims.model.Doctor;

public class LoginDialog extends TitleAreaDialog {

	private Text userName;
	private Text passWord;
	private Doctor doctor;

	public LoginDialog(Shell parentshell) {
		super(parentshell);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// ���öԻ������
		newShell.setText("�û���¼");
		// ���öԻ���С
		newShell.setSize(500, 200);
		// ���öԻ���λ��
		newShell.setLocation(260, 260);
	}

	// �����Ի����ϵı��⼰��Ϣ��ʾ
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// ���ñ���
		setTitle("��ӵ�¼��Ϣ");
		// ������Ϣ��ʾ
		setMessage("ע���ı�����Ϣ����Ϊ��", IMessageProvider.INFORMATION);
		return contents;
	}

	// ���öԻ�����������
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(2, false));
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("�û�����");
		userName = new Text(composite, SWT.BORDER);
		userName.setLayoutData(layoutData);
		new Label(composite, SWT.NONE).setText("��  �룺");
		passWord = new Text(composite, SWT.BORDER);
		passWord.setEchoChar('*');
		passWord.setLayoutData(layoutData);
		return composite;
	}

	// ������ťִ�еĲ���
	protected void buttonPressed(int buttonId) {

		// ����OK��ťִ�����²���
		if (IDialogConstants.OK_ID == buttonId) {
			// ��֤������Ϣ�ĺϷ��ԣ�
			if (!checkValue())
				return;
			getValue(doctor);
		}
		okPressed();
		// ����Cancel��ťִ�����²���
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	// ���������ݽ�����֤�����Ϸ�����false
	private boolean checkValue() {
		String un = userName.getText();
		String pw = passWord.getText();

		if (pw == null || pw.equals("") || un == null || pw.equals("")) {
			setErrorMessage("�û��������벻��Ϊ��");
			return false;
		}
		return true;
	}

	// ��öԻ������������Ϣ������Ϣֲ��Doctor��������
	private void getValue(Doctor doctor) {
		String un = userName.getText();
		doctor.setUserName(un);
		String pw = passWord.getText();
		doctor.setPassWord(pw);
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * ��SWT.RESIZE��SWT.MAX��SWT.MIN�ֱ����ô���Ϊ���Ա��С�����ڿ��� �󻯡���С��
	 */

	/**
	 * protected int getShellStyle() { return super.getShellStyle() | SWT.RESIZE |
	 * SWT.MAX | SWT.MIN; }
	 */
	/***************************************************************************
	 * ������ť����ȷ�ϡ�ȡ����ť /
	 */
	/*
	 * protected void createButtonsForButtonBar(Composite parent) {
	 * createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
	 * true); createButton(parent, IDialogConstants.CANCEL_ID,
	 * IDialogConstants.CANCEL_LABEL, true); }
	 */
}
