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
		getShell().setText("�޸ķ�����Ϣ");
		// ���ñ���
		setTitle("�޸Ĳ��˷�����Ϣ");
		// ���öԻ�����ʽЧ��
		setMessage("�޸Ĳ��˵���Ͻ����Ϣ", IMessageProvider.INFORMATION);
		return contents;
	}

	// �����Ի����ϵ�����
	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData layout = new GridData(GridData.FILL_HORIZONTAL);
		comp.setLayoutData(layout);
		new Label(comp, SWT.NONE).setText("����˵����");
		expenseExplain = new Text(comp, SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		expenseExplain.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("�������ƣ�");
		expenseName = new Text(comp, SWT.BORDER);
		expenseName.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("��  �ۣ�");
		unitPrice = new Text(comp, SWT.BORDER);
		unitPrice.setLayoutData(layoutData);
		new Label(comp, SWT.NONE).setText("��  ����");
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
				setErrorMessage("���������˵��");
				return ;
			}
			if (en == null || en.equals("")) {
				setErrorMessage("�������������");
				return ;
			}
			if (up == null ||up .equals("")) {
				setErrorMessage("�����뵥��");
				return ;
			}
			if (nu == null || nu.equals("")) {
				setErrorMessage("����������");
				return ;
			}
			 getValue(expense);
 
		}
		okPressed();
		// ����Cancel��ťִ�����²���
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	private void getValue(Expense expense) {
		// ��ý����ı���Ϣ����ֲ����Ӧ��ʵ�����Է����С�
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
