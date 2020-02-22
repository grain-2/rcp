/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IEditorInput;

public class EntityElement implements ITreeElement {

	// 根节点名称
	private String name;
	private IEditorInput editorInput;

	// 根节点包含的集合，封装在List中
	private List list1 = new ArrayList();

	// 构造方法
	public EntityElement() {
	}

	public EntityElement(String name) {
		this.name = name;
	}

	// 实现接口ITreeElement方法
	public void setChildren(List children) {
		this.list1 = children;
	}

	// 实现接口ITreeElement方法
	public List getChildren() {
		return list1;
	}

	// 实现接口ITreeElement方法
	public void addChild(ITreeElement treeElement) {
		list1.add(treeElement);
	}

	// 实现接口ITreeElement方法，判断是否有子节点
	public boolean hasChildren() {
		if (list1.size() > 0)
			return true;
		else
			return false;
	}

	// 实现接口ITreeElement方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO 自动生成方法存根
		return name;
	}

	public IEditorInput getEditorInput() {
		return editorInput;
	}

	public void setEditorInput(IEditorInput editorInput) {
		this.editorInput = editorInput;
	}

}
