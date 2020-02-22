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
		// ��ò���������ѡ������
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		// ����Ĭ����ѡ��ֵ
		store.setDefault(PreferencePage2.P_BOOLEAN, true);
		store.setDefault(PreferencePage2.P_CHOICE, "choice2");
		store.setDefault(PreferencePage2.P_STRING, "Default value");
	}

}
