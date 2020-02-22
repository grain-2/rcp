package com.mengqingchang.patientims;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import com.mengqingchang.patientims.actions.OpenExpenseInforView;
import com.mengqingchang.patientims.actions.OpenNavigatorView;
import com.mengqingchang.patientims.actions.OpenSearchPatientInforView;
import com.mengqingchang.patientims.actions.OpenSearchView;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction newWindowAction;
	private IWorkbenchAction exitAction;
	private IWorkbenchAction perspectiveAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction preferenceAction;
	private IContributionItem showViewListAction;
	private OpenNavigatorView openNav;
	private OpenSearchView openSear;
	private OpenSearchPatientInforView openSearPatin;
	private OpenExpenseInforView openExpense;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		// 工作台操作工厂对象，定义"新建窗口"操作
		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);
		// 工作台操作工厂对象，定义"退出"操作
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		// 工作台操作工厂对象，定义打开"透视图列表"操作
		perspectiveAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG
				.create(window);
		register(perspectiveAction);
		// 工作台操作工厂对象，定义打开"关于"对话框操作
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
		// 定义"显示视图列表"对话框操作
		showViewListAction = ContributionItemFactory.VIEWS_SHORTLIST
				.create(window);
		// 自定义操作类,该类用于打开"Navigator"视图
		openNav = new OpenNavigatorView(window);
		// 自定义操作类,该类用于打开"Search"视图
		openSear = new OpenSearchView(window);
		// 自定义操作类,该类用于打开"费用信息"视图
		openExpense = new OpenExpenseInforView(window);
		// 自定义操作类,该类用于打开"病人信息"视图
		openSearPatin = new OpenSearchPatientInforView(window);
		// 工作台操作工厂对象，定义打开"首选项"对话框操作
		preferenceAction = ActionFactory.PREFERENCES.create(window);
	}

	// -------------添加菜单--------------------
	protected void fillMenuBar(IMenuManager menuBar) {
		// 定义File菜单
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		// 添加退出操作菜单项
		fileMenu.add(exitAction);
		// 将File菜单添加到菜单栏
		menuBar.add(fileMenu);
		// 定义Window菜单
		MenuManager windowMenu = new MenuManager("&Window",
				"IWorkbenchActionConstants.M_WINDOW");
		// 为Window定义Show View一级菜单项
		MenuManager showViewMenu = new MenuManager("&Show View", "show view");
		/**
		 * 添加Show View一级菜单项操作，包括：
		 * 打开Navigator视图、 打开Search视图、
		 * 打开病人信息视图、打开费用信息视图以及
		 * 打开显示所有视图列表对话框操作菜单项。
		 */
		showViewMenu.add(openNav);
		showViewMenu.add(openSear);
		showViewMenu.add(openSearPatin);
		showViewMenu.add(openExpense);
		showViewMenu.add(showViewListAction);
		// 为Window添加"新建窗口"操作菜单项
		windowMenu.add(newWindowAction);
		// 为Window添加"Show View"菜单项
		windowMenu.add(showViewMenu);
		// 为Window添加"打开透视图列表"操作菜单项
		windowMenu.add(perspectiveAction);
		// 为Window添加"打开首选项"操作菜单项
		windowMenu.add(preferenceAction);
		// 将Window菜单添加到菜单栏
		menuBar.add(windowMenu);
		// 定义Help菜单
		MenuManager helpMenu = new MenuManager("&Help", " help");
		helpMenu.add(aboutAction);
		menuBar.add(helpMenu);
	}

	// --------------添加工具栏----------------
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// 定义三个工具栏按钮操作
		IToolBarManager toolbar1 = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar1);
		toolbar1.add(openNav);
		IToolBarManager toolbar2 = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar2);
		toolbar2.add(perspectiveAction);
		IToolBarManager toolbar3 = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar3);
		toolbar3.add(openSear);
	}

}
