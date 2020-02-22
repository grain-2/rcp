/**
 *@author MengQingChang
 *Copyright 2007-12-11 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;
import com.mengqingchang.patientims.views.provider.SearchPatientExpenseInforTableProvider;
import com.mengqingchang.patientims.views.provider.SearchViewTableContentProvider;

public class SearchPatientExpenseInfoView extends ViewPart {
	private TableViewer tv;

	public void createPartControl(Composite parent) {
		// �����Զ��巽������������ͼ�б��
		createTableViewer(parent);
		// ��ӱ�������ṩ��
		tv.setContentProvider(new SearchViewTableContentProvider());
		// ��ӱ���ǩ�ṩ��
		tv.setLabelProvider(new SearchPatientExpenseInforTableProvider());

	}
	// �������
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("ID��");
		tc1.setWidth(50);
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc2.setText("��������");
		tc2.setWidth(80);
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);
		tc3.setText("��������");
		tc3.setWidth(80);
		TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		tc4.setText("��������");
		tc4.setWidth(100);
		TableColumn tc5 = new TableColumn(table, SWT.LEFT);
		tc5.setText("����");
		tc5.setWidth(60);
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);
		tc6.setText("����");
		tc6.setWidth(40);
		TableColumn tc7 = new TableColumn(table, SWT.LEFT);
		tc7.setText("��������");
		tc7.setWidth(80);
		TableColumn tc8 = new TableColumn(table, SWT.LEFT);
		tc8.setText("���÷���ʱ��");
		tc8.setWidth(100);
		TableColumn tc9 = new TableColumn(table, SWT.LEFT);
		tc9.setText("ҽ��ǩ��");
		tc9.setWidth(80);
	}
	/**
	 * ����������ͼ���ݵ�Department��SickRoom��SickBed����
	 * �����ж������ݿ��е����ݡ�
	 */
	public void setSearchInfo(Department department, SickRoom sickRoom,
			SickBed sickBed) {
		tv.setInput(DataBaseOperate.getSearchPatienExpenseInfo(department,
				sickRoom, sickBed));
	}
	/**
	 * ����������ͼ���ݵ�Patient����
	 * ������ �������ݿ��е����ݡ�
	 */
	public void setPatientIdInfor(Patient patient) {
		tv.setInput(DataBaseOperate
				.getPatientIdSearchPatienExpenseInfo(patient));

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
