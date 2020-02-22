package com.mengqingchang.myrcp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.jface.action.ToolBarContributionItem;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;
import org.eclipse.ui.internal.WorkbenchWindow;
//import org.eclipse.ui.internal.util.StatusLineContributionItem;

import com.mengqingchang.myrcp.actions.DropDownAction;
import com.mengqingchang.myrcp.actions.OpenAction;
import com.mengqingchang.myrcp.actions.OpenSampleView1Action;
import com.mengqingchang.myrcp.actions.SampleAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction newWindowAction;
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private OpenAction navigatorAction;
	private DropDownAction dropDownAction;
	private IWorkbenchAction perspectiveAction;
	private IContributionItem showViewListAction;
	private OpenSampleView1Action openSampleView1Action;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);

	}

	protected void makeActions(IWorkbenchWindow window) {
		super.makeActions(window);
		// 定义操作对象
		navigatorAction = new OpenAction(window);
		dropDownAction = new DropDownAction();
		// 定义Eclipse内置操作
		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		// 将操作注册到工作台中
		register(newWindowAction);
		exitAction = ActionFactory.QUIT.create(window);
		 
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		 ImageDescriptor imgDes = WorkbenchImages
//				 .getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_HOME_NAV); //修改
		 .getImageDescriptor(IWorkbenchGraphicConstants.IMG_DTOOL_NEW_FASTVIEW);
		 aboutAction.setImageDescriptor(imgDes);
		register(aboutAction);
		// 定义内置透视图操作
		perspectiveAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG
				.create(window);
		showViewListAction = ContributionItemFactory.VIEWS_SHORTLIST
				.create(window);
		openSampleView1Action = new OpenSampleView1Action(window);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		// -------------------设置文件菜单------------------
		// 添加文件菜单
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		fileMenu.add(newWindowAction);
		fileMenu.add(exitAction);
		menuBar.add(fileMenu);
		// ---------------------设置窗口菜单----------------------
		// 定义MenuManager对象，即定义一个"Window"菜单
		MenuManager windowMenu = new MenuManager("&Window",
				" IWorkbenchActionConstants.M_WINDOW");
		// --------------设置窗口的"Show View"菜单项------------
		// 定义"Show View"菜单项
		MenuManager showViewMenu = new MenuManager("&Show View", "show view");
		// 添加二级菜单项及其操作
		showViewMenu.add(navigatorAction);
		showViewMenu.add(openSampleView1Action);
		showViewMenu.add(showViewListAction);

		// 在"Window"菜单下添加菜单项
		windowMenu.add(showViewMenu);
		// 添加透视图操作
		windowMenu.add(perspectiveAction);

		// 在菜单栏添加菜单
		menuBar.add(windowMenu);

		// -----------------设置帮助菜单-----------------
		// 添加帮助菜单
		MenuManager helpMenu = new MenuManager("&Help", "help");
		helpMenu.add(aboutAction);
		menuBar.add(helpMenu);

	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		// 定义一个IToolBarManager对象
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		// 在coolBar上添加toolbar
		coolBar.add(toolbar);
		// 添加navigator按钮
		toolbar.add(navigatorAction);
		// 添加分割符
		// toolbar.add(new Separator());
		// 添加about按你 //
		// toolbar.add(aboutAction);
		// 再定义一个IToolBarManger对象，
		IToolBarManager toolbar1 = new ToolBarManager(coolBar.getStyle());
		// 添加分组标识，使toolbar1成为独立的动态工具栏组
		toolbar1.add(new GroupMarker("GroupMarker1"));
		toolbar1.add(aboutAction);
		coolBar.add(toolbar1);

		IToolBarManager toolbar2 = new ToolBarManager(coolBar.getStyle());
		// 添加分组标识，使toolbar2成为独立的动态工具栏组
		toolbar2.add(new GroupMarker("GroupMarker2"));
		toolbar2.add(dropDownAction);
		toolbar2.add(openSampleView1Action);
		coolBar.add(toolbar2);
	}

	// ----------------在fillCoolBar()方法中实现工具栏按钮下拉菜单---------------------
	// protected void fillCoolBar(ICoolBarManager coolBar) {
	// IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
	// coolBar.add(toolbar);
	// 添加navigator按钮
	// toolbar.add(navigatorAction);
	// navigatorAction.setMenuCreator(new IMenuCreator() {

	// public Menu getMenu(Control parent) {
	// Menu menu = new Menu(parent);

	// for (int i = 0; i < 5; i++) {
	// MenuItem menuitem = new MenuItem(menu, SWT.CHECK);
	// menuitem.setText("MenuItem" + i);
	// }

	// return menu;
	// }

	// public Menu getMenu(Menu parent) {
	// return null;
	// }

	// public void dispose() {
	// }
	// });
	// }

	// ---------------------实现工具栏按钮动态性另一方法-----------------------
	// protected void fillCoolBar(ICoolBarManager coolBar) {
	// 当使用ICoolBarManager时ToolBarContributionItem类为toolBarManager提供了封装。
	// coolBar.add(new ToolBarContributionItem(this
	// .createNavigatorToolBar(coolBar.getStyle()),"navigatorToolBar"));
	// coolBar.add(new ToolBarContributionItem(this
	// .createAboutToolBar1(coolBar.getStyle()), "aboutToolBar"));
	// }
	// 自定义方法
	// protected IToolBarManager createNavigatorToolBar(int style) {
	// IToolBarManager navigatorToolBar = new ToolBarManager(style);
	// 添加分组标识
	// navigatorToolBar.add(new GroupMarker("GroupMarker1"));
	// navigatorToolBar.add(navigatorAction);
	// return navigatorToolBar;
	// }
	// 自定义方法
	// protected IToolBarManager createAboutToolBar1(int style) {
	// IToolBarManager aboutToolBar = new ToolBarManager(style);
	// aboutToolBar.add(new GroupMarker("GroupMarker2"));
	// aboutToolBar.add(aboutAction);
	// return aboutToolBar;
	// }

	protected void fillStatusLine(IStatusLineManager statusLine) {
		super.fillStatusLine(statusLine);
		// 定义StatusLineContributionItem对象
//		final StatusLineContributionItem statusItem = new StatusLineContributionItem( "");  修改
		final StatusLineContributionItem statusItem = new StatusLineContributionItem( "");
		// 获取进度监视器，并在状态栏显示
		statusLine.getProgressMonitor();

		// 设置状态栏文本
		statusItem.setText("Status Messages");
		// 将statusItem注册到statusLine
		statusLine.add(statusItem);

	}
 
}
