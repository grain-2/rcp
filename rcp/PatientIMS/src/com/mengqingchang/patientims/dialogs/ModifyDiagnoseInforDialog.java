/**
 *@author MengQingChang
 *Copyright 2007-12-22 ,MenqQingChang all rights reserved.
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


public class ModifyDiagnoseInforDialog extends TitleAreaDialog {

	private Text result;
	private Text explain;
	private Label labelE;
	private Diagnose diagnose;

	public ModifyDiagnoseInforDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getShell().setText("修改诊断信息");
		// 设置标题
		setTitle("修改病人诊断信息");
		// 设置对话框样式效果
		setMessage("修改病人的诊断结果信息", IMessageProvider.INFORMATION);
		return contents;
	}

	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		GridData layout = new GridData(GridData.FILL_HORIZONTAL);
		comp.setLayoutData(layout);
		Group group = new Group(comp, SWT.NONE);
		group.setText("修改内容信息");
		GridData layoutGr = new GridData(GridData.FILL_HORIZONTAL);
		layoutGr.horizontalSpan = 2;
		group.setLayoutData(layoutGr);
		group.setLayout(new GridLayout(2, false));
		new Label(group, SWT.NONE).setText("诊断结果：");
		result = new Text(group, SWT.BORDER);
		result.setLayoutData(layoutGr);
		labelE = new Label(group, SWT.NONE);
		labelE.setText("诊断说明：");
		explain = new Text(group, SWT.BORDER);
		explain.setLayoutData(layoutGr);

		return comp;
	}

	protected void buttonPressed(int buttonId) {
		// 单击OK按钮执行下面的操作
		if (IDialogConstants.OK_ID == buttonId) {
			String re = result.getText();
			String ex = explain.getText();
			if (re == null || re.equals("")) {
				setErrorMessage("诊断结果不能为空");
				return;
			}
			if (ex == null || ex.equals("")) {
				setErrorMessage("诊断说明不能为空");
				return;
			}
			getValue(diagnose);

		}
		okPressed();
		// 单击Cancel按钮执行以下操作
		if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}

	// 获取对框中的数据，并植入相应的实体属性方法中。
	private void getValue(Diagnose diagnose) {
		String re = result.getText();
		String ex = explain.getText();
		diagnose.setSickName(re);
		diagnose.setTherapeutic(ex);

	}

	public Diagnose getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(Diagnose diagnose) {
		this.diagnose = diagnose;
	}

	/**
	 * 用SWT.RESIZE、SWT.MAX、SWT.MIN分别设置窗口为可以变大小、窗口可最 大化、最小化
	 */

	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX | SWT.MIN;
	}
}
