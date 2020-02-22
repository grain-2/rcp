/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.navigatorTreeViewer;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.mengqingchang.patientims.navigator.model.ITreeElement;
import com.mengqingchang.patientims.navigator.model.NavigatorEntityElement;

public class TreeViewerLabelProvider implements ILabelProvider {

	public TreeViewerLabelProvider() {
		// TODO 自动生成构造函数存根
	}

	// 设置树结点图标
	public Image getImage(Object element) {
		// 系统自带定义图标
		String image1 = ISharedImages.IMG_OBJ_FOLDER;
		String image2 = ISharedImages.IMG_OBJ_FILE;

		// 获取每个树的节点名称
		String string = ((NavigatorEntityElement) element).getName();
		// 为一级层次（根）节点设置图标
		if (string.equals("住院管理") || string.equals("费用管理"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image1);
		// 为二级层次节点设置图标
		if (string.equals("病人档案") || string.equals("诊断信息")
				|| string.equals("费用信息") || string.equals("综合费管理")
				|| string.equals("信息查询"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image2);
		else
			return null;
	}

	// 返回给定节点的文本
	public String getText(Object element) {
		// TODO 自动生成方法存根
		ITreeElement treeElement = (ITreeElement) element;
		return treeElement.getName();

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
