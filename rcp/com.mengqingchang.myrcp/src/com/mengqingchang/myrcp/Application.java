package com.mengqingchang.myrcp;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(
	 *      org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
			if(!preOpen())
				return IApplication.EXIT_OK;
			int returnCode = PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());
		
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else  
				 return IApplication.EXIT_OK;
				
				 
		} finally {
			display.dispose();
		}

	}
	public boolean preOpen() { 
        
        MessageBox msgBox = new MessageBox(new Shell(), SWT.YES|SWT.NO|SWT.ICON_QUESTION); 
        msgBox.setText("Open System"); 
        msgBox.setMessage("Click Yes buttom setup system."); 
        if(msgBox.open()==SWT.YES){ 
            return true; 
        } 
        return false; 
    } 
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
