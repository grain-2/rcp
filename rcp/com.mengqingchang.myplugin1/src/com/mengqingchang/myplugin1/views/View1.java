/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

public class View1 extends ViewPart {
	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	public View1() {
		// TODO 自动生成构造函数存根
	}

	public void createPartControl(Composite parent) {
		// 定义TreeViewer
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// 设置内容提供器
		tv.setContentProvider(new TreeViewerContentProvider());
		// 设置标签提供器
		tv.setLabelProvider(new TreeViewerLabelProvider());
		// 用setInput方法读入数据
		tv.setInput(EntityFactory.TreeEntityElement());
		// 调用自定义方法，添加视图工具栏按钮
		fillViewToolBarAction();
		// 调用自定义方法，添加视图工具栏下拉菜单
		fillViewToolBarContextMenu();
		// 调用自定义方法，为查看器添加上下文菜单
		fillTreeViewContextMenu();
		// 调用自定义双击方法
		hookDoubleClickAction();
		// tv.addDoubleClickListener(new MyDoubleClickListener());

	}

	// 自定义方法，添加工具栏按钮
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义工具栏
		IToolBarManager toolBar = bars.getToolBarManager();
		drillDownAdapter = new DrillDownAdapter(tv);
		// 为工具栏添加“goback”、“gohome”、“gointo”操作。
		drillDownAdapter.addNavigationActions(toolBar);
		// 添加分割符
		toolBar.add(new Separator());
		// 添加操作
		toolBar.add(new ActionOne());
		toolBar.add(new ActionTwo());
	}

	// 自定义方法，添加工具栏下拉菜单。
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义菜单
		IMenuManager toolBarMenu = bars.getMenuManager();
		toolBarMenu.add(new ActionOne());
		toolBarMenu.add(new ActionTwo());
		toolBarMenu.add(new Separator());
		// 为工具栏下拉菜单添加“goback”、“gohome”、“gointo”操作。
		drillDownAdapter.addNavigationActions(toolBarMenu);
	}

	// 自定义方法,为树查看器添加上下文菜单
	private void fillTreeViewContextMenu() {
		MenuManager menuManger = new MenuManager();
		Menu menu = menuManger.createContextMenu(tv.getControl());
		tv.getControl().setMenu(menu);
		menuManger.add(new ActionOne());
		menuManger.add(new ActionTwo());
		menuManger.add(new Separator());
		// 为上下文菜单那添加“goback”、“gohome”、“gointo”操作。
		drillDownAdapter.addNavigationActions(menuManger);
	}

	// 操作类
	class ActionOne extends Action {
		public ActionOne() {
			// 设置操作文本
			setText("ActionOne");
			// 提示性的字符标签
			setToolTipText("ActionOne tooltip");
			// 设置图标
			ImageDescriptor imageDesc = WorkbenchImages
					.getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_NEW_PAGE);
			setHoverImageDescriptor(imageDesc);
			// 也可以用下面的方法设置图标
			/**
			 * setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			 * getImageDescriptor(ISharedImages.IMG_OBJS_BKMRK_TSK));
			 */

		}

		public void run() {
			MessageDialog.openInformation(null, "Hello",
					"This is View Action!!!!");
		}
	}

	class ActionTwo extends Action {
		public ActionTwo() {
			setText("ActionTwo");
			// 提示性的字符信息
			setToolTipText("ActionTwo tooltip");
			// 设置图标
			ImageDescriptor imageDesc = WorkbenchImages
					.getImageDescriptor(IWorkbenchGraphicConstants.IMG_OBJ_THEME_CATEGORY);
			setHoverImageDescriptor(imageDesc);

			/**
			 * setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			 * getImageDescriptor(ISharedImages.IMG_OBJS_BKMRK_TSK));
			 * 
			 */
		}

		public void run() {
			MessageDialog.openInformation(null, "Hello",
					"This is View Action!!!!");
		}
	}

	private void hookDoubleClickAction() {
		tv.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// 选择包含的元素
				IStructuredSelection strsel = (IStructuredSelection) event
						.getSelection();
				/*
				 * getFirstElement()方法用来返回所选择的第一个元素， 
				 * 如果选择为空，则返回null。
				 */
				EntityElement entityelement = (EntityElement) strsel
						.getFirstElement();

				String editorId = null;

				IEditorInput editorInput = entityelement.getEditorInput();
				// 判断双击节点时获得的节点名称是否等于"员工档案'。
				if (entityelement.getName().equals("员工档案")) {
					System.out.println(entityelement.getName());
					// 设置编辑器id，id为plugin.xml中设置的id值。
					editorId = "com.mengqingchang.myplugin1.editor1";
					IWorkbenchPage workbenchPage = getViewSite().getPage();
					// 查找要打开的编辑器对象
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					/*
					 * 如果存在(已经打开所需的编辑器），
					 *  则将其设置为当前的编辑器。
					 */
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						// 如果编辑器还没有打开，则打开这个编辑器
						try {// 打开编辑器的方法
							editor = workbenchPage.openEditor(editorInput,
									editorId);
						} catch (Exception ex) {
							System.out.println(ex);
						}

					}
				}
			}
		});
	}

	public void setFocus() {
		// TODO 自动生成方法存根
	}
}
