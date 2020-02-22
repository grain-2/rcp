package com.mengqingchang.patientims;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		// 设置视图的ID值
		String navigatorViewID = "patientims.views.NaviagtorView";
		String searchViewID = "patientims.views.SearchView";
		String searchPatientInforID = "patientims.views.SearchPatientInforView";
		String searchPatientExpenseInforID = "patientims.views.SearchPatientExpenseInforView";
		String editorArea = layout.getEditorArea();
		// 添加Navigator(导航)视图
		layout.addView(navigatorViewID, IPageLayout.LEFT, 0.3f, editorArea);
		// 导航视图的下方放置 Search（搜索）视图。
		IFolderLayout leftBottom = layout.createFolder("left",
				IPageLayout.BOTTOM, 0.40f, navigatorViewID);
		// 添加Search(搜索)视图
		leftBottom.addView(searchViewID);
		/**
		 * 添加病人信息视图和费用信息视图， 
		 * 并实现这两个视图视图的叠加效果。
		 */
		IFolderLayout buttom = layout.createFolder("button",
				IPageLayout.BOTTOM, 0.7f, editorArea);
		buttom.addView(searchPatientInforID);
		buttom.addView(searchPatientExpenseInforID);
		// layout.addView("PatientIMS.view1", IPageLayout.RIGHT, 0.3f,
		// editorArea);

	}
}
