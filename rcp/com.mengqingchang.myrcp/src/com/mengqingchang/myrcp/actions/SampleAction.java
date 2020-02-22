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
	
	// 激活具体操作
	public void run(IAction action) {
		try {
			window.run(true, true, new IRunnableWithProgress() {
				// 执行操作
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					// 开始执行任务
					monitor.beginTask("Running task", 60);
                    //60次循环
					for (int i = 60; i > 0; --i) {
						monitor.subTask("seconds left = " + i);
						if (monitor.isCanceled())
							break;
                        //间隔一秒
						Thread.sleep(1000);
                        //进度条前进一步
						monitor.worked(1);
					}
					// 指示操作完成
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
    //--------------------------下面方法空实现---------------------------------
	public void selectionChanged(IAction action, ISelection selection) {
	}
	public void dispose() {
	}
}
