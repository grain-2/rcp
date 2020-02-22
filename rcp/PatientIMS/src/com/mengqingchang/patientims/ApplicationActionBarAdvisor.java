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
		// ����̨�����������󣬶���"�½�����"����
		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);
		// ����̨�����������󣬶���"�˳�"����
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		// ����̨�����������󣬶����"͸��ͼ�б�"����
		perspectiveAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG
				.create(window);
		register(perspectiveAction);
		// ����̨�����������󣬶����"����"�Ի������
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
		// ����"��ʾ��ͼ�б�"�Ի������
		showViewListAction = ContributionItemFactory.VIEWS_SHORTLIST
				.create(window);
		// �Զ��������,�������ڴ�"Navigator"��ͼ
		openNav = new OpenNavigatorView(window);
		// �Զ��������,�������ڴ�"Search"��ͼ
		openSear = new OpenSearchView(window);
		// �Զ��������,�������ڴ�"������Ϣ"��ͼ
		openExpense = new OpenExpenseInforView(window);
		// �Զ��������,�������ڴ�"������Ϣ"��ͼ
		openSearPatin = new OpenSearchPatientInforView(window);
		// ����̨�����������󣬶����"��ѡ��"�Ի������
		preferenceAction = ActionFactory.PREFERENCES.create(window);
	}

	// -------------��Ӳ˵�--------------------
	protected void fillMenuBar(IMenuManager menuBar) {
		// ����File�˵�
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		// ����˳������˵���
		fileMenu.add(exitAction);
		// ��File�˵���ӵ��˵���
		menuBar.add(fileMenu);
		// ����Window�˵�
		MenuManager windowMenu = new MenuManager("&Window",
				"IWorkbenchActionConstants.M_WINDOW");
		// ΪWindow����Show Viewһ���˵���
		MenuManager showViewMenu = new MenuManager("&Show View", "show view");
		/**
		 * ���Show Viewһ���˵��������������
		 * ��Navigator��ͼ�� ��Search��ͼ��
		 * �򿪲�����Ϣ��ͼ���򿪷�����Ϣ��ͼ�Լ�
		 * ����ʾ������ͼ�б�Ի�������˵��
		 */
		showViewMenu.add(openNav);
		showViewMenu.add(openSear);
		showViewMenu.add(openSearPatin);
		showViewMenu.add(openExpense);
		showViewMenu.add(showViewListAction);
		// ΪWindow���"�½�����"�����˵���
		windowMenu.add(newWindowAction);
		// ΪWindow���"Show View"�˵���
		windowMenu.add(showViewMenu);
		// ΪWindow���"��͸��ͼ�б�"�����˵���
		windowMenu.add(perspectiveAction);
		// ΪWindow���"����ѡ��"�����˵���
		windowMenu.add(preferenceAction);
		// ��Window�˵���ӵ��˵���
		menuBar.add(windowMenu);
		// ����Help�˵�
		MenuManager helpMenu = new MenuManager("&Help", " help");
		helpMenu.add(aboutAction);
		menuBar.add(helpMenu);
	}

	// --------------��ӹ�����----------------
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// ����������������ť����
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
