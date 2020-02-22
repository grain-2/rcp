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
		// 调用自定义方法，创建在视图中表格
		createTableViewer(parent);
		// 添加表格内容提供器
		tv.setContentProvider(new SearchViewTableContentProvider());
		// 添加表格标签提供器
		tv.setLabelProvider(new SearchPatientExpenseInforTableProvider());

	}
	// 创建表格
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("ID号");
		tc1.setWidth(50);
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc2.setText("病人姓名");
		tc2.setWidth(80);
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);
		tc3.setText("费用类型");
		tc3.setWidth(80);
		TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		tc4.setText("费用名称");
		tc4.setWidth(100);
		TableColumn tc5 = new TableColumn(table, SWT.LEFT);
		tc5.setText("单价");
		tc5.setWidth(60);
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);
		tc6.setText("数量");
		tc6.setWidth(40);
		TableColumn tc7 = new TableColumn(table, SWT.LEFT);
		tc7.setText("发生费用");
		tc7.setWidth(80);
		TableColumn tc8 = new TableColumn(table, SWT.LEFT);
		tc8.setText("费用发生时间");
		tc8.setWidth(100);
		TableColumn tc9 = new TableColumn(table, SWT.LEFT);
		tc9.setText("医生签字");
		tc9.setWidth(80);
	}
	/**
	 * 接收搜索视图传递的Department、SickRoom、SickBed对象，
	 * 向表格中读入数据库中的数据。
	 */
	public void setSearchInfo(Department department, SickRoom sickRoom,
			SickBed sickBed) {
		tv.setInput(DataBaseOperate.getSearchPatienExpenseInfo(department,
				sickRoom, sickBed));
	}
	/**
	 * 接收搜索视图传递的Patient对象，
	 * 向表格中 读入数据库中的数据。
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
