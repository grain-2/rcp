/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorActionBarContributor;

public class MyEditorContributor extends EditorActionBarContributor {
	private Action toobarAction;

	public MyEditorContributor() {
		makeActions();
	}

	public void makeActions() {
		toobarAction = new Action() {
			// 在run方法中添加具体操作
			public void run() {
			}
		};
		// 添加提示性标签文字
		toobarAction.setToolTipText("工具栏按钮操作");
		// 添加工具栏按钮图标
		toobarAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJS_TASK_TSK));
	}

	// 添加工作台菜单方法
	public void contributeToMenu(IMenuManager menuManager) {
	}

	// 工作台工具栏操作
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// 设置分割符
		toolBarManager.add(new Separator());
		// 添加工具栏按钮
		toolBarManager.add(toobarAction);
	}

}
