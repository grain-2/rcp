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
		try { // ����OleFrame����OleFrame������Ϊһ������
			OleFrame frame = new OleFrame(parent, SWT.NONE);
			/**
			 * ����һ��oleǶ�����,���ڹ���oleFrame��壬
			 * "WMPlayer.OCX"ΪprogIdֵ
			 * 
			 */
			clientSite = new OleClientSite(frame, SWT.NONE, "WMPlayer.OCX");
			// ����ؼ�
			clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
			// �Զ��巽�����������ò˵���
			addFileMenu(frame);
		} catch (SWTError e) {
			System.out.println("Unable to open activeX control");
			return;
		}

	}

	// �Զ��巽����������Ӳ˵�
	static void addFileMenu(OleFrame frame) {
		// ���Shell����
		final Shell shell = frame.getShell();
		// ��ò˵���
		Menu menuBar = shell.getMenuBar();
		// ����˵��������ڣ��򴴽�һ���˵�
		if (menuBar == null) {
			menuBar = new Menu(shell, SWT.BAR);
			shell.setMenuBar(menuBar);
		}
		// ����˵���
		MenuItem fileMenu = new MenuItem(menuBar, SWT.CASCADE);
		// ���ò˵��ı�
		fileMenu.setText("&File");
		Menu menuFile = new Menu(fileMenu);
		// ���ò˵�
		fileMenu.setMenu(menuFile);
		/**
		 * 
		 * ָ���˵����OLE/ActiveX������ʱ����File�˵�����ʾ,
		 * �� ��Open�˵����Exit�˵�����ӵ�File�˵��¡�
		 * 
		 */
		frame.setFileMenus(new MenuItem[] { fileMenu });

		MenuItem menuFileOpen = new MenuItem(menuFile, SWT.CASCADE);
		menuFileOpen.setText("&Open...");
		menuFileOpen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// �����Զ��巽��
				fileOpen();
			}
		});
		MenuItem menuFileExit = new MenuItem(menuFile, SWT.CASCADE);
		menuFileExit.setText("&Exit");
		menuFileExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// �رմ���
				shell.dispose();
			}
		});
	 
	}

	// �Զ��巽����ʵ�ִ��ļ������á�
	static void fileOpen() {
		// ����һ���ļ��Ի���
		FileDialog dialog = new FileDialog(clientSite.getShell(), SWT.OPEN);
		// �����ļ�������
		dialog.setFilterExtensions(new String[] { "*.*", "*.wmv", "*.mp3",
				"*.mpg", "*.aiv", "*.rm" });
		// ���ļ�
		String filename = dialog.open();
		// ������ļ���Ϊ�գ���ִ������Ĳ���
		if (filename != null) {
			// ����OleAutomation�������ڶԿؼ�����
			OleAutomation player = new OleAutomation(clientSite);
			// ��ÿؼ���IDֵ
			int playID[] = player.getIDsOfNames(new String[] { "URL" });
			// �����ÿؼ�ID��Ϊ�գ���ִ������Ĳ���
			if (playID != null) {
				/**
				 * 
				 * ����Variant���󣬽�filename��װ��Variant�С�
				 * Variant����org.eclipse.swt.ole.win32���У�
				 * ��������˶��й��췽�������Խ�int,float,long,
				 * double,string�ȵȻ����������ͷ�װΪVariant��
				 * 
				 */
				Variant variantFile = new Variant(filename);
				// ��������
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
