/**
 *@author MengQingChang
 *Copyright  2007-11-20,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;

import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;

import org.eclipse.swt.events.*;

public class DropDownAction extends Action {
      
	public DropDownAction(  ) {
		super("DropDown", Action.AS_DROP_DOWN_MENU);
		// 工具栏上提示性标签
		setToolTipText("dropdown menu Action");
		// 设置按钮图标
		 
		ImageDescriptor imgDes = WorkbenchImages
				.getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_HELP_SEARCH);
		setImageDescriptor(imgDes);
		// 设置下拉菜单
		setMenuCreator(new IMenuCreator() {
			public Menu getMenu(Control parent) {
				// 定义菜单
				Menu menu = new Menu(parent);
				// 设置菜单项
				MenuItem item1 = new MenuItem(menu, SWT.NONE);
				// 设置菜单项文本，并为菜单项添键盘加快捷方式
				item1.setText("&FirstItem");
				// item1.setAccelerator(SWT.F1);
				// 添加事件处理
				item1.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						MessageDialog.openInformation(new Shell(Display
								.getDefault()), "DropDown Dialog",
								"This is FirstItem DropDown Messages!");
					}
				});
				MenuItem item2 = new MenuItem(menu, SWT.NONE);
				item2.setText("&SecondItem");
				MenuItem item3 = new MenuItem(menu, SWT.NONE);
				item3.setText("&ThirdItem");
				MenuItem item4 = new MenuItem(menu, SWT.NONE);
				item4.setText("Four&Item");
				return menu;
			}

			public Menu getMenu(Menu parent) {
				return null;
			}

			public void dispose() {

			}
		});

	}

	public void run() {
		 
		 
		MessageDialog.openInformation(new Shell(Display.getDefault()),
				"DropDown Dialog", "DropDown Messages!!");
		 
	}
  
}
