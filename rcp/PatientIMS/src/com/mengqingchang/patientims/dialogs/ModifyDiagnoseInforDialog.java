/**
 *@author MengQingChang
 *Copyright 2007-12-22 ,MenqQingChang all rights reserved.
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.mengqingchang.patientims.model.Diagnose;


public class ModifyDiagnoseInforDialog extends TitleAreaDialog {

	private Text result;
	private Text explain;
	private Label labelE;
	private Diagnose diagnose;

	public ModifyDiagnoseInforDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getShell().setText("�޸������Ϣ");
		// ���ñ���
		setTitle("�޸Ĳ��������Ϣ");
		// ���öԻ�����ʽЧ��
		setMessage("�޸Ĳ��˵���Ͻ����Ϣ", IMessageProvider.INFORMATION);
		return contents;
	}

	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData layout = new GridData(GridData.FILL_HORIZONTAL);
		comp.setLayoutData(layout);
		Group group = new Group(comp, SWT.NONE);
		group.setText("�޸�������Ϣ");
		GridData layoutGr = new GridData(GridData.FILL_HORIZONTAL);
		layoutGr.horizontalSpan = 2;
		group.setLayoutData(layoutGr);
		group.setLayout(new GridLayout(2, false));
		new Label(group, SWT.NONE).setText("��Ͻ����");
		result = new Text(group, SWT.BORDER);
		result.setLayoutData(layoutGr);
		labelE = new Label(group, SWT.NONE);
		labelE.setText("���˵����");
		explain = new Text(group, SWT.BORDER);
		explain.setLayoutData(layoutGr);

		return comp;
	}

	protected void buttonPressed(int buttonId) {
		// ����OK��ťִ������Ĳ���
		if (IDialogConstants.OK_ID == buttonId) {
			String re = result.getText();
			String ex = explain.getText();
			if (re == null || re.equals("")) {
				setErrorMessage("��Ͻ������Ϊ��");
				return;
			}
			if (ex == null || ex.equals("")) {
				setErrorMessage("���˵������Ϊ��");
				return;
			}
			getValue(diagnose);

		}
		okPressed();
		// ����Cancel��ťִ�����²���
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	// ��ȡ�Կ��е����ݣ���ֲ����Ӧ��ʵ�����Է����С�
	private void getValue(Diagnose diagnose) {
		String re = result.getText();
		String ex = explain.getText();
		diagnose.setSickName(re);
		diagnose.setTherapeutic(ex);

	}

	public Diagnose getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(Diagnose diagnose) {
		this.diagnose = diagnose;
	}

	/**
	 * ��SWT.RESIZE��SWT.MAX��SWT.MIN�ֱ����ô���Ϊ���Ա��С�����ڿ��� �󻯡���С��
	 */

	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX | SWT.MIN;
	}
}
