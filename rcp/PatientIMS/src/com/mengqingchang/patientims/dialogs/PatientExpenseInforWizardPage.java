/**
 *@author MengQingChang
 *Copyright 2007-12-24 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PatientExpenseInforWizardPage extends WizardPage implements
		ModifyListener {
	private Text expenseExplain;
	private Text expenseName;
	private Text unitPrice;
	private Text number;

	protected PatientExpenseInforWizardPage() {
		super("");
		setTitle("添加费用信息");
		setMessage("注意：请正确填写如下病人信息！！！", IMessageProvider.INFORMATION);
	}

	// 创建界面内容
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		new Label(comp, SWT.NONE).setText("费用说明：");
		expenseExplain = new Text(comp, SWT.BORDER);
		expenseExplain.addModifyListener(this);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		expenseExplain.setLayoutData(layoutData);

		new Label(comp, SWT.NONE).setText("费用名称：");
		expenseName = new Text(comp, SWT.BORDER);
		expenseName.setLayoutData(layoutData);
		expenseName.addModifyListener(this);

		new Label(comp, SWT.NONE).setText("单价：");
		unitPrice = new Text(comp, SWT.BORDER);
		unitPrice.setLayoutData(layoutData);
		unitPrice.addModifyListener(this);

		new Label(comp, SWT.NONE).setText("数量：");
		number = new Text(comp, SWT.BORDER);
		number.setLayoutData(layoutData);
		number.addModifyListener(this);
		this.setControl(comp);
	}

	// 获取对话框中文本信息
	public String getExpenseExplain() {
		return expenseExplain.getText();
	}

	public String getExpenseName() {
		return expenseName.getText();
	}

	public float getUnpice() {
		String up = unitPrice.getText();
		return Float.parseFloat(up);
	}

	public int getNumber() {
		String nu = number.getText();
		return Integer.valueOf(nu);
	}

	// 当文本修改时，监听合法性
	public void modifyText(ModifyEvent e) {
		if (expenseExplain.getText().length() == 0) {
			setMessage("注意：请输入费用说明！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (expenseName.getText().length() == 0) {
			setMessage("注意：请输入费用名称！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (unitPrice.getText().length() == 0) {
			setMessage("注意：请输入单价！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		if (number.getText().length() == 0) {
			setMessage("注意：请输入数量！！！！", IMessageProvider.WARNING);
			setPageComplete(false);
			return;
		}
		setMessage(null);
		setPageComplete(true);
	}

}
