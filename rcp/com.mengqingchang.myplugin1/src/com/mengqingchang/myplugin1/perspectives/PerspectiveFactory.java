/**
 *@author MengQingChang
 *Copyright 2007-10-27,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	public PerspectiveFactory() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		// 获得布局页(透视图)的编辑空间标识
		/*
		String editorArea = layout.getEditorArea();
		// 添加视图
		/**
		 * layout.addView("com.mengqingchang.myplugin1.view1", IPageLayout.LEFT,
		 * 0.25f, editorArea);
		 * layout.addView("com.mengqingchang.myplugin1.view2",
		 * IPageLayout.BOTTOM, 0.75f, editorArea);
		 * layout.addView("com.mengqingchang.myplugin1.view3",
		 * IPageLayout.RIGHT, 0.65f, editorArea);
		 */
		// 实现视图的叠加效果
		/*
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT,
				0.4f, editorArea);
		left.addView("com.mengqingchang.myplugin1.view1");
		left.addView("com.mengqingchang.myplugin1.view2");

		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, IPageLayout.DEFAULT_VIEW_RATIO, editorArea);
		// 添加SampleView3视图
		bottom.addView("com.mengqingchang.myplugin1.view3");
		// 添加任务视图
		bottom.addView(IPageLayout.ID_TASK_LIST);
		// 添加问题视图
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
 　　　*/
	}
}
