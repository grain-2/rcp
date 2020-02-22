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
import com.mengqingchang.patientims.dialogs.AddExpenseInforWizard;
import com.mengqingchang.patientims.dialogs.ModifyExpenseInforDialog;
import com.mengqingchang.patientims.editors.provider.ExpenseInforTableLabelProvider;
import com.mengqingchang.patientims.editors.provider.PatientIMSContentProvider;
import com.mengqingchang.patientims.model.Expense;
import com.mengqingchang.patientims.sort.PatientExpenseInforSort;
 

public class ExpenseInforEditor extends EditorPart {
	private TableViewer tv;
	private boolean a = true;

	public void createPartControl(Composite parent) {
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		viewForm.setLayout(new FillLayout());
		createTableViewer(viewForm);
		// 设置编辑器工具栏
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		viewForm.setTopLeft(toolBar);
		viewForm.setContent(tv.getControl());
		// 添加工具栏按钮操作
		toolBarManager.add(new AddExpenseInfo());
		toolBarManager.add(new UpdateExpenseInfo());
		toolBarManager.add(new DeleteExpenseInfo());
		toolBarManager.add(new RefreshExpenseInfo());
		toolBarManager.update(true);
		// 设置内容提供器
		tv.setContentProvider(new PatientIMSContentProvider());
		// 设置标签提供器
		tv.setLabelProvider(new ExpenseInforTableLabelProvider());
		// 读入数据中的费用信息
		tv.setInput(DataBaseOperate.getExpenseInfo());
		// 设置表格排序器
		tv.setSorter(new PatientExpenseInforSort());
	}

	// 创建表格
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("ID号");
		tc1.setWidth(50);
		tc1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientExpenseInforSort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc2.setText("病人姓名");
		tc2.setWidth(80);
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);
		tc3.setText("费用类型");
		tc3.setWidth(80);
		TableColumn tc4 = new TableColumn(table, SWT.LEFT);
		tc4.setText("费用名称");
		tc4.setWidth(100);
		TableColumn tc5 = new TableColumn(table, SWT.LEFT);
		tc5.setText("单价");
		tc5.setWidth(60);
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);
		tc6.setText("数量");
		tc6.setWidth(40);
		TableColumn tc7 = new TableColumn(table, SWT.LEFT);
		tc7.setText("发生费用");
		tc7.setWidth(80);
		TableColumn tc8 = new TableColumn(table, SWT.LEFT);
		tc8.setText("费用发生时间");
		tc8.setWidth(100);
		tc8.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientExpenseInforSort) tv.getSorter()).doSort(a ? -8 : 8);
				tv.refresh();
			}
		});
		TableColumn tc9 = new TableColumn(table, SWT.LEFT);
		tc9.setText("医生签字");
		tc9.setWidth(80);

	}

	// 添加费用信息操作类
	class AddExpenseInfo extends Action {
		public AddExpenseInfo() {

			setToolTipText("添加费用信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/add.gif"));

		}

		public void run() {
			AddExpenseInforWizard wizard = new AddExpenseInforWizard();
			WizardDialog dialog = new WizardDialog(Display.getDefault()
					.getShells()[0], wizard);
			dialog.setPageSize(-1, 130);
			dialog.open();
		}
	}

	// 修改费用信息类
	class UpdateExpenseInfo extends Action {
		public UpdateExpenseInfo() {

			setToolTipText("修改费用信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/modify.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Expense expense = (Expense) selection.getFirstElement();
			if (expense == null)
				return;
			ModifyExpenseInforDialog md = new ModifyExpenseInforDialog(Display
					.getDefault().getShells()[0]);
			md.setExpense(expense);
			DataBaseOperate db = new DataBaseOperate();
			if (md.open() == IDialogConstants.OK_ID) {
				db.ModifyExpenseInfor(expense);
				tv.refresh(expense);
			}
		}
	}

	// 删除费用信息类
	class DeleteExpenseInfo extends Action {
		public DeleteExpenseInfo() {

			setToolTipText("删除费用信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/delete.gif"));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Expense expense = (Expense) selection.getFirstElement();
			DataBaseOperate db = new DataBaseOperate();
			if (MessageDialog.openConfirm(null, null, "真的要删除吗？")) {
				if (db.DeleteExpenseInfor(expense)) {
					List list = (List) tv.getInput();
					list.remove(expense);
					tv.remove(expense);
				}
			}
		}
	}
 	// 重信息读入费用信息操作类
	class RefreshExpenseInfo extends Action {
		public RefreshExpenseInfo() {

			setToolTipText("刷新");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/refresh.gif"));

		}

		public void run() {
			tv.setInput(DataBaseOperate.getExpenseInfo());
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
