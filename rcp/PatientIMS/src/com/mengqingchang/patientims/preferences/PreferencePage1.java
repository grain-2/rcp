package com.mengqingchang.patientims.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import com.mengqingchang.patientims.database.DataBaseOperate;

public class PreferencePage1 extends PreferencePage implements
		IWorkbenchPreferencePage, ModifyListener {
	private Label userLabel;
	private Label passWordLabel;
	private Text userName;
	private Text passWord;

	public PreferencePage1(String title, ImageDescriptor image) {
		super(title, image);
	}

	public PreferencePage1() {
		setDescription("���û��ĵ�¼��������޸���ѡ��ҳ");

	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// ��������������ʽ����
		composite.setLayout(new GridLayout(2, false));
		Group group = new Group(composite, SWT.NONE);
		group.setText("�޸��û�����");
		group.setLayout(new GridLayout(2, false));
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.verticalIndent = 15;
		group.setLayoutData(layoutData);
		userLabel = new Label(group, SWT.NONE);
		userLabel.setText("�û�����");
		GridData layoutD = new GridData();
		layoutD.verticalIndent = 15;
		userLabel.setLayoutData(layoutD);
		userName = new Text(group, SWT.BORDER);
		userName.setLayoutData(layoutData);
		passWordLabel = new Label(group, SWT.NONE);
		passWordLabel.setText("��  �룺");
		passWordLabel.setLayoutData(layoutD);
		passWord = new Text(group, SWT.BORDER);
		passWord.setEchoChar('*');
		passWord.setLayoutData(layoutData);
		// ��Ӽ�����
		userName.addModifyListener(this);
		passWord.addModifyListener(this);
		// ����ѡ���"�ָ�"��"Ӧ��"��ť����
		noDefaultAndApplyButton();
		setValid(false);
		return composite;
	}

	// ����ȷ����ť
	public boolean performOk() {
		// �޸��������
		DataBaseOperate.UpdateUserPassWordInfor(userName, passWord);
		return true;
	}

	// �����ı�����ĺϷ���
	public void modifyText(ModifyEvent e) {
		String un = userName.getText();
		String pw = passWord.getText();
		if (un == null || un.equals("")) {
			setErrorMessage("�û�������Ϊ��");
			setValid(false);
		} else if (pw == null || pw.equals("")) {
			setErrorMessage("���벻��Ϊ��");
			setValid(false);
		} else
			setValid(true);

	}

	public void init(IWorkbench workbench) {

	}
}
