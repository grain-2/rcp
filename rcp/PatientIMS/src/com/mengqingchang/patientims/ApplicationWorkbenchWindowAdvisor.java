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
		// 定制RCP应用程序外观
		IPreferenceStore preStore = PrefUtil.getAPIPreferenceStore();
		// 设置选项卡样式
		preStore.setValue(
				IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,
				false);
		// 设置透视图按钮的位置
		preStore.setValue(IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR,
				IWorkbenchPreferenceConstants.TOP_RIGHT);

		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// 设置窗口大小
		configurer.setInitialSize(new Point(800, 600));
		// 设置透视图图栏
		configurer.setShowPerspectiveBar(true);
		// 设置菜单栏
		configurer.setShowMenuBar(true);
		// 设置工具栏
		configurer.setShowCoolBar(true);
		// 设置状态线
		configurer.setShowStatusLine(true);
		// 设置快速视图栏
		configurer.setShowFastViewBars(true);
		// 设置窗口标题
		configurer.setTitle("Patient Information Management System");
	}
}
