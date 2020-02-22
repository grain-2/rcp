/**
 *@author MengQingChang
 *Copyright 2007-12-21 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PatientDiagnoseInforWizardPage extends WizardPage implements
ModifyListener {
	private Text result;
	private Text explain;
	private Label labelE;

	protected PatientDiagnoseInforWizardPage() {
		super("");
		setTitle("��������Ϣ");
		setMessage("ע�⣺����ȷ��д�����Ϣ������", IMessageProvider.INFORMATION);
	}

	//�����Ի����ϵ�����
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("��Ͻ����");
		result = new Text(comp, SWT.BORDER);
		//�����޸ļ�����
		result.addModifyListener(this);
		GridData layoutRs = new GridData(GridData.FILL_HORIZONTAL);
		result.setLayoutData(layoutRs);

		labelE = new Label(comp, SWT.NONE);
		labelE.setText("���˵����");
		GridData layoutE = new GridData();
		layoutE.horizontalSpan = 2;
		labelE.setLayoutData(layoutE);
		explain = new Text(comp, SWT.BORDER);
		//�����޸ļ�����
		explain.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.horizontalSpan = 2;
		explain.setLayoutData(layoutData);
		this.setControl(comp);
	}
	//��ȡ��Ϣ
	public String getResult(){
    	return result.getText();
    }
	public String getExplain(){
    	return explain.getText();
    }
	//���ı��޸�ʱ�������޸ĺϷ��ԡ�
	 public void modifyText(ModifyEvent e) {
		if (result.getText().length() == 0) {
			setMessage("ע�⣺�����벡����Ͻ����������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (explain.getText().length() == 0) {
			setMessage("ע�⣺���������˵����������", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);
		
	}

}
