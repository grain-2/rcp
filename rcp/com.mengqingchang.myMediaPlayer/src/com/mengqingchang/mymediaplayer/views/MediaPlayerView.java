/**
 *@author MengQingChang
 *Copyright  2007-11-27,MenqQingChang all rights reserved.
 */
package com.mengqingchang.mymediaplayer.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
 
import org.eclipse.ui.part.ViewPart;
public class MediaPlayerView extends ViewPart {
	static OleClientSite clientSite;
	@Override
	public void createPartControl(Composite parent) {
		/// TODO Auto-generated method stub
		try { // 定义OleFrame对象，OleFrame这里作为一个容器
			OleFrame frame = new OleFrame(parent, SWT.NONE);
			/**
			 * 创建一个ole嵌入面板,用于管理oleFrame面板，
			 * "WMPlayer.OCX"为progId值
			 * 
			 */
			clientSite = new OleClientSite(frame, SWT.NONE, "WMPlayer.OCX");
			// 激活控件
			clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
			// 自定义方法，用于设置菜单。
			addFileMenu(frame);
		} catch (SWTError e) {
			System.out.println("Unable to open activeX control");
			return;
		}

	}

	// 自定义方法，用于添加菜单
	static void addFileMenu(OleFrame frame) {
		// 获得Shell对象
		final Shell shell = frame.getShell();
		// 获得菜单栏
		Menu menuBar = shell.getMenuBar();
		// 如果菜单栏不存在，则创建一个菜单
		if (menuBar == null) {
			menuBar = new Menu(shell, SWT.BAR);
			shell.setMenuBar(menuBar);
		}
		// 定义菜单项
		MenuItem fileMenu = new MenuItem(menuBar, SWT.CASCADE);
		// 设置菜单文本
		fileMenu.setText("&File");
		Menu menuFile = new Menu(fileMenu);
		// 设置菜单
		fileMenu.setMenu(menuFile);
		/**
		 * 
		 * 指定菜单项，当OLE/ActiveX被激活时将在File菜单下显示,
		 * 即 将Open菜单项和Exit菜单项添加到File菜单下。
		 * 
		 */
		frame.setFileMenus(new MenuItem[] { fileMenu });

		MenuItem menuFileOpen = new MenuItem(menuFile, SWT.CASCADE);
		menuFileOpen.setText("&Open...");
		menuFileOpen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 调用自定义方法
				fileOpen();
			}
		});
		MenuItem menuFileExit = new MenuItem(menuFile, SWT.CASCADE);
		menuFileExit.setText("&Exit");
		menuFileExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 关闭窗口
				shell.dispose();
			}
		});
	 
	}

	// 自定义方法，实现打开文件的作用。
	static void fileOpen() {
		// 定义一个文件对话框
		FileDialog dialog = new FileDialog(clientSite.getShell(), SWT.OPEN);
		// 设置文件打开类型
		dialog.setFilterExtensions(new String[] { "*.*", "*.wmv", "*.mp3",
				"*.mpg", "*.aiv", "*.rm" });
		// 打开文件
		String filename = dialog.open();
		// 如果打开文件不为空，则执行下面的操作
		if (filename != null) {
			// 定义OleAutomation对象，用于对控件操作
			OleAutomation player = new OleAutomation(clientSite);
			// 获得控件的ID值
			int playID[] = player.getIDsOfNames(new String[] { "URL" });
			// 如果获得控件ID不为空，则执行下面的操作
			if (playID != null) {
				/**
				 * 
				 * 定义Variant对象，将filename封装在Variant中。
				 * Variant类在org.eclipse.swt.ole.win32包中，
				 * 该类包含了多中构造方法，可以将int,float,long,
				 * double,string等等基本数据类型封装为Variant，
				 * 
				 */
				Variant variantFile = new Variant(filename);
				// 设置属性
				player.setProperty(playID[0], variantFile);
			}
			player.dispose();
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
