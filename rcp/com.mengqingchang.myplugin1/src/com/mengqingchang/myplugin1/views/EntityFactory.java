/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.ArrayList;

import com.mengqingchang.myplugin1.editors.EditorOneInput;

public class EntityFactory {

	public static Object TreeEntityElement() {
		// һ����Σ������ڵ�����
		EntityElement root1 = new EntityElement("Ա������");
		EntityElement root2 = new EntityElement("��Ʒ����");

		// ������νڵ�����
		EntityElement level1 = new EntityElement("Ա������");
		EntityElement level2 = new EntityElement("Ա��н��");
		EntityElement level3 = new EntityElement("Ա����Ч");
		EntityElement level4 = new EntityElement("��Ʒ����");
		EntityElement level5 = new EntityElement("��Ʒ����");
		level1.setEditorInput(new EditorOneInput());
		// ������νڵ�����
		EntityElement leaf1 = new EntityElement("������ַ");
		EntityElement leaf2 = new EntityElement("��ͳ��վ");
		EntityElement leaf3 = new EntityElement("WAP��վ");

		// Ϊһ�����(��)��Ա�������ڵ������ӽڵ�����
		root1.addChild(level1);
		root1.addChild(level2);
		root1.addChild(level3);

		// Ϊһ�����(��������Ʒ�����ڵ������ӽڵ�����
		root2.addChild(level4);
		root2.addChild(level5);

		// Ϊ������Ρ���Ʒ���ࡱ�ڵ������ӽڵ�����
		level4.addChild(leaf1);
		level4.addChild(leaf2);
		level4.addChild(leaf3);

		{// ������ͳһ�����з���
			ArrayList list = new ArrayList();
			list.add(root1);
			list.add(root2);
			return list;
		}

	}

}
