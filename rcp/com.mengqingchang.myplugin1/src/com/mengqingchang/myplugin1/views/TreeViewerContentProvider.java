/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeViewerContentProvider implements ITreeContentProvider {
	public TreeViewerContentProvider() {
	}

	// ���ظ�����Ԫ�ص���Ԫ��
	public Object[] getChildren(Object parentElement) {
		// TODO �Զ����ɷ������
		ITreeElement treeElement = (ITreeElement) parentElement;
		List list = treeElement.getChildren();
		if (list == null || list.isEmpty())
			return new Object[0];
		else
			return list.toArray();
		// return ((TreeElement)parentElement).getChildren().toArray();
	}

	public Object getParent(Object element) {
		return null;
	}

	// ���ظ���Ԫ�أ��ڵ㣩�Ƿ�����Ԫ��
	public boolean hasChildren(Object element) {
		// TODO �Զ����ɷ������
		ITreeElement treeElement = (ITreeElement) element;
		List list = treeElement.getChildren();
		// �ж��ӽڵ��Ƿ�Ϊ�գ����Ƿ����ӽڵ�
		if (list == null || list.isEmpty())
			return false;
		else
			return true;
		// return (ITreeElement)element).hasChildren();
	}
	// ������Ϊ�趨��Ԫ��ʱ�����ز鿴������ʾ��Ԫ��
	public Object[] getElements(Object inputElement) {
		// TODO �Զ����ɷ������
		if (inputElement instanceof List) {
			List list = (List) inputElement;
			return list.toArray();
		} else {
			// ����һ��������
			return new Object[0];
		}
		// return ((List)inputElement).toArray();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
