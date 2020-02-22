/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TreeViewerLabelProvider implements ILabelProvider {

	public TreeViewerLabelProvider() {
		// TODO 自动生成构造函数存根
	}

	// 设置树结点图标
	public Image getImage(Object element) {
		// 系统自带定义图标
		String image1 = ISharedImages.IMG_OBJ_FOLDER;
		String image2 = ISharedImages.IMG_OBJ_FILE;
		String image3 = ISharedImages.IMG_DEF_VIEW;
		// 获取每个树的节点名称
		String string = ((EntityElement) element).getName();
		// 为一级层次（根）节点设置图标
		if (string.equals("员工管理") || string.equals("产品管理"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image1);
		// 为二级层次节点设置图标
		if (string.equals("员工档案") || string.equals("员工薪资")
				|| string.equals("员工绩效") || string.equals("产品分类")
				|| string.equals("产品报价"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image2);
		// 为三级层次节点设置图标
		if (string.equals("传统网站") || string.equals("短信网址")
				|| string.equals("WAP网站"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image3);
		else
			return null;
	}

	// 返回给定节点的文本
	public String getText(Object element) {
		// TODO 自动生成方法存根
		ITreeElement treeElement = (ITreeElement) element;
		return treeElement.getName();
		// return ((TreeElement)element).getName();
	}

	// ------------------------以下方法空实现-----------------------------

	public void addListener(ILabelProviderListener listener) {
		// TODO 自动生成方法存根
	}

	public void dispose() {
		// TODO 自动生成方法存根
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO 自动生成方法存根
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO 自动生成方法存根
	}

}
