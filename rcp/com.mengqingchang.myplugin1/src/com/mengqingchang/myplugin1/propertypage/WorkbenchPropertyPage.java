/**
 *@author MengQingChang
 *Copyright 2007-11-9,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.propertypage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

public class WorkbenchPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage, ModifyListener {
	private Button radio1;
	private Button radio2;
	private Label label;
	private Text text;
	// ����Ĭ��ֵ
	private static final boolean checkDefalut = true;
	private static final String textDefalut = "10";

	// �����������
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// ��������������ʽ����
		composite.setLayout(new GridLayout(1, true));
		radio1 = new Button(composite, SWT.RADIO);
		radio1.setText("&radio1");
		radio2 = new Button(composite, SWT.RADIO);
		radio2.setText("&radio2");
		radio2.setSelection(checkDefalut);
		label = new Label(composite, SWT.NONE);
		label.setText("������ֵ��");
		text = new Text(composite, SWT.BORDER);
		text.setText(textDefalut);
		// ����¼�����
		text.addModifyListener(this);
		return composite;
	}

	// ʵ��ModifyListener�ӿڣ���֤�ı�����
	public void modifyText(ModifyEvent e) {
		String str = null;
		if (text.getText().trim().length() == 0) {
			str = "����ֵ����Ϊ��!!";
		}
		// ���ô�����Ϣ
		setErrorMessage(str);
		// ������Ч��
		setValid(str == null);
		// Ӧ�ð�ť״̬
		getApplyButton().setEnabled(str == null);

	}

	// ����Ĭ��ֵ
	protected void performDefaults() {
		radio2.setSelection(checkDefalut);
		text.setText(textDefalut);
	}

	// Ӧ�ð�ť����
	protected void performApply() {

	}

	// ȷ����ť����
	public boolean performOk() {

		return true;
	}
}
