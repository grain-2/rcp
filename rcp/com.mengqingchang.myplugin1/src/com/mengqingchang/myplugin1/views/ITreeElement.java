/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

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
