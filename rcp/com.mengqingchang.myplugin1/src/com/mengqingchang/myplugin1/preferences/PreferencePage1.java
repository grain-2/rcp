/**
 *@author MengQingChang
 *Copyright 2007-11-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.mengqingchang.myplugin1.Activator;

public class PreferencePage1 extends PreferencePage implements
		IWorkbenchPreferencePage {
	// ���尴ť����
	private Button check1;
	private Button check2;
	private Button radio1;
	private Button radio2;
	// Ϊ�ĸ���ť���ü�ֵ
	private static final Boolean One = true;
	private static final String Two = "two";
	private static final Boolean Three = true;
	private static final String Four = "four";
	// ����IPreferenceStore����
	private IPreferenceStore preferenceStore;

	/**
	 * BooleanFieldEditor editor;
	 */
	// ���췽��
	public PreferencePage1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 */

	public PreferencePage1(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param image
	 */
	public PreferencePage1(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	// ��������ؼ�
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		/*
		 * editor=new BooleanFieldEditor("boolean","boolean",parent);
		 * editor.setPreferencePage(this);
		 * editor.setPreferenceStore(getPreferenceStore()); editor.load();
		 */
		Composite composite = new Composite(parent, SWT.NONE);
		// ��������������ʽ����
		composite.setLayout(new GridLayout(1, true));
		// �����ѡ��洢
		preferenceStore = getPreferenceStore();
		// ���帴ѡ��ť
		check1 = new Button(composite, SWT.CHECK);
		check1.setText("�ں�̨����");
		// ���ո����ļ�ֵ���ص�ǰboolean�͵���ѡ��ֵ����������check1�ĵ�ǰѡ��

		check1.setSelection(One);

		check2 = new Button(composite, SWT.CHECK);
		check2.setText("�򿪲�������");
		check2.setSelection(preferenceStore.getBoolean(Two));
		// ����һ�������
		Group group = new Group(composite, SWT.NONE);
		// ���÷�������
		group.setText("�򿪷�ʽ");
		// ����Ϊˮƽ����
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// �����������Ϊ�����Ͳ���
		group.setLayout(new GridLayout());
		radio1 = new Button(group, SWT.RADIO);
		radio1.setText("������");
		radio1.setSelection(Three);

		radio2 = new Button(group, SWT.RADIO);
		radio2.setText("˫����");
		radio2.setSelection(preferenceStore.getBoolean(Four));

		return composite;

 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	// Ϊ�����Ĺ���̨��ʼ����ѡҳ
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	// ���ûָ�Ĭ��ֵ��ť
	protected void performDefaults() {
		preferenceStore = getPreferenceStore();
		check1.setSelection(One);
		check2.setSelection(preferenceStore.getDefaultBoolean(Two));
		radio1.setSelection(Three);
		radio2.setSelection(preferenceStore.getDefaultBoolean(Four));

		/*
		 * editor.loadDefault(); super.performDefaults();
		 */

	}

	// ����Ӧ�ð�ť
	protected void performApply() {
		if (getControl() == null) {
			return;
		}
	}

	// ����ȷ����ť
	public boolean performOk() {
		// editor.store();
		performApply();
		return true;
	}
}
