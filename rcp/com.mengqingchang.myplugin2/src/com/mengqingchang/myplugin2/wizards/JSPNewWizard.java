package com.mengqingchang.myplugin2.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "jsp". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 */

public class JSPNewWizard extends Wizard implements INewWizard {
	private JSPNewWizardPage page;
	private ISelection selection;

	// 构造函数
	public JSPNewWizard() {
		super();
		// 为向导设置进度监视
		setNeedsProgressMonitor(true);
	}

	// 添加向导页
	public void addPages() {
		page = new JSPNewWizardPage(selection);
		addPage(page);
	}

	/**
	 * 当用户单击向导中的 Finish 按钮时将调用 performFinish() 方法。
	 * 在执行一些验证之后，通过IRunnableWithProgress 接口
	 * 调用 doFinish() 方法它将执行创建操作，并且进行进度监视。
	 */
	public boolean performFinish() {
		//获得容器名（一般为项目名）
		final String containerName = page.getContainerName();
		//获取创建的JSP文件名
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {//调用doFinish方法
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}
		return true;
	}
 	/**
	 * 创建一个JSP文件，并通过 IDE 中的编辑器打开新文件
	 *  
 	 */
 	private void doFinish(String containerName, String fileName,
			IProgressMonitor monitor) throws CoreException {
		// 创建文件
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName
					+ "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	/**
	 * 初始化一个JSP文件模版
	 */
 	private InputStream openContentStream() {
 		//设置JSP文件模版路径
		String contents = "/JSP-Stencil.resource";
		return this.getClass().getResourceAsStream(contents);

	}
     //异常处理
	private void throwCoreException(String message) throws CoreException {
		IStatus status = new Status(IStatus.ERROR,
				"com.mengqingchang.myplugin2", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * init()方法由工作台直接调用 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}