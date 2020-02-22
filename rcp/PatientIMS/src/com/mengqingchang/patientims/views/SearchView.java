/**
 *@author MengQingChang
 *Copyright 2007-12-10 2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import com.mengqingchang.patientims.model.Department;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.model.SickBed;
import com.mengqingchang.patientims.model.SickRoom;
import com.mengqingchang.patients.createcombo.CreateCombo;

public class SearchView extends ViewPart {
	private Combo combDepar;
	private Combo combSickRoom;
	private Combo combSickBed;
	private Combo combPatientId;
	private Combo combDep;
	private Combo combSickR;
	private Combo combSickB;
	private Combo combPId;

	public void createPartControl(Composite parent) {
		Composite com = new Composite(parent, SWT.BORDER);
		com.setLayout(new GridLayout(4, false));
		TabFolder tabFolder = new TabFolder(com, SWT.NONE);
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		grid.horizontalSpan = 3;
		grid.verticalSpan = 2;
		tabFolder.setLayoutData(grid);
		TabItem tabItem1 = new TabItem(tabFolder, SWT.NONE);
		tabItem1.setText("查询病人信息");
		// 调用自定义方法，为"查询病人信息"选项卡添加内容
		createTabFolderContent1(tabFolder, tabItem1);
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("查询费用信息");
		// 调用自定义方法，为"查询费用信息"选项卡添加内容
		createTabFolderContent2(tabFolder, tabItem2);
	}

	// 自定义方法，为"查询病人信息"选项卡创建内容
	private void createTabFolderContent1(TabFolder tabFolder, TabItem tabItem1) {
		Composite comp1 = new Composite(tabFolder, SWT.BORDER);
		tabItem1.setControl(comp1);
		comp1.setLayout(new GridLayout(4, false));
		Group group1 = new Group(comp1, SWT.NONE);
		group1.setText("按床位查询");
		GridData grid1 = new GridData(GridData.FILL_HORIZONTAL);
		grid1.horizontalSpan = 4;
		grid1.verticalSpan = 4;
		group1.setLayoutData(grid1);
		group1.setLayout(new GridLayout(4, false));
		{
			Label labelDepar = new Label(group1, SWT.NONE);
			labelDepar.setText("选择科室：");
			labelDepar.setLayoutData(grid1);
			combDepar = CreateCombo.createAllDeparCombo(group1, SWT.NONE);
			GridData gridCombo = new GridData(GridData.FILL_HORIZONTAL);
			gridCombo.horizontalSpan = 4;
			combDepar.setLayoutData(gridCombo);
			Label labelSickRoom = new Label(group1, SWT.NONE);
			labelSickRoom.setText("选择病房：");
			labelSickRoom.setLayoutData(grid1);
			combSickRoom = CreateCombo.createAllSickRoomCombo(group1, SWT.NONE);
			combSickRoom.setLayoutData(gridCombo);
			Label labelSickBed = new Label(group1, SWT.NONE);
			labelSickBed.setText("选择病床号：");
			labelSickBed.setLayoutData(grid1);
			combSickBed = CreateCombo.createAllSickBedCombo(group1, SWT.NONE);
			combSickBed.setLayoutData(gridCombo);
			Button button = new Button(group1, SWT.NONE);
			button.setText("查询病人基本信息");
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			gridButton.horizontalSpan = 4;
			gridButton.heightHint = 26;
			button.setLayoutData(gridButton);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 获得下拉框文本
					String de = combDepar.getText();
					String sr = combSickRoom.getText();
					String sb = combSickBed.getText();
					// 验证下拉框不能为空
					if (de == null || de.equals("") || sr == null
							|| sr.equals("") || sb == null || sb.equals("")) {
						MessageDialog.openInformation(Display.getDefault()
								.getShells()[0], "信息提示", "失败信息" + '\n' + '\n'
								+ "注意：下拉框不能为空，请选择内容！！！！.......");
					} else {
						// 将获取的下拉框数据，植入到实体属性中
						Department deparment = new Department();
						SickRoom sickRoom = new SickRoom();
						SickBed sickBed = new SickBed();
						deparment.setDepartment(de);
						sickRoom.setSickRoomId(Integer.valueOf(sr));
						sickBed.setSickBedId(Integer.valueOf(sb));
						IWorkbenchPage workbenchPage = getViewSite().getPage();
						String viewId = "patientims.views.SearchPatientInforView";
						try {
							// 打开"病人信息"视图
							SearchPatienInforView view = (SearchPatienInforView) workbenchPage
									.showView(viewId);
							/**
							 * 将实体对象(科室对象、病房对象、床位对象）
							 * 传到病人信息视图类中。
							 */
							view.setSearchInfo(deparment, sickRoom, sickBed);
						} catch (PartInitException e1) {
							e1.printStackTrace();
						}

					}
				}
			});
		}
		Group group2 = new Group(comp1, SWT.NONE);
		group2.setText("按住院号查询");
		GridData grid2 = new GridData(GridData.FILL_HORIZONTAL);
		grid2.horizontalSpan = 4;
		grid2.verticalSpan = 4;
		group2.setLayoutData(grid2);
		group2.setLayout(new GridLayout(4, false));
		{
			Label labelPatientID = new Label(group2, SWT.NONE);
			labelPatientID.setText("住院号：");
			labelPatientID.setLayoutData(grid2);
			combPatientId = CreateCombo.createPatientIdCombo(group2, SWT.NONE);
			GridData gridText = new GridData(GridData.FILL_HORIZONTAL);
			gridText.horizontalSpan = 4;
			gridText.heightHint = 15;
			combPatientId.setLayoutData(gridText);
			Button button = new Button(group2, SWT.NONE);
			button.setText("查询病人基本信息");
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			gridButton.horizontalSpan = 4;
			gridButton.heightHint = 26;
			button.setLayoutData(gridButton);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 获得病人ID下拉框文本值
					String str = combPatientId.getText();
					// 控制下拉框不能为空
					if (str == null || str.equals("")) {
						MessageDialog.openInformation(Display.getDefault()
								.getShells()[0], "信息提示", "失败信息" + '\n' + '\n'
								+ "注意：住院号不能为空，请输入住院号！！！！.......");
					} else {
						// 将获取的下拉框数据，植入到实体属性中
						Patient patient = new Patient();
						patient.setId(Long.valueOf(str));
						IWorkbenchPage workbenchPage = getViewSite().getPage();
						String viewId = "patientims.views.SearchPatientInforView";
						try {
							// 打开"病人信息"视图
							SearchPatienInforView view = (SearchPatienInforView) workbenchPage
									.showView(viewId);
							// 将实体对象(病人对象）传到病人信息视图类中。
							view.setPatientInfor(patient);
						} catch (PartInitException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
	}
	// 自定义方法，为"查询费用信息"选项卡创建内容
	private void createTabFolderContent2(TabFolder tabFolder, TabItem tabItem2) {
		Composite comp1 = new Composite(tabFolder, SWT.BORDER);
		tabItem2.setControl(comp1);
		comp1.setLayout(new GridLayout(4, false));
		Group group1 = new Group(comp1, SWT.NONE);
		group1.setText("按床位查询");
		GridData grid1 = new GridData(GridData.FILL_HORIZONTAL);
		grid1.horizontalSpan = 4;
		grid1.verticalSpan = 4;
		group1.setLayoutData(grid1);
		group1.setLayout(new GridLayout(4, false));
		{
			Label labelDepar = new Label(group1, SWT.NONE);
			labelDepar.setText("选择科室：");
			labelDepar.setLayoutData(grid1);
			combDep = CreateCombo.createAllDeparCombo(group1, SWT.NONE);
			GridData gridCombo = new GridData(GridData.FILL_HORIZONTAL);
			gridCombo.horizontalSpan = 4;
			combDep.setLayoutData(gridCombo);
			Label labelSickRoom = new Label(group1, SWT.NONE);
			labelSickRoom.setText("选择病房：");
			labelSickRoom.setLayoutData(grid1);
			combSickR = CreateCombo.createAllSickRoomCombo(group1, SWT.NONE);
			combSickR.setLayoutData(gridCombo);
			Label labelSickBed = new Label(group1, SWT.NONE);
			labelSickBed.setText("选择病床号：");
			labelSickBed.setLayoutData(grid1);
			combSickB = CreateCombo.createAllSickBedCombo(group1, SWT.NONE);
			combSickB.setLayoutData(gridCombo);
			Button button = new Button(group1, SWT.NONE);
			button.setText("查询病人费用信息");
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			gridButton.horizontalSpan = 4;
			gridButton.heightHint = 25;
			button.setLayoutData(gridButton);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 获得下拉框文本
					String de = combDep.getText();
					String sr = combSickR.getText();
					String sb = combSickB.getText();
					// 控制下拉框文本不能为空
					if (de == null || de.equals("") || sr == null
							|| sr.equals("") || sb == null || sb.equals("")) {
						MessageDialog.openInformation(Display.getDefault()
								.getShells()[0], "信息提示", "失败信息" + '\n' + '\n'
								+ "注意：下拉框不能为空，请选择内容！！！！.......");
					} else {
						// //将获取的下拉框数据，植入到实体属性中
						Department deparment = new Department();
						SickRoom sickRoom = new SickRoom();
						SickBed sickBed = new SickBed();
						deparment.setDepartment(de);
						sickRoom.setSickRoomId(Integer.valueOf(sr));
						sickBed.setSickBedId(Integer.valueOf(sb));
						IWorkbenchPage workbenchPage = getViewSite().getPage();
						String viewId = "patientims.views.SearchPatientExpenseInforView";
						try {// 打开费用信息视图
							SearchPatientExpenseInfoView view = (SearchPatientExpenseInfoView) workbenchPage
									.showView(viewId);
							/**
							 * 将实体对象(科室对象、病房对象、床位对象）
							 * 传到费用信息类中。							
							 */
							view.setSearchInfo(deparment, sickRoom, sickBed);
						} catch (PartInitException e1) {

							e1.printStackTrace();
						}
					}
				}
			});
		}
		Group group2 = new Group(comp1, SWT.NONE);
		group2.setText("按住院号查询");
		GridData grid2 = new GridData(GridData.FILL_HORIZONTAL);
		grid2.horizontalSpan = 4;
		grid2.verticalSpan = 4;
		group2.setLayoutData(grid2);
		group2.setLayout(new GridLayout(4, false));
		{
			Label labelPatientID = new Label(group2, SWT.NONE);
			labelPatientID.setText("住院号：");
			labelPatientID.setLayoutData(grid2);
			combPId = CreateCombo.createPatientIdCombo(group2, SWT.NONE);
			GridData gridText = new GridData(GridData.FILL_HORIZONTAL);
			gridText.horizontalSpan = 4;
			gridText.heightHint = 15;
			combPId.setLayoutData(gridText);
			Button button = new Button(group2, SWT.NONE);
			button.setText("查询病人费用信息");
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			gridButton.horizontalSpan = 4;
			gridButton.heightHint = 26;
			button.setLayoutData(gridButton);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 获得病人ID下拉框文本
					String str = combPId.getText();
					// 控制下拉框不能为空
					if (str == null || str.equals("")) {
						MessageDialog.openInformation(Display.getDefault()
								.getShells()[0], "信息提示", "失败信息" + '\n' + '\n'
								+ "注意：住院号不能为空，请输入住院号！！！！.......");
					} else {
						// 将获取的下拉框数据，植入到实体属性中
						Patient patient = new Patient();
						patient.setId(Long.valueOf(str));
						IWorkbenchPage workbenchPage = getViewSite().getPage();
						String viewId = "patientims.views.SearchPatientExpenseInforView";
						try { // 打开费用信息视图
							SearchPatientExpenseInfoView view = (SearchPatientExpenseInfoView) workbenchPage
									.showView(viewId);
							// 将实体对象(病人对象）传到费用信息视图类中。
							view.setPatientIdInfor(patient);
						} catch (PartInitException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
