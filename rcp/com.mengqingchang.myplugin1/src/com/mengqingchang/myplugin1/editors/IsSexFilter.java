/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class IsSexFilter extends ViewerFilter {

	public IsSexFilter() {
		// TODO �Զ����ɹ��캯�����
	}
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		StaffEntity ste = (StaffEntity) element;
		return ste.getSex() == true;
	}


}
