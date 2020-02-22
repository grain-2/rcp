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
		// TODO �Զ����ɹ��캯�����
	}

	// ���������ͼ��
	public Image getImage(Object element) {
		// ϵͳ�Դ�����ͼ��
		String image1 = ISharedImages.IMG_OBJ_FOLDER;
		String image2 = ISharedImages.IMG_OBJ_FILE;
		String image3 = ISharedImages.IMG_DEF_VIEW;
		// ��ȡÿ�����Ľڵ�����
		String string = ((EntityElement) element).getName();
		// Ϊһ����Σ������ڵ�����ͼ��
		if (string.equals("Ա������") || string.equals("��Ʒ����"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image1);
		// Ϊ������νڵ�����ͼ��
		if (string.equals("Ա������") || string.equals("Ա��н��")
				|| string.equals("Ա����Ч") || string.equals("��Ʒ����")
				|| string.equals("��Ʒ����"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image2);
		// Ϊ������νڵ�����ͼ��
		if (string.equals("��ͳ��վ") || string.equals("������ַ")
				|| string.equals("WAP��վ"))
			return PlatformUI.getWorkbench().getSharedImages().getImage(image3);
		else
			return null;
	}

	// ���ظ����ڵ���ı�
	public String getText(Object element) {
		// TODO �Զ����ɷ������
		ITreeElement treeElement = (ITreeElement) element;
		return treeElement.getName();
		// return ((TreeElement)element).getName();
	}

	// ------------------------���·�����ʵ��-----------------------------

	public void addListener(ILabelProviderListener listener) {
		// TODO �Զ����ɷ������
	}

	public void dispose() {
		// TODO �Զ����ɷ������
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO �Զ����ɷ������
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO �Զ����ɷ������
	}

}
