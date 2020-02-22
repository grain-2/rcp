/**
 *@author MengQingChang
 *Copyright 2007-12-6,MenqQingChang all rights reserved.
 */ 
package com.mengqingchang.patientims.navigator.model;

import java.util.List;
 
public interface ITreeElement {
	// �������������
	public void setName(String name);
	// �õ�����������
	public String getName();
	// �������ӽڵ㼯��
	public void setChildren(List children);
	// �õ��ӽ�㼯��
	public List getChildren();
	// �Ƿ�������
	public boolean hasChildren();
	//����ӽڵ�
 	public void addChild(ITreeElement treeElement);
}
