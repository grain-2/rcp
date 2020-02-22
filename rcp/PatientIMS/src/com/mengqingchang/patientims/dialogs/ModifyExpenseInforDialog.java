/**
 *@author MengQingChang
 *Copyright 2007-12-24 ,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.model.Expense;

public class ModifyExpenseInforDialog extends TitleAreaDialog {
	private Text expenseExplain;
	private Text expenseName;
	private Text unitPrice;
	private Text number;
	private Expense expense;

	public ModifyExpenseInforDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getShell().setText("修改费用信息");
		// 设置标题
		setTitle("修改病人费用信息");
		// 设置对话框样式效果
		setMessage("修改病人的诊断结果信息", IMessageProvider.INFORMATION);
		return contents;
	}

	// 建立对话框上的内容
	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData layout = new GridData(GridData.FILL_HORIZONTAL);
		comp.setLayoutData(layout);
		new Label(comp, SWT.NONE).setText("费用说明：");
		expenseExplain = new Text(comp, SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		expenseExplain.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("费用名称：");
		expenseName = new Text(comp, SWT.BORDER);
		expenseName.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("单  价：");
		unitPrice = new Text(comp, SWT.BORDER);
		unitPrice.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("数  量：");
		number = new Text(comp, SWT.BORDER);
		number.setLayoutData(layoutData);
		return comp;
	}

	protected void buttonPressed(int buttonId) {
		 
		if (IDialogConstants.OK_ID == buttonId) {
			String re = expenseExplain.getText();
			String en =expenseName.getText();
			String up =unitPrice.getText();
			String nu =number.getText();
	 		if (re == null ||re.equals("")) {
				setErrorMessage("请输入费用说明");
				return ;
			}
			if (en == null || en.equals("")) {
				setErrorMessage("请输入费用名称");
				return ;
			}
			if (up == null ||up .equals("")) {
				setErrorMessage("请输入单价");
				return ;
			}
			if (nu == null || nu.equals("")) {
				setErrorMessage("请输入数量");
				return ;
			}
			 getValue(expense);
 
		}
		okPressed();
		// 单击Cancel按钮执行以下操作
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	private void getValue(Expense expense) {
		// 获得界面文本信息，并植入相应的实体属性方法中。
		String re = expenseExplain.getText();
		String en = expenseName.getText();
		String up = unitPrice.getText();
		String nu = number.getText();
		expense.setExpenseIllustrate(re);
		expense.setExpenseName(en);
		float unp = Float.parseFloat(up);
		expense.setUnitPrice(unp);
		int numb = Integer.valueOf(nu);
		expense.setNumber(numb);
		float sum = unp * numb;
		expense.setOccurExpense(sum);
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX | SWT.MIN;
	}

}
