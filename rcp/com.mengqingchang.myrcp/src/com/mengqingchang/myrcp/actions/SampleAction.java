package com.mengqingchang.myrcp.actions;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	public SampleAction() {
	}
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
	// ����������
	public void run(IAction action) {
		try {
			window.run(true, true, new IRunnableWithProgress() {
				// ִ�в���
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					// ��ʼִ������
					monitor.beginTask("Running task", 60);
                    //60��ѭ��
					for (int i = 60; i > 0; --i) {
						monitor.subTask("seconds left = " + i);
						if (monitor.isCanceled())
							break;
                        //���һ��
						Thread.sleep(1000);
                        //������ǰ��һ��
						monitor.worked(1);
					}
					// ָʾ�������
					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //--------------------------���淽����ʵ��---------------------------------
	public void selectionChanged(IAction action, ISelection selection) {
	}
	public void dispose() {
	}
}
