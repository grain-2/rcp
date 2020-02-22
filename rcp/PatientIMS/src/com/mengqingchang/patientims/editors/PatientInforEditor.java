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
		// 定义ViewForm对象
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		// 充满布局
		viewForm.setLayout(new FillLayout());
		// 调用自定义方法,创建表格
		createTableViewer(viewForm);
		// 定义工具栏
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		// 设置工具栏的位置
		viewForm.setTopLeft(toolBar);
		viewForm.setContent(tv.getControl());
		// 添加工具栏按钮
		toolBarManager.add(new ModifyAction());
		toolBarManager.add(new DeleteAction());
		toolBarManager.add(new RefreshAction());
		toolBarManager.update(true);
		// 设置内容器
		tv.setContentProvider(new PatientIMSContentProvider());
		// 设置标签器
		tv.setLabelProvider(new PatientInforTableLabelProvider());
		// 读入数据库中的数据到表格中
		tv.setInput(DataBaseOperate.getPatientInfo());
		// 设置表格排序器
		tv.setSorter(new PatientInforSort());
		// AddPatientInforWizard c = new AddPatientInforWizard(tv);

	}

	// --------------------创建表格-------------------
	private void createTableViewer(Composite parent) {
		tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		Table table = tv.getTable();
		// 设置表头可见
		table.setHeaderVisible(true);
		// 显示 表格线
		table.setLinesVisible(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		// 设置列标题
		tc1.setText("ID号");
		// 设置表格宽度
		tc1.setWidth(60);
		// 添加选择事件，使表格的列具有排序功能
		tc1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});

		TableColumn tc2 = new TableColumn(table, SWT.LEFT);

		tc2.setText("病人姓名");
		tc2.setWidth(80);
		tc2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -2 : 2);
				tv.refresh();

			}
		});
		TableColumn tc3 = new TableColumn(table, SWT.LEFT);

		tc3.setText("性别");
		tc3.setWidth(40);
		tc3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -3 : 3);
				tv.refresh();

			}
		});
		TableColumn tc4 = new TableColumn(table, SWT.LEFT);

		tc4.setText("年龄");
		tc4.setWidth(40);
		tc4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -4 : 4);
				tv.refresh();

			}
		});
		TableColumn tc5 = new TableColumn(table, SWT.LEFT);

		tc5.setText("电话");
		tc5.setWidth(80);
		tc5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();

			}
		});
		TableColumn tc6 = new TableColumn(table, SWT.LEFT);

		tc6.setText("科室");
		tc6.setWidth(80);

		TableColumn tc7 = new TableColumn(table, SWT.LEFT);
		tc7.setText("病房号");
		tc7.setWidth(60);

		TableColumn tc8 = new TableColumn(table, SWT.LEFT);

		tc8.setText("床位号");
		tc8.setWidth(60);

		TableColumn tc9 = new TableColumn(table, SWT.LEFT);

		tc9.setText("病人家庭住址");
		tc9.setWidth(80);
		tc9.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -9 : 9);
				tv.refresh();

			}
		});
		TableColumn tc10 = new TableColumn(table, SWT.LEFT);

		tc10.setText("入院时间");
		tc10.setWidth(80);
		tc10.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((PatientInforSort) tv.getSorter()).doSort(a ? -10 : 10);
				tv.refresh();

			}
		});
	}

	// 删除操作类
	class DeleteAction extends Action {
		public DeleteAction() {
			// 提示文本信息
			setToolTipText("删除病人信息");
			// 设置工具栏按钮图标
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		}

		public void run() {
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			// 获取当前选择行的第一个元素，即ID号，作为Patient对象。
			Patient patient = (Patient) selection.getFirstElement();
			DataBaseOperate db = new DataBaseOperate();
			if (MessageDialog.openConfirm(null, null, "真的要删除吗？")) {
				if (db.DeletePatientInfor(patient)) {
					List list = (List) tv.getInput();
					// 将list集合中的数据删除。
					list.remove(patient);
					// 将表格数据删除
					tv.remove(patient);
				}
			}
		}
	}

	// 修改操作类
	class ModifyAction extends Action {
		public ModifyAction() {
			setToolTipText("修改病人病房信息");
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
				// 修改操作，修改数据库中的数据
				db.ModifyPatientInfor(patient);
				tv.refresh(patient);
			}

		}
	}

	class RefreshAction extends Action {
		public RefreshAction() {
			setToolTipText("刷新信息");
			setImageDescriptor(com.mengqingchang.patientims.Activator
					.getImageDescriptor("/icons/refresh.gif"));
		}

		public void run() {
			// 重新读入数据库数据
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
