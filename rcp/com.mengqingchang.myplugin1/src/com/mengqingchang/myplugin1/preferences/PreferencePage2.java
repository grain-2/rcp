/**
 *@author MengQingChang
 *Copyright 2007-11-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.mengqingchang.myplugin1.Activator;

/**
 * @author MengQingChang
 * 
 */
public class PreferencePage2 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	// 设置首选项字段编辑器的键值
	public static final String P_PATH = "pathPreference";

	public static final String P_BOOLEAN = "booleanPreference";

	public static final String P_CHOICE = "choicePreference";

	public static final String P_STRING = "stringPreference";

	public PreferencePage2() {
		super(GRID);
		// 设置首选项保存对象
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}

	/**
	 * @param style
	 */
	public PreferencePage2(int style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param style
	 */
	public PreferencePage2(String title, int style) {
		super(title, style);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param image
	 * @param style
	 */
	public PreferencePage2(String title, ImageDescriptor image, int style) {
		super(title, image, style);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	// 建立字段编辑器
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		// 添加路径字段编辑器
		addField(new DirectoryFieldEditor(P_PATH, "&Directory preference:",
				getFieldEditorParent()));
		// 添加布尔性字段编辑器
		addField(new BooleanFieldEditor(P_BOOLEAN,
				"&An example of a boolean preference", getFieldEditorParent()));
		// 添加单选组按钮字段编辑器
		addField(new RadioGroupFieldEditor(P_CHOICE,
				"An example of a multiple-choice preference", 1,
				new String[][] { { "&Choice 1", "choice1" },
						{ "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		// 添加字串字段编辑器
		addField(new StringFieldEditor(P_STRING, "A &text preference:",
				getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

}
