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
	 * ��ʼ����鿴�����ݣ���ʵ�ʿ����У� ͨ������������ݿ��е����ݼ�¼��
	 */
	public static List getFactoryData() {
		List list = new ArrayList();
        //�������
		list.add(new StaffEntity(1, "��С��", true, 24, 12345678, "�г���", "��־��",
				new Date()));
		list.add(new StaffEntity(2, "���", false, 26, 67854123, "����", "�����",
				new Date()));
		list.add(new StaffEntity(3, "�����", true, 29, 87654321, "����", "������",
				new Date()));
		list.add(new StaffEntity(4, "������", false, 32, 54321678, "���²�", "�λ�",
				new Date()));
		list.add(new StaffEntity(5, "������", false, 25, 78654123, "����", "����",
				new Date()));
		return list;
	}

}
