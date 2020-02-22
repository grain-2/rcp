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
		// 把集合转化为数组返回
		return ((List) inputElement).toArray();
	}
    //-------------------------以下方法空实现---------------------------------------
	public void dispose() {
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}


}
