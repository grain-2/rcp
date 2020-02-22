/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
//import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.ViewPart;

public class View3 extends ViewPart {
	private Composite top = null;
	private Button button = null;

	public View3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout());
		button = new Button(top, SWT.NONE);
		button.setText("´ò¿ª¶àÒ³±à¼­Æ÷");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					getViewSite().getWorkbenchWindow().getActivePage()
							.openEditor(new NullEditorInput(),
									"com.mengqingchang.myplugin1.editor2");
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
	
	}
   
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
