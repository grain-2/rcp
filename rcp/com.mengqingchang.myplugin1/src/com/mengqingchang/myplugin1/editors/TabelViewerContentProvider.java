/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TabelViewerContentProvider implements IStructuredContentProvider {

	public TabelViewerContentProvider() {
		// TODO Auto-generated constructor stub
	}

	public Object[] getElements(Object inputElement) {
		// �Ѽ���ת��Ϊ���鷵��
		return ((List) inputElement).toArray();
	}
    //-------------------------���·�����ʵ��---------------------------------------
	public void dispose() {
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}


}
