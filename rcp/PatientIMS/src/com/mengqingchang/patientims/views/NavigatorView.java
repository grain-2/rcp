/**
 *@author MengQingChang
 *Copyright 2007-12-26,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import com.mengqingchang.patientims.actions.OpenSearchView;
import com.mengqingchang.patientims.navigator.model.NavigatorEntityElement;
import com.mengqingchang.patientims.navigator.model.NavigatorEntityFactory;
import com.mengqingchang.patientims.navigatorTreeViewer.TreeViewerContentProvider;
import com.mengqingchang.patientims.navigatorTreeViewer.TreeViewerLabelProvider;

public class NavigatorView extends ViewPart {

	private TreeViewer tv;
	private DrillDownAdapter drillDownAdapter;

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		// 定义TreeViewer
		tv = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		// 设置内容提供器
		tv.setContentProvider(new TreeViewerContentProvider());
		// 设置标签提供器
		tv.setLabelProvider(new TreeViewerLabelProvider());
		// 用setInput方法读入数据
		tv.setInput(NavigatorEntityFactory.TreeEntityElement());
		// 调用自定义方法，添加视图工具栏按钮
		fillViewToolBarAction();
		// 调用自定义方法，添加视图工具栏下拉菜单
		fillViewToolBarContextMenu();
		/**
		 * 调用自定义方法，实现双击各个节点打开相应的编辑器功能。
		 */
		hookDoubleClickAction();

	}

	// 添加视图工具栏
	private void fillViewToolBarAction() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义工具栏
		IToolBarManager toolBar = bars.getToolBarManager();
		drillDownAdapter = new DrillDownAdapter(tv);
		// 为工具栏添加“goback"、"gohomo"、"gointo"操作。
		drillDownAdapter.addNavigationActions(toolBar);
	}

	// 自定义方法，添加视图工具栏下拉菜单。
	private void fillViewToolBarContextMenu() {
		IActionBars bars = getViewSite().getActionBars();
		// 定义菜单
		IMenuManager toolBarMenu = bars.getMenuManager();

		// 为工具栏下拉菜单添加"goback"、"gohome"、"gointo"操作。
		drillDownAdapter.addNavigationActions(toolBarMenu);
	}

	private void hookDoubleClickAction() {
		tv.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				String editorId = null;
				ISelection selection = tv.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				NavigatorEntityElement object = (NavigatorEntityElement) obj;
				IEditorInput editorInput = object.getEditorInput();
				IWorkbenchPage workbenchPage = getViewSite().getPage();
				// 查找要打开的编辑器对象
				if (object.getName().equals("病人档案")) {
					// 设置编辑器id，id为plugin.xml中设置的id值。
					editorId = "PatientIMS.editor1";
					/*
					 * 如果存在(已经打开所需的编辑器）， 则将其设置为当前的编辑器。
					 */
					IEditorPart editor = workbenchPage.findEditor(editorInput);
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
				if (object.getName().equals("诊断信息")) {

					editorId = "PatientIMS.editor2";
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorId);
						} catch (Exception ex) {
							System.out.println(ex);
						}

					}

				} else if (object.getName().equals("费用信息")) {
					editorId = "PatientIMS.editor3";
					IEditorPart editor = workbenchPage.findEditor(editorInput);
					if (editor != null) {
						workbenchPage.bringToTop(editor);
					} else {
						try {
							editor = workbenchPage.openEditor(editorInput,
									editorId);

						} catch (Exception ex) {
							System.out.println(ex);
						}

					}
				}

				else if (object.getName().equals("信息查询")) {
					//打开搜索视图
					createShowViewAction(getSite().getWorkbenchWindow()).run();
				} else
					;
			}
		});
	}
    //调用打开Search（搜索）视图操作
	public static IWorkbenchAction createShowViewAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		IWorkbenchAction action = new OpenSearchView(window);
		return action;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
