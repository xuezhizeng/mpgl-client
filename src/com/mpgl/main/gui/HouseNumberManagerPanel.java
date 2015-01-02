package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
import com.mpgl.main.component.BasePanel;
import com.mpgl.main.component.PagePanel;
import com.mpgl.main.component.SIZE;
import com.mpgl.main.component.TableModel;
import com.mpgl.pdf.PDFUtil;
import com.mpgl.poi.ExcelUtil;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.ConfigProperty;
import com.mpgl.util.Constant;
import com.mpgl.vo.Form;
import com.mpgl.vo.HouseVo;
import com.mpgl.vo.PageVo;

/**
 * 门牌管理面板
 * 
 * @author 廖陈特
 * 
 */
public class HouseNumberManagerPanel extends BasePanel {

	private static final long serialVersionUID = 8650217406571436229L;

	/**
	 * 日志
	 */
	private static Logger log = Logger.getLogger(HouseNumberManagerPanel.class);

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
	 * 导出按钮
	 */
	private JButton buttonExprot;

	/**
	 * 打印按钮
	 */
	private JButton buttonPrint;

	/**
	 * 文件选择框
	 */
	private JFileChooser chooser;

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
	 * 道路名称
	 */
	private JLabel labelRoadName;

	/**
	 * 查询字段-道路名称
	 */
	private JTextField textRoadName;

	/**
	 * 产权主姓名
	 */
	private JLabel labelPropertyName;

	/**
	 * 查询字段-产权主姓名
	 */
	private JTextField textPropertyName;

	/**
	 * 现用户姓名
	 */
	private JLabel labelNowUserName;

	/**
	 * 查询字段-现用户姓名
	 */
	private JTextField textNowUserName;

	/**
	 * 门牌号
	 */
	private JLabel labelNowHouseNum;

	/**
	 * 查询字段-门牌号
	 */
	private JTextField textNowHouseNum;

	/**
	 * 门牌方位
	 */
	private JLabel labelHouseNumPosition;

	/**
	 * 查询字段-门牌方位
	 */
	private JTextField textHouseNumPosition;

	/**
	 * 所属市县区及乡、镇、街道、村、居委会名称
	 */
	private JLabel labelCity;

	/**
	 * 查询字段-所属市县区及乡、镇、街道、村、居委会名称
	 */
	private JTextField textCity;

	/**
	 * 用户建筑物名称及性质
	 */
	private JLabel labelNature;

	/**
	 * 查询字段-用户建筑物名称及性质
	 */
	private JTextField textNature;

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
	 * 输入流
	 */
	private InputStream ins = null;

	/**
	 * 输出流
	 */
	private OutputStream out = null;

	/**
	 * 缓冲区
	 */
	private byte[] buffers = new byte[2048];

	/**
	 * 构造函数
	 */
	public HouseNumberManagerPanel() {
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
				HouseNumberManagerPanel.this.add();
			}
		});
		buttonEdit = new JButton(Constant.BUTTON.EDIT, Constant.iconEdit);
		buttonEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.edit();
			}
		});
		buttonDel = new JButton(Constant.BUTTON.DEL, Constant.iconCancel);
		buttonDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.delete();
			}
		});
		buttonExprot = new JButton(Constant.BUTTON.EXPORT, Constant.iconExport);
		buttonExprot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.export();
			}
		});
		buttonPrint = new JButton(Constant.BUTTON.PRINT, Constant.iconPrint);
		buttonPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.print();
			}
		});
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(buttonAdd);
		menuBar.add(buttonEdit);
		menuBar.add(buttonDel);
		menuBar.add(buttonExprot);
		menuBar.add(buttonPrint);

		searchBar = new JPanel();
		searchBar.setLayout(new GridLayout(2, 1));
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelRoadName = new JLabel("道路名称:");
		textRoadName = new JTextField(SIZE.TEXTFIELD.SPAN10);
		panel1.add(labelRoadName);
		panel1.add(textRoadName);

		labelPropertyName = new JLabel("产权主姓名:");
		textPropertyName = new JTextField(SIZE.TEXTFIELD.SPAN10);
		panel1.add(labelPropertyName);
		panel1.add(textPropertyName);

		labelNowUserName = new JLabel("现用户姓名:");
		textNowUserName = new JTextField(SIZE.TEXTFIELD.SPAN10);
		panel1.add(labelNowUserName);
		panel1.add(textNowUserName);

		labelNowHouseNum = new JLabel("现门牌号:");
		textNowHouseNum = new JTextField(SIZE.TEXTFIELD.SPAN10);
		panel1.add(labelNowHouseNum);
		panel1.add(textNowHouseNum);

		labelHouseNumPosition = new JLabel("门牌方位:");
		textHouseNumPosition = new JTextField(SIZE.TEXTFIELD.SPAN10);
		panel1.add(labelHouseNumPosition);
		panel1.add(textHouseNumPosition);

		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelCity = new JLabel("所属市县区及乡、镇、街道、村、居委会名称:");
		textCity = new JTextField(SIZE.TEXTFIELD.SPAN15);
		panel2.add(labelCity);
		panel2.add(textCity);

		labelNature = new JLabel("用户建筑物名称及性质:");
		textNature = new JTextField(SIZE.TEXTFIELD.SPAN15);
		panel2.add(labelNature);
		panel2.add(textNature);

		buttonQuery = new JButton(Constant.BUTTON.QUERY, Constant.iconQuery);
		buttonQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.loadData();
			}
		});
		buttonReset = new JButton(Constant.BUTTON.RESET, Constant.iconReset);
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HouseNumberManagerPanel.this.reset();
			}
		});
		panel2.add(buttonQuery);
		panel2.add(buttonReset);

		searchBar.add(panel1);
		searchBar.add(panel2);

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
	 * 重置表单
	 */
	private void reset() {
		textRoadName.setText("");
		textPropertyName.setText("");
		textNowUserName.setText("");
		textNowHouseNum.setText("");
		textHouseNumPosition.setText("");
		textCity.setText("");
		textNature.setText("");
	}

	/**
	 * 初始化Table的列宽
	 */
	private void initTableColumnWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		for (int i = 2; i < Constant.TABLE.HOUSE_COLUMNS.length; i++) {
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

	/**
	 * 获取表单参数
	 */
	public Form getForm() {
		if (this.form.getPage() == null) {
			this.form.setPage(new PageVo());
		}
		form.setRoad_name(textRoadName.getText());
		form.setProperty_name(textPropertyName.getText());
		form.setNow_user_name(textNowUserName.getText());
		form.setNow_house_num(textNowHouseNum.getText());
		form.setHouse_num_position(textHouseNumPosition.getText());
		form.setCity(textCity.getText());
		form.setNature(textNature.getText());
		return form;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void queryGridData() {
		Map<String, Object> map = mainService.queryHouseNumberDataGrid(this
				.getForm());
		List<Map<String, Object>> list = (List<Map<String, Object>>) map
				.get(Constant.ROW_KEY);
		TableModel model = new TableModel(Constant.TABLE.HOUSE_COLUMNS,
				Constant.TABLE.HOUSE_KEYS, list);
		table.setModel(model);
		initTableColumnWidth();
		int count = Integer.parseInt(map.get(Constant.ROW_TOTAL).toString());
		PageVo page = this.getForm().getPage();
		page.setCountData(count);
		pagePanel.loadData();
	}

	@Override
	public void loadData() {
		PageVo pageVo = new PageVo();
		pageVo.setPageIndex(0);
		this.form.setPage(pageVo);
		queryGridData();
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
					HouseVo vo = new HouseVo();
					vo.setId(id);
					this.mainService.deleteHouseNumber(vo);
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

	/**
	 * 导出
	 */
	private void export() {
		chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int code = chooser.showOpenDialog(HouseNumberManagerPanel.this);
		if (code == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			if (CommonUtil.isNotNull(path)) {
				try {
					ExcelUtil excelUtil = new ExcelUtil();
					List<Map<String, Object>> list = mainService
							.queryHouseNumberList(HouseNumberManagerPanel.this
									.getForm());
					ins = excelUtil.exportStream(
							Constant.EXPORT_CLOUMN.HOUSE_COLUMNS,
							Constant.EXPORT_CLOUMN.HOUSE_KEYS, list);

					out = new FileOutputStream(new File(path
							+ "\\"
							+ ConfigProperty.newInstance().getProvalue(
									"export.filename1")));
					while ((ins.read(buffers) != -1)) {
						out.write(buffers);
						out.flush();
					}
					JOptionPane.showMessageDialog(this.mainFrame,
							Constant.MESSAGE.INFO_EXPORT + path,
							Constant.MESSAGE.TITLE_INFO,
							JOptionPane.DEFAULT_OPTION, Constant.iconInfo);
				} catch (Exception e) {
					log.error(Constant.LOG.ERROR, e);
				} finally {
					if (ins != null) {
						try {
							ins.close();
						} catch (IOException e) {
							log.error(Constant.LOG.ERROR, e);
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							log.error(Constant.LOG.ERROR, e);
						}
					}
				}
			}
		}

	}

	/**
	 * 打印
	 */
	private void print() {
		chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int code = chooser.showOpenDialog(HouseNumberManagerPanel.this);
		if (code == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			if (CommonUtil.isNotNull(path)) {
				try {
					PDFUtil pdfUtil = new PDFUtil();
					List<Map<String, Object>> list = mainService
							.queryHouseNumberList(HouseNumberManagerPanel.this
									.getForm());
					ins = pdfUtil.exportStream(
							Constant.EXPORT_CLOUMN.HOUSE_COLUMNS,
							Constant.EXPORT_CLOUMN.HOUSE_KEYS,
							Constant.EXPORT_CLOUMN.HOUSE_WIDTHS, list);

					out = new FileOutputStream(new File(path
							+ "\\"
							+ ConfigProperty.newInstance().getProvalue(
									"print.filename1")));
					while ((ins.read(buffers) != -1)) {
						out.write(buffers);
						out.flush();
					}
					JOptionPane.showMessageDialog(this.mainFrame,
							Constant.MESSAGE.INFO_EXPORT + path,
							Constant.MESSAGE.TITLE_INFO,
							JOptionPane.DEFAULT_OPTION, Constant.iconInfo);
				} catch (Exception e) {
					log.error(Constant.LOG.ERROR, e);
				} finally {
					if (ins != null) {
						try {
							ins.close();
						} catch (IOException e) {
							log.error(Constant.LOG.ERROR, e);
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							log.error(Constant.LOG.ERROR, e);
						}
					}
				}
			}
		}
	}
}
