/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class EditorOneInput implements IEditorInput {

	public EditorOneInput() {
		// TODO Auto-generated constructor stub
	}

	// ���ر༭�������Ƿ����
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	// ���������ͼ������
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
		/**
		 * return WorkbenchImages.getImageDescriptor(IWorkbenchGraphicConstants.IMG_
		 * ETOOL_IMPORT_WIZ);
		 */

	}

	// ���ر༭������������
	public String getName() {
		// TODO Auto-generated method stub
		return "Ա������";
	}

	// �����ܹ��������Ա���༭������״̬�Ķ���
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	// ���ر༭����������ʾ�����ֱ�ǩ
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "Ա������/Ա������";
	}

	// ���һ���༭����������
	public Object getAdapter(Class  arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
