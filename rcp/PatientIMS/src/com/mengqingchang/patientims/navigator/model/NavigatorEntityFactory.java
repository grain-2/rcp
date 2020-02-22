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
		// һ����Σ������ڵ�����
		NavigatorEntityElement root1 = new NavigatorEntityElement("סԺ����");
		NavigatorEntityElement root2 = new NavigatorEntityElement("���ù���");
		NavigatorEntityElement root3 = new NavigatorEntityElement("��Ϣ��ѯ");

		// ������νڵ�����
		NavigatorEntityElement level1 = new NavigatorEntityElement("���˵���");
		NavigatorEntityElement level2 = new NavigatorEntityElement("�����Ϣ");
		NavigatorEntityElement level3 = new NavigatorEntityElement("������Ϣ");
		/**
		 * ���ñ༭�������룬�������д��룬��Ӱ�쵼�����Ĵ�����
		 * ֻ�е����������ڵ����Ӧ�༭��ʱ���ã�
		 * ��Ӧ�༭�������ཫ�ں����������
		 */ 
		level1.setEditorInput(new PatientInforEditorInput());
		level2.setEditorInput(new DiagonseInforEditorInput());
		level3.setEditorInput(new ExpenseInforEditorInput());

		// Ϊһ�����(��)"סԺ����"�ڵ������ӽڵ�����
		root1.addChild(level1);
		root1.addChild(level2);

		// Ϊһ�����(����"���ù���"�ڵ������ӽڵ�����
		root2.addChild(level3);
		{// ������ͳһ�����з���
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			list.add(root3);
			return list;
		}

	}

}
