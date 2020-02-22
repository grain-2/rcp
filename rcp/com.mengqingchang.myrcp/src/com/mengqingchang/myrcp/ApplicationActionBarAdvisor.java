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
		// �����������
		navigatorAction = new OpenAction(window);
		dropDownAction = new DropDownAction();
		// ����Eclipse���ò���
		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		// ������ע�ᵽ����̨��
		register(newWindowAction);
		exitAction = ActionFactory.QUIT.create(window);
		 
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		 ImageDescriptor imgDes = WorkbenchImages
//				 .getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_HOME_NAV); //�޸�
		 .getImageDescriptor(IWorkbenchGraphicConstants.IMG_DTOOL_NEW_FASTVIEW);
		 aboutAction.setImageDescriptor(imgDes);
		register(aboutAction);
		// ��������͸��ͼ����
		perspectiveAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG
				.create(window);
		showViewListAction = ContributionItemFactory.VIEWS_SHORTLIST
				.create(window);
		openSampleView1Action = new OpenSampleView1Action(window);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		// -------------------�����ļ��˵�------------------
		// ����ļ��˵�
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		fileMenu.add(newWindowAction);
		fileMenu.add(exitAction);
		menuBar.add(fileMenu);
		// ---------------------���ô��ڲ˵�----------------------
		// ����MenuManager���󣬼�����һ��"Window"�˵�
		MenuManager windowMenu = new MenuManager("&Window",
				" IWorkbenchActionConstants.M_WINDOW");
		// --------------���ô��ڵ�"Show View"�˵���------------
		// ����"Show View"�˵���
		MenuManager showViewMenu = new MenuManager("&Show View", "show view");
		// ��Ӷ����˵�������
		showViewMenu.add(navigatorAction);
		showViewMenu.add(openSampleView1Action);
		showViewMenu.add(showViewListAction);

		// ��"Window"�˵�����Ӳ˵���
		windowMenu.add(showViewMenu);
		// ���͸��ͼ����
		windowMenu.add(perspectiveAction);

		// �ڲ˵�����Ӳ˵�
		menuBar.add(windowMenu);

		// -----------------���ð����˵�-----------------
		// ��Ӱ����˵�
		MenuManager helpMenu = new MenuManager("&Help", "help");
		helpMenu.add(aboutAction);
		menuBar.add(helpMenu);

	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		// ����һ��IToolBarManager����
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		// ��coolBar�����toolbar
		coolBar.add(toolbar);
		// ���navigator��ť
		toolbar.add(navigatorAction);
		// ��ӷָ��
		// toolbar.add(new Separator());
		// ���about���� //
		// toolbar.add(aboutAction);
		// �ٶ���һ��IToolBarManger����
		IToolBarManager toolbar1 = new ToolBarManager(coolBar.getStyle());
		// ��ӷ����ʶ��ʹtoolbar1��Ϊ�����Ķ�̬��������
		toolbar1.add(new GroupMarker("GroupMarker1"));
		toolbar1.add(aboutAction);
		coolBar.add(toolbar1);

		IToolBarManager toolbar2 = new ToolBarManager(coolBar.getStyle());
		// ��ӷ����ʶ��ʹtoolbar2��Ϊ�����Ķ�̬��������
		toolbar2.add(new GroupMarker("GroupMarker2"));
		toolbar2.add(dropDownAction);
		toolbar2.add(openSampleView1Action);
		coolBar.add(toolbar2);
	}

	// ----------------��fillCoolBar()������ʵ�ֹ�������ť�����˵�---------------------
	// protected void fillCoolBar(ICoolBarManager coolBar) {
	// IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
	// coolBar.add(toolbar);
	// ���navigator��ť
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

	// ---------------------ʵ�ֹ�������ť��̬����һ����-----------------------
	// protected void fillCoolBar(ICoolBarManager coolBar) {
	// ��ʹ��ICoolBarManagerʱToolBarContributionItem��ΪtoolBarManager�ṩ�˷�װ��
	// coolBar.add(new ToolBarContributionItem(this
	// .createNavigatorToolBar(coolBar.getStyle()),"navigatorToolBar"));
	// coolBar.add(new ToolBarContributionItem(this
	// .createAboutToolBar1(coolBar.getStyle()), "aboutToolBar"));
	// }
	// �Զ��巽��
	// protected IToolBarManager createNavigatorToolBar(int style) {
	// IToolBarManager navigatorToolBar = new ToolBarManager(style);
	// ��ӷ����ʶ
	// navigatorToolBar.add(new GroupMarker("GroupMarker1"));
	// navigatorToolBar.add(navigatorAction);
	// return navigatorToolBar;
	// }
	// �Զ��巽��
	// protected IToolBarManager createAboutToolBar1(int style) {
	// IToolBarManager aboutToolBar = new ToolBarManager(style);
	// aboutToolBar.add(new GroupMarker("GroupMarker2"));
	// aboutToolBar.add(aboutAction);
	// return aboutToolBar;
	// }

	protected void fillStatusLine(IStatusLineManager statusLine) {
		super.fillStatusLine(statusLine);
		// ����StatusLineContributionItem����
//		final StatusLineContributionItem statusItem = new StatusLineContributionItem( "");  �޸�
		final StatusLineContributionItem statusItem = new StatusLineContributionItem( "");
		// ��ȡ���ȼ�����������״̬����ʾ
		statusLine.getProgressMonitor();

		// ����״̬���ı�
		statusItem.setText("Status Messages");
		// ��statusItemע�ᵽstatusLine
		statusLine.add(statusItem);

	}
 
}
