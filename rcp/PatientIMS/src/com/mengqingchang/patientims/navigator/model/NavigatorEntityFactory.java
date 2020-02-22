/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.navigator.model;

import java.util.ArrayList;
import com.mengqingchang.patientims.editors.DiagonseInforEditorInput;
import com.mengqingchang.patientims.editors.ExpenseInforEditorInput;
import com.mengqingchang.patientims.editors.PatientInforEditorInput;

public class NavigatorEntityFactory {
	public static Object TreeEntityElement() {
		// 一级层次（根）节点数据
		NavigatorEntityElement root1 = new NavigatorEntityElement("住院管理");
		NavigatorEntityElement root2 = new NavigatorEntityElement("费用管理");
		NavigatorEntityElement root3 = new NavigatorEntityElement("信息查询");

		// 二级层次节点数据
		NavigatorEntityElement level1 = new NavigatorEntityElement("病人档案");
		NavigatorEntityElement level2 = new NavigatorEntityElement("诊断信息");
		NavigatorEntityElement level3 = new NavigatorEntityElement("费用信息");
		/**
		 * 设置编辑器的输入，以下三行代码，不影响导航树的创建，
		 * 只有当单击各个节点打开相应编辑器时调用，
		 * 相应编辑器输入类将在后面给出，。
		 */ 
		level1.setEditorInput(new PatientInforEditorInput());
		level2.setEditorInput(new DiagonseInforEditorInput());
		level3.setEditorInput(new ExpenseInforEditorInput());

		// 为一级层次(根)"住院管理"节点设置子节点数据
		root1.addChild(level1);
		root1.addChild(level2);

		// 为一级层次(根）"费用管理"节点设置子节点数据
		root2.addChild(level3);
		{// 设置在统一集合中返回
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			list.add(root3);
			return list;
		}

	}

}
