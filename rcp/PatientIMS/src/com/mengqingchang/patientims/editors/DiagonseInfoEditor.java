/**
 *@author MengQingChang
 *Copyright  2007-12-6,MenqQingChang all rights reserved.
 */
package com.mengqingchang.patientims.editors;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.dialogs.AddDiagnoseInforWizard;
import com.mengqingchang.patientims.dialogs.ModifyDiagnoseInforDialog;
import com.mengqingchang.patientims.editors.provider.DiagnoseInforTableLabelProvider;
import com.mengqingchang.patientims.editors.provider.PatientIMSContentProvider;
import com.mengqingchang.patientims.model.Diagnose;
import com.mengqingchang.patientims.sort.PatientDiagnoseInforSort;
 

public class DiagonseInfoEditor extends EditorPart {
	private TableViewer tv;
	private boolean a = true;

	// ���ñ༭��������
	public void createPartControl(Composite parent) {
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		viewForm.setLayout(new FillLayout());
		createTableViewer(viewForm);
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		viewForm.setTopLeft(toolBar);
		viewForm.setContent(tv.getControl());
		// ��ӴӾ�����ť����
		toolBarManager.add(new AddDiagnoseInfo());
		toolBarManager.add(new UpdateDiagnoseInfo());
		toolBarManager.add(new DeleteDiagnoseInfo());
		toolBarManager.add(new RefreshDiagnoseInfo());
		toolBarManager.update(true);
		// ����������
		tv.setContentProvider(new PatientIMSContentProvider());
		// ���ñ�ǩ��
		tv.setLabelProvider(new DiagnoseInforTableLabelProvider());
		// ������ϱ��е����ݵ������
		tv.setInput(DataBaseOperate.getDiagnoseInfo());
		// ���ñ��������
		tv.setSorter(new PatientDiagnoseInforSort());

	}

	// �������
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		// �����б���
		tc1.setText("ID��");
		tc1.setWidth(60);
		// ΪID������������
		tc1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientDiagnoseInforSort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});
     	TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc2.setText("��������");
		tc2.setWidth(80);

		TableColumn tc3 = new TableColumn(table, SWT.LEFT);

		tc3.setText("��Ͻ��");
		tc3.setWidth(80);

		TableColumn tc4 = new TableColumn(table, SWT.LEFT);
     	tc4.setText("���˵��");
		tc4.setWidth(80);

		TableColumn tc5 = new TableColumn(table, SWT.LEFT);
    	tc5.setText("�������");
		tc5.setWidth(80);
		// Ϊ�����������������
		tc5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientDiagnoseInforSort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();
			}
		});
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);
		tc6.setText("���ҽ��");
		tc6.setWidth(80);

	}

	// ��������Ϣ������
	class AddDiagnoseInfo extends Action {
		public AddDiagnoseInfo() {

			setToolTipText("��������Ϣ");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/add.gif"));

		}

		public void run() {
			AddDiagnoseInforWizard wizard = new AddDiagnoseInforWizard();
			WizardDialog dialog = new WizardDialog(Display.getDefault()
					.getShells()[0], wizard);
			dialog.setPageSize(-1, 130);
			dialog.open();
		}
	}

	// �޸������Ϣ������
	class UpdateDiagnoseInfo extends Action {
		public UpdateDiagnoseInfo() {

			setToolTipText("�޸������Ϣ");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/modify.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			//���ѡ���е�һ���ֶ�ֵ��diagnoseIDֵ��
			Diagnose diagnose = (Diagnose) selection.getFirstElement();
			if (diagnose == null)
				return;
			ModifyDiagnoseInforDialog md = new ModifyDiagnoseInforDialog(
					Display.getDefault().getShells()[0]);
			md.setDiagnose(diagnose);
			DataBaseOperate db = new DataBaseOperate();
			if (md.open() == IDialogConstants.OK_ID) {
				db.ModifyDiagnoseInfor(diagnose);
				tv.refresh(diagnose);
			}
		}
	}

	// ɾ�������Ϣ������
	class DeleteDiagnoseInfo extends Action {
		public DeleteDiagnoseInfo() {

			setToolTipText("ɾ�������Ϣ");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/delete.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Diagnose diagnose = (Diagnose) selection.getFirstElement();
			DataBaseOperate db = new DataBaseOperate();
			if (MessageDialog.openConfirm(null, null, "���Ҫɾ����")) {
				if (db.DeleteDiagnoseInfor(diagnose)) {
					List list = (List) tv.getInput();
					list.remove(diagnose);
					tv.remove(diagnose);
				}
			}
		}
	}

	// ���¶��������Ϣ������
	class RefreshDiagnoseInfo extends Action {
		public RefreshDiagnoseInfo() {

			setToolTipText("ˢ��");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/refresh.gif"));

		}

		public void run() {
			tv.setInput(DataBaseOperate.getDiagnoseInfo());
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		this.setSite(site);
		this.setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
