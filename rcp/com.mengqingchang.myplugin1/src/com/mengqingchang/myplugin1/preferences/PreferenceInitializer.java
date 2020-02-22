/**
 *@author MengQingChang
 *Copyright 2007-11-7,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.mengqingchang.myplugin1.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		// 获得插件保存的首选项保存对象
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		// 设置默认首选项值
		store.setDefault(PreferencePage2.P_BOOLEAN, true);
		store.setDefault(PreferencePage2.P_CHOICE, "choice2");
		store.setDefault(PreferencePage2.P_STRING, "Default value");
	}

}
