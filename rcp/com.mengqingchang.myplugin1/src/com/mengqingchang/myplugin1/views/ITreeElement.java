/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import java.util.List;

public interface ITreeElement {
	// 设置树结点名称
	public void setName(String name);
	// 得到树结点的名称
	public String getName();
	// 设置与子节点集合
	public void setChildren(List children);
	// 得到子结点集合
	public List getChildren();
	// 是否有子孙
	public boolean hasChildren();
	//添加子节点
 	public void addChild(ITreeElement treeElement);

}
