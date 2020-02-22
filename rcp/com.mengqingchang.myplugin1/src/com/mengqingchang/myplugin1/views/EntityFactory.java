/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.ArrayList;

import com.mengqingchang.myplugin1.editors.EditorOneInput;

public class EntityFactory {

	public static Object TreeEntityElement() {
		// 一级层次（根）节点数据
		EntityElement root1 = new EntityElement("员工管理");
		EntityElement root2 = new EntityElement("产品管理");

		// 二级层次节点数据
		EntityElement level1 = new EntityElement("员工档案");
		EntityElement level2 = new EntityElement("员工薪资");
		EntityElement level3 = new EntityElement("员工绩效");
		EntityElement level4 = new EntityElement("产品分类");
		EntityElement level5 = new EntityElement("产品报价");
		level1.setEditorInput(new EditorOneInput());
		// 三级层次节点数据
		EntityElement leaf1 = new EntityElement("短信网址");
		EntityElement leaf2 = new EntityElement("传统网站");
		EntityElement leaf3 = new EntityElement("WAP网站");

		// 为一级层次(根)“员工管理”节点设置子节点数据
		root1.addChild(level1);
		root1.addChild(level2);
		root1.addChild(level3);

		// 为一级层次(根）“产品管理”节点设置子节点数据
		root2.addChild(level4);
		root2.addChild(level5);

		// 为二级层次“产品分类”节点设置子节点数据
		level4.addChild(leaf1);
		level4.addChild(leaf2);
		level4.addChild(leaf3);

		{// 设置在统一集合中返回
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			return list;
		}

	}

}
