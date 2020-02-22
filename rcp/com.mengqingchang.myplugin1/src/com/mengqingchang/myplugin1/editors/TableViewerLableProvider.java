/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class TableViewerLableProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		StaffEntity se = (StaffEntity) element;
		// ���ֶ�ת��ΪString������
		switch (columnIndex) {
		case 0:
			return "" + se.getID();
		case 1:
			return se.getName();
		case 2:
			return se.getSex() ? "��" : "Ů";
		case 3:
			return "" + se.getAge();
		case 4:
			return "" + se.getPhone();
		case 5:
			return se.getDepartment();
		case 6:
			return se.getRelatPeople();
		case 7:
			return se.getCreateDate().toLocaleString();
		}
		return null;
	}

	// -----------------���·�����ʵ��----------------------------
	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

}
