/**
 *@author MengQingChang
 *Copyright  2007-11-21,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.views;

import org.eclipse.swt.SWT;
 
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

/**
 * @author MengQingChang
 * 
 */
public class SampleView2 extends ViewPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	 
	private Text text;
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
        //定义文本对象
		text=new Text(parent,SWT.BORDER);
		
	}
	//设置文本内容方法
    public void setContent(String content){
    	text.setText(content);
    }
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
