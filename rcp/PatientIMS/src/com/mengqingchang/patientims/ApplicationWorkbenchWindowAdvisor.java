package com.mengqingchang.patientims;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.util.PrefUtil;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		// ����RCPӦ�ó������
		IPreferenceStore preStore = PrefUtil.getAPIPreferenceStore();
		// ����ѡ���ʽ
		preStore.setValue(
				IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,
				false);
		// ����͸��ͼ��ť��λ��
		preStore.setValue(IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR,
				IWorkbenchPreferenceConstants.TOP_RIGHT);

		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// ���ô��ڴ�С
		configurer.setInitialSize(new Point(800, 600));
		// ����͸��ͼͼ��
		configurer.setShowPerspectiveBar(true);
		// ���ò˵���
		configurer.setShowMenuBar(true);
		// ���ù�����
		configurer.setShowCoolBar(true);
		// ����״̬��
		configurer.setShowStatusLine(true);
		// ���ÿ�����ͼ��
		configurer.setShowFastViewBars(true);
		// ���ô��ڱ���
		configurer.setTitle("Patient Information Management System");
	}
}
