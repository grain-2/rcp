package com.mengqingchang.myrcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.IWorkbenchWindow;

import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.util.PrefUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
	private TrayItem trayItem;
	private Image trayImage;
	private IWorkbenchWindow window;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction exitAction;

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		IPreferenceStore preStore = PrefUtil.getAPIPreferenceStore();
		preStore.setValue(
				IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS,
				false);

		// 初始化窗口大小
		configurer.setInitialSize(new Point(400, 300));
		// 设置菜单栏的可见性
		configurer.setShowMenuBar(true);
		// 设置工具栏的可见性
		configurer.setShowCoolBar(true);
		// 设置状态栏的可见性
		configurer.setShowStatusLine(true);
		// 设置工作进度
		configurer.setShowProgressIndicator(true);
		// 设置快速视图
		configurer.setShowFastViewBars(true);
		// 设置透视图可见性
		configurer.setShowPerspectiveBar(true);
		// 设置窗口标题
		configurer.setTitle("Hello RCP");

	}

	public boolean preWindowShellClose() {

		MessageBox msgBox = new MessageBox(new Shell(), SWT.YES | SWT.NO
				| SWT.ICON_QUESTION);
		msgBox.setText("Confirm Exit");
		msgBox.setMessage("Do you want exit application system?");
		if (msgBox.open() == SWT.YES) {
			return true;
		}
		return false;
	}

	public void postWindowOpen() {

		super.postWindowOpen();
		window = getWindowConfigurer().getWindow();
		// 初始化系统托盘
		trayItem = initTaskItem(window);

		if (trayItem != null) {
			// 调用自定义方法，该方法实现将界面最小化到系统托盘
			createMinimize();

			// 调用自定义方法，该方法实现右键单击系统托盘图标弹出菜单效果
			hookPopupMenu(window);

		}

	}

	// 初始化系统托盘
	private TrayItem initTaskItem(IWorkbenchWindow window) {
		// 获得托盘对象
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		// 向托盘中添加托盘项目
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		// 定义系统托盘图标
		trayImage = AbstractUIPlugin.imageDescriptorFromPlugin(

		MyRcpPlugin.PLUGIN_ID, "/icons/eclipse1.gif").createImage();
		// 设置图标
		trayItem.setImage(trayImage);
		// 设置托盘提示性文本
		trayItem.setToolTipText("TrayItem");

		return trayItem;
	}

	// 设置最小化到托盘方法
	private void createMinimize() {
		// 实现单击界面最小化按钮，将程序窗口最小化到托盘
		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				// 设置当前窗口不可见
				window.getShell().setVisible(false);
			}

		});
		// 实现双击托盘图标打开窗口功能
		trayItem.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event event) {
				// 获得Shell对象
				Shell shell = window.getShell();
				// 判断当前窗口是否可见
				if (!shell.isVisible()) {
					// 如果不可见，则将窗口设置为可见
					shell.setVisible(true);
					window.getShell().setMinimized(false);

				}

			}

		});

	}

	// 设置托盘右键菜单
	private void hookPopupMenu(final IWorkbenchWindow window) {
		// 实现右键的监听
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				// 定义菜单管理器
				MenuManager trayMenu = new MenuManager();
				// 定义菜单
				Menu menu = trayMenu.createContextMenu(window.getShell());
				// 为托盘创建菜单
				fillTrayItemAction(trayMenu, window);

				// 设置菜单可见性
				menu.setVisible(true);
			}
		});
	}

	// 自定以方法，创建托盘菜单
	private void fillTrayItemAction(IMenuManager trayItem,

	final IWorkbenchWindow window) {

		exitAction = ActionFactory.QUIT.create(window);
		aboutAction = ActionFactory.ABOUT.create(window);

		trayItem.add(aboutAction);
		trayItem.add(exitAction);

	}

	// 销毁资源
	public void dispose() {

		if (trayImage != null) {

			trayImage.dispose();

			trayItem.dispose();

		}

	}

}
