

/**
 *@author MengQingChang
 *Copyright  2007-11-24,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myrcp.actions;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.core.runtime.Status;

import org.eclipse.core.runtime.jobs.Job;
 




public class ProgressIndicatorAction implements IWorkbenchWindowActionDelegate {

	@Override
	public void init(IWorkbenchWindow window) {

		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		//定义一个Job对象
		Job job = new Job("Job Status") {

			@Override
			public IStatus run(IProgressMonitor monitor) {
				// 开始执行任务
				monitor.beginTask("Please wait for .....", 40);

				for (int i = 40; i > 0; --i) {

					monitor.subTask("The jobs second left " + i);
					if (monitor.isCanceled())
						break;
					try {// 间隔一秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 进度条前进一步
					monitor.worked(1);

				}
				// 指示操作完成
				monitor.done();
				return Status.OK_STATUS;

			}

		};
		// 使工作被初始化为最终用户
		job.setUser(true);
		//使工作被运行成进度表
		job.schedule();

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {

		// TODO Auto-generated method stub

	}

}


