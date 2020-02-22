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

	// 设置编辑器的内容
	public void createPartControl(Composite parent) {
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		viewForm.setLayout(new FillLayout());
		createTableViewer(viewForm);
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		viewForm.setTopLeft(toolBar);
		viewForm.setContent(tv.getControl());
		// 添加从具栏按钮操作
		toolBarManager.add(new AddDiagnoseInfo());
		toolBarManager.add(new UpdateDiagnoseInfo());
		toolBarManager.add(new DeleteDiagnoseInfo());
		toolBarManager.add(new RefreshDiagnoseInfo());
		toolBarManager.update(true);
		// 设置内容器
		tv.setContentProvider(new PatientIMSContentProvider());
		// 设置标签器
		tv.setLabelProvider(new DiagnoseInforTableLabelProvider());
		// 读入诊断表中的数据到表格中
		tv.setInput(DataBaseOperate.getDiagnoseInfo());
		// 设置表格排序器
		tv.setSorter(new PatientDiagnoseInforSort());

	}

	// 创建表格
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		// 设置列标题
		tc1.setText("ID号");
		tc1.setWidth(60);
		// 为ID号设置排序功能
		tc1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientDiagnoseInforSort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});
     	TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc2.setText("病人姓名");
		tc2.setWidth(80);

		TableColumn tc3 = new TableColumn(table, SWT.LEFT);

		tc3.setText("诊断结果");
		tc3.setWidth(80);

		TableColumn tc4 = new TableColumn(table, SWT.LEFT);
     	tc4.setText("诊断说明");
		tc4.setWidth(80);

		TableColumn tc5 = new TableColumn(table, SWT.LEFT);
    	tc5.setText("诊断日期");
		tc5.setWidth(80);
		// 为诊断日期设置排序功能
		tc5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientDiagnoseInforSort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();
			}
		});
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);
		tc6.setText("诊断医生");
		tc6.setWidth(80);

	}

	// 添加诊断信息操作类
	class AddDiagnoseInfo extends Action {
		public AddDiagnoseInfo() {

			setToolTipText("添加诊断信息");
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

	// 修改诊断信息操作了
	class UpdateDiagnoseInfo extends Action {
		public UpdateDiagnoseInfo() {

			setToolTipText("修改诊断信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/modify.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			//获得选择行第一列字段值，diagnoseID值。
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

	// 删除诊断信息操作类
	class DeleteDiagnoseInfo extends Action {
		public DeleteDiagnoseInfo() {

			setToolTipText("删除诊断信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/delete.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Diagnose diagnose = (Diagnose) selection.getFirstElement();
			DataBaseOperate db = new DataBaseOperate();
			if (MessageDialog.openConfirm(null, null, "真的要删除吗？")) {
				if (db.DeleteDiagnoseInfor(diagnose)) {
					List list = (List) tv.getInput();
					list.remove(diagnose);
					tv.remove(diagnose);
				}
			}
		}
	}

	// 重新读入诊断信息操作类
	class RefreshDiagnoseInfo extends Action {
		public RefreshDiagnoseInfo() {

			setToolTipText("刷新");
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
