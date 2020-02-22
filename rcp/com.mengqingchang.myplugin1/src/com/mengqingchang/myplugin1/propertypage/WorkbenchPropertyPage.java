/**
 *@author MengQingChang
 *Copyright 2007-11-9,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.propertypage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

public class WorkbenchPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage, ModifyListener {
	private Button radio1;
	private Button radio2;
	private Label label;
	private Text text;
	// 定义默认值
	private static final boolean checkDefalut = true;
	private static final String textDefalut = "10";

	// 定义属性面板
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// 设置面板采用网格式布局
		composite.setLayout(new GridLayout(1, true));
		radio1 = new Button(composite, SWT.RADIO);
		radio1.setText("&radio1");
		radio2 = new Button(composite, SWT.RADIO);
		radio2.setText("&radio2");
		radio2.setSelection(checkDefalut);
		label = new Label(composite, SWT.NONE);
		label.setText("输入数值：");
		text = new Text(composite, SWT.BORDER);
		text.setText(textDefalut);
		// 添加事件监听
		text.addModifyListener(this);
		return composite;
	}

	// 实现ModifyListener接口，验证文本输入
	public void modifyText(ModifyEvent e) {
		String str = null;
		if (text.getText().trim().length() == 0) {
			str = "输入值不能为空!!";
		}
		// 设置错误信息
		setErrorMessage(str);
		// 设置有效性
		setValid(str == null);
		// 应用按钮状态
		getApplyButton().setEnabled(str == null);

	}

	// 设置默认值
	protected void performDefaults() {
		radio2.setSelection(checkDefalut);
		text.setText(textDefalut);
	}

	// 应用按钮方法
	protected void performApply() {

	}

	// 确定按钮方法
	public boolean performOk() {

		return true;
	}
}
