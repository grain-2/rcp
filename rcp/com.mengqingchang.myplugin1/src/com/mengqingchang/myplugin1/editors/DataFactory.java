/**
 *@author MengQingChang
 *Copyright 2007-10-29,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataFactory {
	/**
	 * 初始化表查看器数据，在实际开发中， 通常读入的是数据库中的数据记录。
	 */
	public static List getFactoryData() {
		List list = new ArrayList();
        //添加数据
		list.add(new StaffEntity(1, "王小明", true, 24, 12345678, "市场部", "郭志光",
				new Date()));
		list.add(new StaffEntity(2, "李娟", false, 26, 67854123, "商务部", "李凤瑞",
				new Date()));
		list.add(new StaffEntity(3, "刘毅佳", true, 29, 87654321, "财务部", "张欣欣",
				new Date()));
		list.add(new StaffEntity(4, "张丽凤", false, 32, 54321678, "人事部", "宋徽",
				new Date()));
		list.add(new StaffEntity(5, "赵智文", false, 25, 78654123, "商务部", "赵启",
				new Date()));
		return list;
	}

}
