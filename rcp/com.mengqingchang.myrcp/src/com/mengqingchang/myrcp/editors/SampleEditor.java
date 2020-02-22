/**
 *@author MengQingChang
 *Copyright  2007-11-23,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.mengqingchang.myrcp.actions.EditorToolbarAction;
import com.mengqingchang.myrcp.actions.ViewToolbarAction;

public class SampleEditor extends EditorPart {

	private Text text;
    private Display display=Display.getCurrent();
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		//text = new Text(parent, SWT.BORDER);
		addEditorToolBar();
        addToolbar(parent);
	}

	public void addEditorToolBar() {
		IActionBars bars = getEditorSite().getActionBars();
		IToolBarManager iToolBar = bars.getToolBarManager();
	 	iToolBar.add(new ViewToolbarAction());
 	}
	public void addToolbar(Composite parent){
		//定义ViewForm对象
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		//设置viewForm布局
		viewForm.setLayout(new FillLayout());
		//定义将Text定义到VieForm容器上
		text = new Text(viewForm, SWT.BORDER);
		//定义ToolBar对象
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		//定义ToolBarManager对象
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		//设置工具栏在ViewForm容器的顶端
		viewForm.setTopLeft(toolBar);
		//设置viewForm容器内容
		viewForm.setContent(text);
		//添加操作为工具栏按钮
		toolBarManager.add(new EditorToolbarAction());
		//更新操作，否则按钮将看不到
		toolBarManager.update(true);
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
