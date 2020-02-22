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

		// ��ʼ�����ڴ�С
		configurer.setInitialSize(new Point(400, 300));
		// ���ò˵����Ŀɼ���
		configurer.setShowMenuBar(true);
		// ���ù������Ŀɼ���
		configurer.setShowCoolBar(true);
		// ����״̬���Ŀɼ���
		configurer.setShowStatusLine(true);
		// ���ù�������
		configurer.setShowProgressIndicator(true);
		// ���ÿ�����ͼ
		configurer.setShowFastViewBars(true);
		// ����͸��ͼ�ɼ���
		configurer.setShowPerspectiveBar(true);
		// ���ô��ڱ���
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
		// ��ʼ��ϵͳ����
		trayItem = initTaskItem(window);

		if (trayItem != null) {
			// �����Զ��巽�����÷���ʵ�ֽ�������С����ϵͳ����
			createMinimize();

			// �����Զ��巽�����÷���ʵ���Ҽ�����ϵͳ����ͼ�굯���˵�Ч��
			hookPopupMenu(window);

		}

	}

	// ��ʼ��ϵͳ����
	private TrayItem initTaskItem(IWorkbenchWindow window) {
		// ������̶���
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		// �����������������Ŀ
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		// ����ϵͳ����ͼ��
		trayImage = AbstractUIPlugin.imageDescriptorFromPlugin(

		MyRcpPlugin.PLUGIN_ID, "/icons/eclipse1.gif").createImage();
		// ����ͼ��
		trayItem.setImage(trayImage);
		// ����������ʾ���ı�
		trayItem.setToolTipText("TrayItem");

		return trayItem;
	}

	// ������С�������̷���
	private void createMinimize() {
		// ʵ�ֵ���������С����ť�������򴰿���С��������
		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				// ���õ�ǰ���ڲ��ɼ�
				window.getShell().setVisible(false);
			}

		});
		// ʵ��˫������ͼ��򿪴��ڹ���
		trayItem.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event event) {
				// ���Shell����
				Shell shell = window.getShell();
				// �жϵ�ǰ�����Ƿ�ɼ�
				if (!shell.isVisible()) {
					// ������ɼ����򽫴�������Ϊ�ɼ�
					shell.setVisible(true);
					window.getShell().setMinimized(false);

				}

			}

		});

	}

	// ���������Ҽ��˵�
	private void hookPopupMenu(final IWorkbenchWindow window) {
		// ʵ���Ҽ��ļ���
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				// ����˵�������
				MenuManager trayMenu = new MenuManager();
				// ����˵�
				Menu menu = trayMenu.createContextMenu(window.getShell());
				// Ϊ���̴����˵�
				fillTrayItemAction(trayMenu, window);

				// ���ò˵��ɼ���
				menu.setVisible(true);
			}
		});
	}

	// �Զ��Է������������̲˵�
	private void fillTrayItemAction(IMenuManager trayItem,

	final IWorkbenchWindow window) {

		exitAction = ActionFactory.QUIT.create(window);
		aboutAction = ActionFactory.ABOUT.create(window);

		trayItem.add(aboutAction);
		trayItem.add(exitAction);

	}

	// ������Դ
	public void dispose() {

		if (trayImage != null) {

			trayImage.dispose();

			trayItem.dispose();

		}

	}

}
