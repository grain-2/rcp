/**
 *@author MengQingChang
 *Copyright 2007-12-14 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PatientBasicInfoWizardPage extends WizardPage implements
		ModifyListener {

	private Text textName;
	private Text textAge;
	private Text textPhone;
	private Text textAddress;
	private Combo comboSex;

	// ���ñ��⼰��ʾ��Ϣ
	protected PatientBasicInfoWizardPage() {
		super("");
		setTitle("��Ӳ��˻�����Ϣ");
		setMessage("ע�⣺����ȷ��д���²�����Ϣ������", IMessageProvider.INFORMATION);
	}

	// ������ҳ����
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("������");
		textName = new Text(comp, SWT.BORDER);
		// ��Ӽ�����
		textName.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textName.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("���䣺");
		textAge = new Text(comp, SWT.BORDER);
		textAge.setLayoutData(layoutData);
		textAge.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("�Ա�");
		comboSex = new Combo(comp, SWT.READ_ONLY);
		comboSex.setItems(new String[] { "��", "Ů" });
		comboSex.setLayoutData(layoutData);
		comboSex.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("�绰��");
		textPhone = new Text(comp, SWT.BORDER);
		textPhone.setLayoutData(layoutData);
		textPhone.addModifyListener(this);
		new Label(comp, SWT.NONE).setText("סַ��");
		textAddress = new Text(comp, SWT.BORDER);
		textAddress.setLayoutData(layoutData);

		textAddress.addModifyListener(this);

		this.setControl(comp);

	}
   // �����Ҫ�ռ�����ҳ��Ϣ
	public String getPatientName() {
		return textName.getText();
	}

	public int getPatientAge() {
		String age = textAge.getText();
		return Integer.valueOf(age);
	}

	public String getPatientSex() {
		int index = comboSex.getSelectionIndex();
		if (index == -1) {
			return "";
		}
		return comboSex.getItem(index);
	}

	public String getPatientPhone() {
		return textPhone.getText();
	}

	public String getPatientAddress() {
		return textAddress.getText();
	}

	@Override
	// ������֤��Ϣ�ĺϷ��ԣ����ı����޸�ʱ������
	public void modifyText(ModifyEvent e) {
		if (textName.getText().length() == 0) {
			setMessage("ע�⣺����������Ϊ�գ�������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textAge.getText().length() == 0) {
			setMessage("ע�⣺�����벡�˵����䣡������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;

		}
		if (comboSex.getText().length() == 0) {
			setMessage("ע�⣺��ѡ���˵��Ա𣡣�����", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textPhone.getText().length() == 0) {
			setMessage("ע�⣺�����벡�˵���ϵ��ʽ��������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (textAddress.getText().length() == 0) {
			setMessage("ע�⣺�����벡�˵ļ�ͥסַ��������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);

	}

}
