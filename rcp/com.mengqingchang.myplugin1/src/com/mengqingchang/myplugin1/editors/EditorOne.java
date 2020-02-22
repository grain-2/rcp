/**
 *@author MengQingChang
 *Copyright 2007-10-28,MenqQingChang all rights reserved.
 */
package com.mengqingchang.myplugin1.editors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.ui.part.EditorPart;

public class EditorOne extends EditorPart {
	private TableViewer tv;
	private Table table;
	// 设置排序方式
	private boolean sort = true;
	// 定义过滤器对象
	private IsSexFilter isSexFilter;
	/**
	 * 用数组封装下拉框的值，设置成public以便于， 
	 * 在TableViewerCellModifier类中访问。 同样也可以将该数组封装在一个类中
	 */
	public static String[] departments = new String[] { "行政部", "财务部", "人事部",
			"市场部", "商务部", "技术部" };


	public EditorOne() {
		// TODO Auto-generated constructor stub
	}

	// 保存编辑器内容
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	// 另存为
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	// 初始化编辑器
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		// setPartName(input.getName());
		// setTitleImage(input.getImageDescriptor().createImage());

	}

	// 在上次被保存操作后，返回编辑内容是否再次被修改
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	// 是否支持“另存为”
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	 
	// 此方法用来向编辑器添加窗口部件
	public void createPartControl(Composite parent) {
		// 定义ViewForm容器
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		// 设置布局方式为充满方式
		viewForm.setLayout(new FillLayout());
		// 调用自定义方法，建立表查看器
		createTableViewer(viewForm);
		// 设置标签提供器
		tv.setLabelProvider(new TableViewerLableProvider());
		// 设置内容提供器
		tv.setContentProvider(new TabelViewerContentProvider());
		// 读入数据工厂中的数据
		tv.setInput(DataFactory.getFactoryData());
		// 实现排序功能
		tv.setSorter(new SortProvider());
		// 调用表格编辑自定义方法
		createCellModifier();
		// 定义表格过滤器
		isSexFilter = new IsSexFilter();
		// 定义工具栏对象
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		// 定义工具栏管理器
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		// 控制工具栏在ViewForm容器顶端显示
		viewForm.setTopLeft(toolBar);
		// 设置表格查看器的位置
		viewForm.setContent(tv.getControl());
		// 添加工具栏按钮操作
		toolBarManager.add(new filterAction());
		toolBarManager.add(new deleteAction());
		// 更新工具栏管理器，否则工具栏按钮不能显示
		toolBarManager.update(true);
		//在工作台工具栏为编辑器添加操作按钮
 	    IActionBars bars = getEditorSite().getActionBars();
		IToolBarManager iToolBar = bars.getToolBarManager();
        //添加分割符
		iToolBar.add(new Separator());
        //添加删除操作
		iToolBar.add( new deleteAction());
        //添加过滤操作
	 	iToolBar.add( new filterAction());

	}


	private void createTableViewer(ViewForm parent) {
		// 创建表格查看器
		tv = new TableViewer(parent, SWT.MULTI | SWT.FULL_SELECTION);
		table = tv.getTable();
		// 定义表格的列
		TableColumn c1 = new TableColumn(table, SWT.LEFT);
		// 设置列标题
		c1.setText("编号");
		c1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// sort取反操作，即升序与降序操作的转换
				sort = !sort;
				// 当为真时，字段进行升序排列，当为假时字段进行降序排列
				((SortProvider) tv.getSorter()).Sorter(sort ? -1 : 1);
				tv.refresh();
			}
		});

		// 设置列宽度
		c1.setWidth(90);
		TableColumn c2 = new TableColumn(table, SWT.LEFT);
		c2.setText("姓名");
		c2.setWidth(90);
		c2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				sort = !sort;
				((SortProvider) tv.getSorter()).Sorter(sort ? -2 : 2);
				tv.refresh();
			}
		});

		TableColumn c3 = new TableColumn(table, SWT.LEFT);
		c3.setText("性别");
		c3.setWidth(90);
		TableColumn c4 = new TableColumn(table, SWT.LEFT);
		c4.setText("年龄");
		c4.setWidth(90);
		c4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				sort = !sort;
				((SortProvider) tv.getSorter()).Sorter(sort ? -3 : 3);
				tv.refresh();
			}
		});

		TableColumn c5 = new TableColumn(table, SWT.LEFT);
		c5.setText("联系电话");
		c5.setWidth(90);
		TableColumn c6 = new TableColumn(table, SWT.LEFT);
		c6.setText("所在部门");
		c6.setWidth(90);
		TableColumn c7 = new TableColumn(table, SWT.LEFT);
		c7.setText("亲属");
		c7.setWidth(90);
		TableColumn c8 = new TableColumn(table, SWT.LEFT);
		c8.setText("登记时间");
		c8.setWidth(90);
		// 设置表头可见
		table.setHeaderVisible(true);
		// 设置表格行可见
		table.setLinesVisible(true);
//		WorkbenchHelp.setHelp(table, "com.mengqingchang.myplugin1.tableId");
	}

	// 建立表格单元修改器
	private void createCellModifier() {
		// CellEditor单元格编辑器类，设置8列编辑对象
		CellEditor[] cellEditor = new CellEditor[8];
		cellEditor[0] = null;
		cellEditor[1] = null;
		// 为第三列设置编辑器
		cellEditor[2] = new CheckboxCellEditor(table);
		// 为第四列设置编辑器
		cellEditor[3] = new TextCellEditor(table);
		cellEditor[4] = null;
		// 为第六列设置编辑器
		cellEditor[5] = new ComboBoxCellEditor(table, departments,
				SWT.READ_ONLY);
		cellEditor[6] = null;
		cellEditor[7] = null;
		// 设置列属性名称
		tv.setColumnProperties(new String[] { "ID", "NAME", "MALE", "AGE",
				"PHONE", "DEPART", "RELAT", "DATETIME" });
		// 为第四列设置文本单元格编辑器。将输入设置为数值型。
		Text text1 = (Text) cellEditor[3].getControl();
		text1.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				boolean textValue = ("0123456789".indexOf(e.text) >= 0);
				e.doit = textValue;
			}
		});

		// 设置表格单元的修改
		tv.setCellModifier(new TableViewerCellModifier(tv));
		// 设置单元格编辑器
		tv.setCellEditors(cellEditor);

	}
	   //设置按钮的操作类
	class filterAction extends Action {
		public filterAction() {
			// 提示性标签文字
			setToolTipText("过滤掉女员工记录");
			// 设置工具栏按钮图标
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_OPEN_MARKER));
		}
		public void run() {
			// 为表格查看器添加过滤操作
			tv.addFilter(isSexFilter);
		}
	}
	class deleteAction extends Action {
		public deleteAction() {
			setToolTipText("删除");
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		}
		public void run() {
			// 删除选择的表格记录
			table.remove(table.getSelectionIndices());
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
