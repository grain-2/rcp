/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class SortProvider extends ViewerSorter {
	private int sort;
	/**
	 * ��ȡEditorOne���е������кţ���((SortProvider)
	 * tv.getSorter()).Sorter()�����Sorter()�����е���Ŀ���ʽ����ֵ
	 */
	public void Sorter(int sort) {
		this.sort = sort;
	}
	// ���������Ĵ��룬����ֵΪһ��������
	public int compare(Viewer viewer, Object object1, Object object2) {
		// ������ת��Ϊint����
		StaffEntity ste1 = (StaffEntity) object1;
		StaffEntity ste2 = (StaffEntity) object2;
		// ��֧��䣬��ȡΪ�ֶ����ڵ������õ��кš�
		switch (sort) {
		// ʵ�ֵ�һ�С���š��ֶν������б��¼
		case 1: {
			Integer id1 = Integer.valueOf(ste1.getID());
			Integer id2 = Integer.valueOf(ste2.getID());
			int descId = id1.compareTo(id2);
			return descId;
		}
		// ʵ�ֵ�һ�С���š��ֶ��������б��¼
		case -1: {
			Integer id1 = Integer.valueOf(ste1.getID());
			Integer id2 = Integer.valueOf(ste2.getID());
			int ascId = id2.compareTo(id1);
			return ascId;
		}
		case 2: {
			String name1 = ste1.getName();
			String name2 = ste2.getName();
			int descName = name1.compareTo(name2);
			return descName;
		}
		case -2: {
			String name1 = ste1.getName();
			String name2 = ste2.getName();
			int ascName = name2.compareTo(name1);
			return ascName;
		}
		case 3: {
			Integer age1 = Integer.valueOf(ste1.getAge());
			Integer age2 = Integer.valueOf(ste2.getAge());
			int descAge = age1.compareTo(age2);
			return descAge;
		}
		case -3: {
			Integer age1 = Integer.valueOf(ste1.getAge());
			Integer age2 = Integer.valueOf(ste2.getAge());
			int ascAge = age2.compareTo(age1);
			return ascAge;
		}
		}
		return 0;
	}

}
