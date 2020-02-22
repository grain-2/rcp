package com.myplugin.helloworld;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * �����(�������ࣩ���ڿ��Ʋ���������ڣ��̳���AbstractUIPlugin��
 */
public class Activator extends AbstractUIPlugin {

	// ���ID��ʶ
	public static final String PLUGIN_ID = "com.myplugin.helloworld";

	// ��������
	private static Activator plugin;

	/**
	 * ���캯��
	 */
	public Activator() {
	}

	/*
	 * �������
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * ֹͣ���
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * ���ز�������
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * ����һ��������������·����ͼ���ļ�
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
