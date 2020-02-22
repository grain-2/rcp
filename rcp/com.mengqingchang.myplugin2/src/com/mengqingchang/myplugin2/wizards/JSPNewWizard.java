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

	// ���캯��
	public JSPNewWizard() {
		super();
		// Ϊ�����ý��ȼ���
		setNeedsProgressMonitor(true);
	}

	// �����ҳ
	public void addPages() {
		page = new JSPNewWizardPage(selection);
		addPage(page);
	}

	/**
	 * ���û��������е� Finish ��ťʱ������ performFinish() ������
	 * ��ִ��һЩ��֤֮��ͨ��IRunnableWithProgress �ӿ�
	 * ���� doFinish() ��������ִ�д������������ҽ��н��ȼ��ӡ�
	 */
	public boolean performFinish() {
		//�����������һ��Ϊ��Ŀ����
		final String containerName = page.getContainerName();
		//��ȡ������JSP�ļ���
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {//����doFinish����
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
	 * ����һ��JSP�ļ�����ͨ�� IDE �еı༭�������ļ�
	 *  
 	 */
 	private void doFinish(String containerName, String fileName,
			IProgressMonitor monitor) throws CoreException {
		// �����ļ�
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
	 * ��ʼ��һ��JSP�ļ�ģ��
	 */
 	private InputStream openContentStream() {
 		//����JSP�ļ�ģ��·��
		String contents = "/JSP-Stencil.resource";
		return this.getClass().getResourceAsStream(contents);

	}
     //�쳣����
	private void throwCoreException(String message) throws CoreException {
		IStatus status = new Status(IStatus.ERROR,
				"com.mengqingchang.myplugin2", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * init()�����ɹ���ֱ̨�ӵ��� 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}