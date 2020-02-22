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

	// 检查给定元素（表格记录）的属性是否能被修改
	public boolean canModify(Object element, String property) {

		return true;
	}

	// 返回表格记录的属性修改的值，null则不需要修改
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
	 * （非 Javadoc）
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	    *   修改表格记录的属性的值，只对"MALE"、"AGE"、"DEPART"属性进行了修改设定 (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {
		TableItem tableItem = (TableItem) element;
		StaffEntity sef = (StaffEntity) tableItem.getData();
		// 判断要修改的单元格是否为"性别"列
		if (property.equals("MALE"))
			sef.setSex(((Boolean) value).booleanValue());
		// 判断要修改的单元格是否为"年龄"列
		else if (property.equals("AGE"))
			sef.setAge((new Integer((String) value).intValue()));
		else if (property.equals("DEPART"))
			// 判断要修改的单元格是否为"所在部门"列
			sef.setDepartment(EditorOne.departments[((Integer) value).intValue()]);
		else
			return;
		// 修改更新
		viewer.refresh();

	}

}
