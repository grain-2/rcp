/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IEditorInput;

public class EntityElement implements ITreeElement {

	// ���ڵ�����
	private String name;
	private IEditorInput editorInput;

	// ���ڵ�����ļ��ϣ���װ��List��
	private List list1 = new ArrayList();

	// ���췽��
	public EntityElement() {
	}

	public EntityElement(String name) {
		this.name = name;
	}

	// ʵ�ֽӿ�ITreeElement����
	public void setChildren(List children) {
		this.list1 = children;
	}

	// ʵ�ֽӿ�ITreeElement����
	public List getChildren() {
		return list1;
	}

	// ʵ�ֽӿ�ITreeElement����
	public void addChild(ITreeElement treeElement) {
		list1.add(treeElement);
	}

	// ʵ�ֽӿ�ITreeElement�������ж��Ƿ����ӽڵ�
	public boolean hasChildren() {
		if (list1.size() > 0)
			return true;
		else
			return false;
	}

	// ʵ�ֽӿ�ITreeElement����
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO �Զ����ɷ������
		return name;
	}

	public IEditorInput getEditorInput() {
		return editorInput;
	}

	public void setEditorInput(IEditorInput editorInput) {
		this.editorInput = editorInput;
	}

}
