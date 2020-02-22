/**
 *@author MengQingChang
 *Copyright  2007-11-21,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.ui.part.ViewPart;

import com.mengqingchang.myrcp.actions.ViewToolbarAction;
import com.mengqingchang.myrcp.editors.SampleEditorInput;

public class SampleView1 extends ViewPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */

	private List list;
	// 设置SampleView2视图ID
	 public static final String ViewID = "com.mengqingchang.myrcp.view2";

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		// 定义一个列表对象
		list = new List(parent, SWT.NONE);
		// 设置列表项
		list
				.setItems(new String[] { "SampleView2", "SampleEditor",
						"MulEditor" });
		// 调用自定义,实现视图的交互
		hookClickAction();
		// 添加工具栏按钮
		fillViewToolBarAction();
		// 调用自定义方法，添加视图工具栏下拉菜单
		fillViewToolBarContextMenu();
		// 调用自定义方法，为列表添加上下文菜单
		fillListContextMenu();

	}

	// 自定义方法，添加视图工具栏按钮
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义工具栏
		IToolBarManager toolBar = bars.getToolBarManager();
		// 添加操作为工具栏按钮
		toolBar.add(new ViewToolbarAction());
	}

	// 自定义方法，添加视图工具栏下拉菜单。
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义菜单
		IMenuManager toolBarMenu = bars.getMenuManager();
		// 添加操作为下拉菜单

		toolBarMenu.add(new ViewToolbarAction());

	}

	// 自定义方法,为列表添加上下文菜单
	private void fillListContextMenu() {
		MenuManager menuManger = new MenuManager();
		Menu menu = menuManger.createContextMenu(list);
		// 为列表设置菜单
		list.setMenu(menu);
		// 添加操作为列表上下文菜单
		menuManger.add(new ViewToolbarAction());
	}

	private void hookClickAction() {
		list.addMouseListener(new MouseAdapter() {
			SampleEditorInput sampleEditorInput = new SampleEditorInput();
			// 获得IWorkbenchPage对象
			IWorkbenchPage workbenchPage = getViewSite().getPage();

			public void mouseDoubleClick(MouseEvent e) {

				IEditorInput editorInput = null;
				String editorID = null;
				// 获得列表的第二项索引值
				if (list.getSelectionIndex() == 1) {
					editorInput = sampleEditorInput;
					// 设置SampleEditor编辑器id值，在plugin.xml中定义的id值
					editorID = "com.mengqingchang.myrcp.editor1";
					// 查找SampleEditor编辑器
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					// 如果此编辑器已经存在，则将编辑器设置为当前状态。
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else
						// 如果，编辑器不存在，则打开一个编辑器。
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorID);
						}catch(Exception ex) {
			                   System.out.println(ex);
		                 }

				}

			}

			public void mouseDown(MouseEvent e) {

				// 获得要显示内容的视图对象
				IViewPart viewPart = workbenchPage.findView(ViewID);
				// 转换视图对象
				SampleView2 view2 = (SampleView2) viewPart;
				// 设置内容
				view2.setContent(list.getSelection()[0]);
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
