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
	// ��������ʽ
	private boolean sort = true;
	// �������������
	private IsSexFilter isSexFilter;
	/**
	 * �������װ�������ֵ�����ó�public�Ա��ڣ� 
	 * ��TableViewerCellModifier���з��ʡ� ͬ��Ҳ���Խ��������װ��һ������
	 */
	public static String[] departments = new String[] { "������", "����", "���²�",
			"�г���", "����", "������" };


	public EditorOne() {
		// TODO Auto-generated constructor stub
	}

	// ����༭������
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	// ���Ϊ
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	// ��ʼ���༭��
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		// setPartName(input.getName());
		// setTitleImage(input.getImageDescriptor().createImage());

	}

	// ���ϴα���������󣬷��ر༭�����Ƿ��ٴα��޸�
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	// �Ƿ�֧�֡����Ϊ��
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	 
	// �˷���������༭����Ӵ��ڲ���
	public void createPartControl(Composite parent) {
		// ����ViewForm����
		ViewForm viewForm = new ViewForm(parent, SWT.NONE);
		// ���ò��ַ�ʽΪ������ʽ
		viewForm.setLayout(new FillLayout());
		// �����Զ��巽����������鿴��
		createTableViewer(viewForm);
		// ���ñ�ǩ�ṩ��
		tv.setLabelProvider(new TableViewerLableProvider());
		// ���������ṩ��
		tv.setContentProvider(new TabelViewerContentProvider());
		// �������ݹ����е�����
		tv.setInput(DataFactory.getFactoryData());
		// ʵ��������
		tv.setSorter(new SortProvider());
		// ���ñ��༭�Զ��巽��
		createCellModifier();
		// �����������
		isSexFilter = new IsSexFilter();
		// ���幤��������
		ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT);
		// ���幤����������
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		// ���ƹ�������ViewForm����������ʾ
		viewForm.setTopLeft(toolBar);
		// ���ñ��鿴����λ��
		viewForm.setContent(tv.getControl());
		// ��ӹ�������ť����
		toolBarManager.add(new filterAction());
		toolBarManager.add(new deleteAction());
		// ���¹����������������򹤾�����ť������ʾ
		toolBarManager.update(true);
		//�ڹ���̨������Ϊ�༭����Ӳ�����ť
 	    IActionBars bars = getEditorSite().getActionBars();
		IToolBarManager iToolBar = bars.getToolBarManager();
        //��ӷָ��
		iToolBar.add(new Separator());
        //���ɾ������
		iToolBar.add( new deleteAction());
        //��ӹ��˲���
	 	iToolBar.add( new filterAction());

	}


	private void createTableViewer(ViewForm parent) {
		// �������鿴��
		tv = new TableViewer(parent, SWT.MULTI | SWT.FULL_SELECTION);
		table = tv.getTable();
		// ���������
		TableColumn c1 = new TableColumn(table, SWT.LEFT);
		// �����б���
		c1.setText("���");
		c1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// sortȡ���������������뽵�������ת��
				sort = !sort;
				// ��Ϊ��ʱ���ֶν����������У���Ϊ��ʱ�ֶν��н�������
				((SortProvider) tv.getSorter()).Sorter(sort ? -1 : 1);
				tv.refresh();
			}
		});

		// �����п��
		c1.setWidth(90);
		TableColumn c2 = new TableColumn(table, SWT.LEFT);
		c2.setText("����");
		c2.setWidth(90);
		c2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				sort = !sort;
				((SortProvider) tv.getSorter()).Sorter(sort ? -2 : 2);
				tv.refresh();
			}
		});

		TableColumn c3 = new TableColumn(table, SWT.LEFT);
		c3.setText("�Ա�");
		c3.setWidth(90);
		TableColumn c4 = new TableColumn(table, SWT.LEFT);
		c4.setText("����");
		c4.setWidth(90);
		c4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				sort = !sort;
				((SortProvider) tv.getSorter()).Sorter(sort ? -3 : 3);
				tv.refresh();
			}
		});

		TableColumn c5 = new TableColumn(table, SWT.LEFT);
		c5.setText("��ϵ�绰");
		c5.setWidth(90);
		TableColumn c6 = new TableColumn(table, SWT.LEFT);
		c6.setText("���ڲ���");
		c6.setWidth(90);
		TableColumn c7 = new TableColumn(table, SWT.LEFT);
		c7.setText("����");
		c7.setWidth(90);
		TableColumn c8 = new TableColumn(table, SWT.LEFT);
		c8.setText("�Ǽ�ʱ��");
		c8.setWidth(90);
		// ���ñ�ͷ�ɼ�
		table.setHeaderVisible(true);
		// ���ñ���пɼ�
		table.setLinesVisible(true);
//		WorkbenchHelp.setHelp(table, "com.mengqingchang.myplugin1.tableId");
	}

	// �������Ԫ�޸���
	private void createCellModifier() {
		// CellEditor��Ԫ��༭���࣬����8�б༭����
		CellEditor[] cellEditor = new CellEditor[8];
		cellEditor[0] = null;
		cellEditor[1] = null;
		// Ϊ���������ñ༭��
		cellEditor[2] = new CheckboxCellEditor(table);
		// Ϊ���������ñ༭��
		cellEditor[3] = new TextCellEditor(table);
		cellEditor[4] = null;
		// Ϊ���������ñ༭��
		cellEditor[5] = new ComboBoxCellEditor(table, departments,
				SWT.READ_ONLY);
		cellEditor[6] = null;
		cellEditor[7] = null;
		// ��������������
		tv.setColumnProperties(new String[] { "ID", "NAME", "MALE", "AGE",
				"PHONE", "DEPART", "RELAT", "DATETIME" });
		// Ϊ�����������ı���Ԫ��༭��������������Ϊ��ֵ�͡�
		Text text1 = (Text) cellEditor[3].getControl();
		text1.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				boolean textValue = ("0123456789".indexOf(e.text) >= 0);
				e.doit = textValue;
			}
		});

		// ���ñ��Ԫ���޸�
		tv.setCellModifier(new TableViewerCellModifier(tv));
		// ���õ�Ԫ��༭��
		tv.setCellEditors(cellEditor);

	}
	   //���ð�ť�Ĳ�����
	class filterAction extends Action {
		public filterAction() {
			// ��ʾ�Ա�ǩ����
			setToolTipText("���˵�ŮԱ����¼");
			// ���ù�������ťͼ��
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_OPEN_MARKER));
		}
		public void run() {
			// Ϊ���鿴����ӹ��˲���
			tv.addFilter(isSexFilter);
		}
	}
	class deleteAction extends Action {
		public deleteAction() {
			setToolTipText("ɾ��");
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		}
		public void run() {
			// ɾ��ѡ��ı���¼
			table.remove(table.getSelectionIndices());
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
