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
	// 定义按钮对象
	private Button check1;
	private Button check2;
	private Button radio1;
	private Button radio2;
	// 为四个按钮设置键值
	private static final Boolean One = true;
	private static final String Two = "two";
	private static final Boolean Three = true;
	private static final String Four = "four";
	// 定义IPreferenceStore对象
	private IPreferenceStore preferenceStore;

	/**
	 * BooleanFieldEditor editor;
	 */
	// 构造方法
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
	// 创建界面控件
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		/*
		 * editor=new BooleanFieldEditor("boolean","boolean",parent);
		 * editor.setPreferencePage(this);
		 * editor.setPreferenceStore(getPreferenceStore()); editor.load();
		 */
		Composite composite = new Composite(parent, SWT.NONE);
		// 设置面板采用网格式布局
		composite.setLayout(new GridLayout(1, true));
		// 获得首选项存储
		preferenceStore = getPreferenceStore();
		// 定义复选框按钮
		check1 = new Button(composite, SWT.CHECK);
		check1.setText("在后台运行");
		// 按照给定的键值返回当前boolean型的首选项值，用于设置check1的当前选择

		check1.setSelection(One);

		check2 = new Button(composite, SWT.CHECK);
		check2.setText("打开部件设置");
		check2.setSelection(preferenceStore.getBoolean(Two));
		// 定义一个分组框
		Group group = new Group(composite, SWT.NONE);
		// 设置分组框标题
		group.setText("打开方式");
		// 设置为水平充满
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// 将分组框设置为网格型布局
		group.setLayout(new GridLayout());
		radio1 = new Button(group, SWT.RADIO);
		radio1.setText("单击打开");
		radio1.setSelection(Three);

		radio2 = new Button(group, SWT.RADIO);
		radio2.setText("双击打开");
		radio2.setSelection(preferenceStore.getBoolean(Four));

		return composite;

 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	// 为给定的工作台初始化首选页
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	// 设置恢复默认值按钮
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

	// 设置应用按钮
	protected void performApply() {
		if (getControl() == null) {
			return;
		}
	}

	// 设置确定按钮
	public boolean performOk() {
		// editor.store();
		performApply();
		return true;
	}
}
