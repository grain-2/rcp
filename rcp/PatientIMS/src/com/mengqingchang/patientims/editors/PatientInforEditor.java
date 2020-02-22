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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import com.mengqingchang.patientims.database.DataBaseOperate;
import com.mengqingchang.patientims.dialogs.ModifyPatientInforDialog;
import com.mengqingchang.patientims.editors.provider.PatientIMSContentProvider;
import com.mengqingchang.patientims.editors.provider.PatientInforTableLabelProvider;
import com.mengqingchang.patientims.model.Patient;
import com.mengqingchang.patientims.sort.PatientInforSort;

public class PatientInforEditor extends EditorPart {
	private TableViewer tv;
	private boolean a = true;

	@Override
	public void createPartControl(Composite parent) {
		// ����ViewForm����
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		// ��������
		viewForm.setLayout(new FillLayout());
		// �����Զ��巽��,�������
		createTableViewer(viewForm);
		// ���幤����
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		// ���ù�������λ��
		viewForm.setTopLeft(toolBar);
		viewForm.setContent(tv.getControl());
		// ��ӹ�������ť
		toolBarManager.add(new ModifyAction());
		toolBarManager.add(new DeleteAction());
		toolBarManager.add(new RefreshAction());
		toolBarManager.update(true);
		// ����������
		tv.setContentProvider(new PatientIMSContentProvider());
		// ���ñ�ǩ��
		tv.setLabelProvider(new PatientInforTableLabelProvider());
		// �������ݿ��е����ݵ������
		tv.setInput(DataBaseOperate.getPatientInfo());
		// ���ñ��������
		tv.setSorter(new PatientInforSort());
		// AddPatientInforWizard c = new AddPatientInforWizard(tv);

	}

	// --------------------�������-------------------
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		// ���ñ�ͷ�ɼ�
		table.setHeaderVisible(true);
		// ��ʾ �����
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		// �����б���
		tc1.setText("ID��");
		// ���ñ����
		tc1.setWidth(60);
		// ���ѡ���¼���ʹ�����о���������
		tc1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});

		TableColumn tc2 = new TableColumn(table, SWT.LEFT);

		tc2.setText("��������");
		tc2.setWidth(80);
		tc2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -2 : 2);
				tv.refresh();

			}
		});
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);

		tc3.setText("�Ա�");
		tc3.setWidth(40);
		tc3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -3 : 3);
				tv.refresh();

			}
		});
		TableColumn tc4 = new TableColumn(table, SWT.LEFT);

		tc4.setText("����");
		tc4.setWidth(40);
		tc4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -4 : 4);
				tv.refresh();

			}
		});
		TableColumn tc5 = new TableColumn(table, SWT.LEFT);

		tc5.setText("�绰");
		tc5.setWidth(80);
		tc5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();

			}
		});
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);

		tc6.setText("����");
		tc6.setWidth(80);

		TableColumn tc7 = new TableColumn(table, SWT.LEFT);
		tc7.setText("������");
		tc7.setWidth(60);

		TableColumn tc8 = new TableColumn(table, SWT.LEFT);

		tc8.setText("��λ��");
		tc8.setWidth(60);

		TableColumn tc9 = new TableColumn(table, SWT.LEFT);

		tc9.setText("���˼�ͥסַ");
		tc9.setWidth(80);
		tc9.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -9 : 9);
				tv.refresh();

			}
		});
		TableColumn tc10 = new TableColumn(table, SWT.LEFT);

		tc10.setText("��Ժʱ��");
		tc10.setWidth(80);
		tc10.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -10 : 10);
				tv.refresh();

			}
		});
	}

	// ɾ��������
	class DeleteAction extends Action {
		public DeleteAction() {
			// ��ʾ�ı���Ϣ
			setToolTipText("ɾ��������Ϣ");
			// ���ù�������ťͼ��
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			// ��ȡ��ǰѡ���еĵ�һ��Ԫ�أ���ID�ţ���ΪPatient����
			Patient patient = (Patient) selection.getFirstElement();
			DataBaseOperate db = new DataBaseOperate();
			if (MessageDialog.openConfirm(null, null, "���Ҫɾ����")) {
				if (db.DeletePatientInfor(patient)) {
					List list = (List) tv.getInput();
					// ��list�����е�����ɾ����
					list.remove(patient);
					// ���������ɾ��
					tv.remove(patient);
				}
			}
		}
	}

	// �޸Ĳ�����
	class ModifyAction extends Action {
		public ModifyAction() {
			setToolTipText("�޸Ĳ��˲�����Ϣ");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/modify.gif"));
		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Patient patient = (Patient) selection.getFirstElement();
			if (patient == null)
				return;
			ModifyPatientInforDialog md = new ModifyPatientInforDialog(Display
					.getDefault().getShells()[0]);
			md.setPatient(patient);
			DataBaseOperate db = new DataBaseOperate();
			if (md.open() == IDialogConstants.OK_ID) {
				// �޸Ĳ������޸����ݿ��е�����
				db.ModifyPatientInfor(patient);
				tv.refresh(patient);
			}

		}
	}

	class RefreshAction extends Action {
		public RefreshAction() {
			setToolTipText("ˢ����Ϣ");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/refresh.gif"));
		}

		public void run() {
			// ���¶������ݿ�����
			tv.setInput(DataBaseOperate.getPatientInfo());

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
