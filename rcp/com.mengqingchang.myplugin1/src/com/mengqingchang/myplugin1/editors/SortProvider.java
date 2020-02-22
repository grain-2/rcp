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
	 * 获取EditorOne类中的排序列号，即((SortProvider)
	 * tv.getSorter()).Sorter()语句中Sorter()方法中的三目表达式运算值
	 */
	public void Sorter(int sort) {
		this.sort = sort;
	}
	// 排序器核心代码，返回值为一个整数。
	public int compare(Viewer viewer, Object object1, Object object2) {
		// 将对象转化为int类型
		StaffEntity ste1 = (StaffEntity) object1;
		StaffEntity ste2 = (StaffEntity) object2;
		// 分支语句，获取为字段所在的列设置的列号。
		switch (sort) {
		// 实现第一列“编号”字段降序排列表记录
		case 1: {
			Integer id1 = Integer.valueOf(ste1.getID());
			Integer id2 = Integer.valueOf(ste2.getID());
			int descId = id1.compareTo(id2);
			return descId;
		}
		// 实现第一列“编号”字段升序排列表记录
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
