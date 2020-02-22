package com.myplugin.helloworld;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * 插件类(激活器类）用于控制插件生命周期，继承了AbstractUIPlugin类
 */
public class Activator extends AbstractUIPlugin {

	// 插件ID标识
	public static final String PLUGIN_ID = "com.myplugin.helloworld";

	// 插件类对象
	private static Activator plugin;

	/**
	 * 构造函数
	 */
	public Activator() {
	}

	/*
	 * 启动插件
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * 停止插件
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * 返回插件类对象
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * 返回一个按给定插件相对路径的图像文件
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
