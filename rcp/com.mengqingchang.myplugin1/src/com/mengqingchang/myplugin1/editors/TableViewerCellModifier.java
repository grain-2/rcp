/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TableItem;

public class TableViewerCellModifier implements ICellModifier {

	private Viewer viewer;

	public TableViewerCellModifier(Viewer viewer) {
		this.viewer = viewer;
	}

	// ������Ԫ�أ�����¼���������Ƿ��ܱ��޸�
	public boolean canModify(Object element, String property) {

		return true;
	}

	// ���ر���¼�������޸ĵ�ֵ��null����Ҫ�޸�
	public Object getValue(Object element, String property) {
		StaffEntity sfe = (StaffEntity) element;
		if (property.equals("ID"))
			return null;
		else if (property.equals("NAME"))
			return null;
		else if (property.equals("MALE"))
			return sfe.getSex() ? new Boolean(true) : new Boolean(false);
		else if (property.equals("AGE"))
			return sfe.getAge() + "";
		else if (property.equals("PHONE"))
			return null;
		else if (property.equals("DEPART"))
			return new Integer(0);
		else if (property.equals("RELAT"))
			return null;
		else if (property.equals("DATETIME"))
			return null;

		else
			return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	    *   �޸ı���¼�����Ե�ֵ��ֻ��"MALE"��"AGE"��"DEPART"���Խ������޸��趨 (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {
		TableItem tableItem = (TableItem) element;
		StaffEntity sef = (StaffEntity) tableItem.getData();
		// �ж�Ҫ�޸ĵĵ�Ԫ���Ƿ�Ϊ"�Ա�"��
		if (property.equals("MALE"))
			sef.setSex(((Boolean) value).booleanValue());
		// �ж�Ҫ�޸ĵĵ�Ԫ���Ƿ�Ϊ"����"��
		else if (property.equals("AGE"))
			sef.setAge((new Integer((String) value).intValue()));
		else if (property.equals("DEPART"))
			// �ж�Ҫ�޸ĵĵ�Ԫ���Ƿ�Ϊ"���ڲ���"��
			sef.setDepartment(EditorOne.departments[((Integer) value).intValue()]);
		else
			return;
		// �޸ĸ���
		viewer.refresh();

	}

}
