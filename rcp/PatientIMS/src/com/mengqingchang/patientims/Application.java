package com.mengqingchang.patientims;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.dialogs.LoginDialog;
import com.mengqingchang.patientims.model.Doctor;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
			/**
			 * ����preOpen������֤�û��ĺϷ��ԣ� 
			 * ����û��������벻��ȷ���˳�����
			 */
			if (!preOpen())
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
   //�ж��û����������Ƿ��Ѿ����ڡ�
	public boolean preOpen() {
		// ���õ�¼�Ի���
		LoginDialog ld = new LoginDialog(null);
		//����Dcctor����
    	Doctor doctor = new Doctor();
		ld.setDoctor(doctor);
		//�򿪵�¼�Ի���
		if (ld.open() == IDialogConstants.OK_ID) {
			//�����ݿ���ȥ��֤��Ϣ
			doctor = DataBaseOperate.getLoginInfor(doctor);
			if (doctor == null) {
				MessageDialog.openInformation(null, null, "����ȷ��д��Ϣ��������");
				return false;
			}
			if (doctor != null) {
				return true;
			}
		}
		return false;
	}

}
