package com.mengqingchang.patientims;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {

		// ������ͼ��IDֵ
		String navigatorViewID = "patientims.views.NaviagtorView";
		String searchViewID = "patientims.views.SearchView";
		String searchPatientInforID = "patientims.views.SearchPatientInforView";
		String searchPatientExpenseInforID = "patientims.views.SearchPatientExpenseInforView";
		String editorArea = layout.getEditorArea();
		// ���Navigator(����)��ͼ
		layout.addView(navigatorViewID, IPageLayout.LEFT, 0.3f, editorArea);
		// ������ͼ���·����� Search����������ͼ��
		IFolderLayout leftBottom = layout.createFolder("left",
				IPageLayout.BOTTOM, 0.40f, navigatorViewID);
		// ���Search(����)��ͼ
		leftBottom.addView(searchViewID);
		/**
		 * ��Ӳ�����Ϣ��ͼ�ͷ�����Ϣ��ͼ�� 
		 * ��ʵ����������ͼ��ͼ�ĵ���Ч����
		 */
		IFolderLayout buttom = layout.createFolder("button",
				IPageLayout.BOTTOM, 0.7f, editorArea);
		buttom.addView(searchPatientInforID);
		buttom.addView(searchPatientExpenseInforID);
		// layout.addView("PatientIMS.view1", IPageLayout.RIGHT, 0.3f,
		// editorArea);

	}
}
