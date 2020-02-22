/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class EditorOneInput implements IEditorInput {

	public EditorOneInput() {
		// TODO Auto-generated constructor stub
	}

	// 返回编辑器输入是否存在
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	// 返回输入的图像描述
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
		/**
		 * return WorkbenchImages.getImageDescriptor(IWorkbenchGraphicConstants.IMG_
		 * ETOOL_IMPORT_WIZ);
		 */

	}

	// 返回编辑器标题栏名称
	public String getName() {
		// TODO Auto-generated method stub
		return "员工档案";
	}

	// 返回能够用来可以保存编辑器输入状态的对象
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	// 返回编辑器标题栏提示性文字标签
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "员工管理/员工档案";
	}

	// 获得一个编辑器的适配器
	public Object getAdapter(Class  arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
