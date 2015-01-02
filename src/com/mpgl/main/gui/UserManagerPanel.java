package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
import com.mpgl.main.component.BasePanel;
import com.mpgl.main.component.Combobox;
import com.mpgl.main.component.ComboboxModel;
import com.mpgl.main.component.PagePanel;
import com.mpgl.main.component.SIZE;
import com.mpgl.main.component.TableModel;
import com.mpgl.util.Constant;
import com.mpgl.vo.Form;
import com.mpgl.vo.PageVo;
import com.mpgl.vo.UserVo;

/**
 * 用户管理面板
 * 
 * @author 廖陈特
 * 
 */
public class UserManagerPanel extends BasePanel {
	
	private static final long serialVersionUID = 5117866745557381496L;

	/**
	 * 日志
	 */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(UserManagerPanel.class);

	/**
	 * 标志位-下拉框数据是否加载
	 */
	private boolean isLoadComboboxData = false;

	/**
	 * 工具栏面板
	 */
	private JPanel bar;

	/**
	 * 菜单栏面板
	 */
	private JPanel menuBar;

	/**
	 * 新增按钮
	 */
	private JButton buttonAdd;

	/**
	 * 修改按钮
	 */
	private JButton buttonEdit;

	/**
	 * 删除按钮
	 */
	private JButton buttonDel;

	/**
	 * 查询面板
	 */
	private JPanel searchBar;

	/**
	 * 查询按钮
	 */
	private JButton buttonQuery;

	/**
	 * 重置按钮
	 */
	private JButton buttonReset;

	/**
	 * 用户名
	 */
	private JLabel labelUsername;

	/**
	 * 查询字段-用户名
	 */
	private JTextField textUsername;

	/**
	 * 实际姓名
	 */
	private JLabel labelName;

	/**
	 * 查询字段-实际姓名
	 */
	private JTextField textName;

	/**
	 * 角色
	 */
	private JLabel labelRole;

	/**
	 * 查询字段-角色
	 */
	private Combobox comboboxRole;

	/**
	 * 是否锁定
	 */
	private JLabel labelIsLock;

	/**
	 * 查询字段-是否锁定
	 */
	private Combobox comboboxIsLock;

	/**
	 * 内容面板
	 */
	private JPanel panelContent;

	/**
	 * 表格滚动条
	 */
	private JScrollPane scrollTable;

	/**
	 * 表格
	 */
	private JTable table;

	/**
	 * 分页面板
	 */
	private PagePanel pagePanel;

	/**
	 * 构造函数
	 */
	public UserManagerPanel() {
		this.setLayout(new BorderLayout());
		initBar();
		initTable();
		initPagePanel();
	}

	/**
	 * 初始化工具栏
	 */
	private void initBar() {
		bar = new JPanel(new BorderLayout());

		menuBar = new JPanel();
		buttonAdd = new JButton(Constant.BUTTON.ADD, Constant.iconAdd);
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerPanel.this.add();
			}
		});
		buttonEdit = new JButton(Constant.BUTTON.EDIT, Constant.iconEdit);
		buttonEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerPanel.this.edit();
			}
		});
		buttonDel = new JButton(Constant.BUTTON.DEL, Constant.iconCancel);
		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerPanel.this.delete();
			}
		});
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(buttonAdd);
		menuBar.add(buttonEdit);
		menuBar.add(buttonDel);

		searchBar = new JPanel();
		searchBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelUsername = new JLabel("用户名:");
		textUsername = new JTextField(SIZE.TEXTFIELD.SPAN10);
		labelName = new JLabel("实际姓名:");
		textName = new JTextField(SIZE.TEXTFIELD.SPAN10);
		labelRole = new JLabel("角色:");
		comboboxRole = new Combobox();
		comboboxRole.setPreferredSize(SIZE.COMBOBOX.SPAN80);
		labelIsLock = new JLabel("是否锁定:");
		comboboxIsLock = new Combobox();
		comboboxIsLock.setPreferredSize(SIZE.COMBOBOX.SPAN80);
		searchBar.add(labelUsername);
		searchBar.add(textUsername);
		searchBar.add(labelName);
		searchBar.add(textName);
		searchBar.add(labelRole);
		searchBar.add(comboboxRole);
		searchBar.add(labelIsLock);
		searchBar.add(comboboxIsLock);

		buttonQuery = new JButton(Constant.BUTTON.QUERY, Constant.iconQuery);
		buttonQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerPanel.this.loadData();
			}
		});
		buttonReset = new JButton(Constant.BUTTON.RESET, Constant.iconReset);
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerPanel.this.reset();
			}
		});
		searchBar.add(buttonQuery);
		searchBar.add(buttonReset);
		bar.add(menuBar, BorderLayout.NORTH);
		bar.add(searchBar, BorderLayout.CENTER);
		this.add(bar, BorderLayout.NORTH);
	}

	/**
	 * 初始化Table
	 */
	private void initTable() {
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		scrollTable = new JScrollPane(table);
		panelContent = new JPanel(new BorderLayout());
		panelContent.add(scrollTable, BorderLayout.CENTER);
		panelContent.add(new Panel(), BorderLayout.SOUTH);
		this.add(panelContent, BorderLayout.CENTER);
	}

	/**
	 * 初始化Table的列宽
	 */
	private void initTableColumnWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		for (int i = 2; i < Constant.TABLE.USER_COLUMNS.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}

	/**
	 * 初始化分页面板
	 */
	private void initPagePanel() {
		pagePanel = new PagePanel(this, this.getForm());
		this.add(pagePanel, BorderLayout.SOUTH);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void queryGridData() {
		Map<String, Object> map = mainService.queryUserDataGrid(this.getForm());
		List<Map<String, Object>> list = (List<Map<String, Object>>) map
				.get(Constant.ROW_KEY);
		TableModel model = new TableModel(Constant.TABLE.USER_COLUMNS,
				Constant.TABLE.USER_KEYS, list);
		this.getForm().setDictionaryKey("isLock");
		// 把数据中一些数字转成文字,类似Easyui的Formatter
		model.formatter("isLock",
				mainService.queryDictionaryByKey(this.getForm()));
		table.setModel(model);
		this.initTableColumnWidth();
		// 初始化分页面板
		int count = Integer.parseInt(map.get(Constant.ROW_TOTAL).toString());
		PageVo page = this.getForm().getPage();
		page.setCountData(count);
		pagePanel.loadData();
	}

	@Override
	public void loadData() {
		if (!isLoadComboboxData) {
			loadComboboxData();
			isLoadComboboxData = true;
		}
		PageVo pageVo = new PageVo();
		pageVo.setPageIndex(0);
		this.form.setPage(pageVo);
		queryGridData();
	}

	/**
	 * 初始化下拉框的值
	 */
	private void loadComboboxData() {
		this.form.setDictionaryKey("isLock");
		ComboboxModel modelIsLock = new ComboboxModel(
				mainService.queryDictionaryByKey(form));
		comboboxIsLock.setModel(modelIsLock);
		ComboboxModel modelRole = new ComboboxModel(mainService.queryRoleList());
		comboboxRole.setModel(modelRole);
	}

	/**
	 * 获取表单参数
	 */
	public Form getForm() {
		if (this.form.getPage() == null) {
			this.form.setPage(new PageVo());
		}
		form.setUsername(this.textUsername.getText());
		form.setName(this.textName.getText());
		form.setRole_id(this.comboboxRole.getSelectItemValue());
		form.setIsLock(this.comboboxIsLock.getSelectItemValue());
		return form;
	}

	/**
	 * 重置表单
	 */
	private void reset() {
		textUsername.setText("");
		textName.setText("");
		comboboxRole.setSelectedIndex(0);
		comboboxIsLock.setSelectedIndex(0);
	}

	/**
	 * 新增操作
	 */
	private void add() {
		addDialog.start();
		this.queryGridData();
	}

	/**
	 * 修改操作
	 */
	private void edit() {
		int rowIndex = this.table.getSelectedRow();
		if (rowIndex == -1) {
			JOptionPane.showMessageDialog(this.mainFrame,
					Constant.MESSAGE.ERROR_SELECT,
					Constant.MESSAGE.TITLE_ERROR, JOptionPane.DEFAULT_OPTION,
					Constant.iconError);
		} else {
			String id = this.table.getValueAt(rowIndex, 0).toString();
			editDialog.start(id);
			this.queryGridData();
		}
	}

	/**
	 * 删除操作
	 */
	private void delete() {
		int[] rowIndexs = this.table.getSelectedRows();
		if (rowIndexs != null && rowIndexs.length > 0) {
			int confirm = JOptionPane.showConfirmDialog(this.mainFrame,
					Constant.MESSAGE.DELETE_CONFIRM,
					Constant.MESSAGE.TITLE_DELETE, JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, Constant.iconError);
			switch (confirm) {
			case Constant.CONFIRM.YSE:
				for (int rowIndex : rowIndexs) {
					String id = this.table.getValueAt(rowIndex, 0).toString();
					UserVo vo = new UserVo();
					vo.setId(id);
					this.mainService.deleteUser(vo);
				}
				break;
			}
		} else {
			JOptionPane.showMessageDialog(this.mainFrame,
					Constant.MESSAGE.ERROR_SELECT,
					Constant.MESSAGE.TITLE_ERROR, JOptionPane.DEFAULT_OPTION,
					Constant.iconError);
		}
		this.queryGridData();
	}
}
