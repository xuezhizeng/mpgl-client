package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import com.mpgl.main.component.BasePanel;
import com.mpgl.main.component.SIZE;
import com.mpgl.poi.ExcelUtil;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.ConfigProperty;
import com.mpgl.util.Constant;

/**
 * 导入数据面板
 * 
 * @author 廖陈特
 * 
 */
public class ImportHouseNumberPanel extends BasePanel {

	private static final long serialVersionUID = 7689758779234587935L;

	/**
	 * 日志
	 */
	private static Logger log = Logger.getLogger(ImportHouseNumberPanel.class);

	/**
	 * 中部面板
	 */
	private JPanel panelCenter = new JPanel();

	/**
	 * 文件路径
	 */
	private JLabel labelFile = new JLabel("上传文件路径:");

	/**
	 * 字段-文件路径
	 */
	private JTextField textFilePath = new JTextField(SIZE.TEXTFIELD.SPAN40);

	/**
	 * 选择文件按钮
	 */
	private JButton buttonFile = new JButton(Constant.BUTTON.SELECT_FILE);

	/**
	 * 文件上传按钮
	 */
	private JButton buttonUpload = new JButton(Constant.BUTTON.UPLOAD,
			Constant.iconUpload);

	/**
	 * 重置选择按钮
	 */
	private JButton buttonReset = new JButton(Constant.BUTTON.RESET,
			Constant.iconReset);

	/**
	 * 下载模板按钮
	 */
	private JButton buttonTemplate = new JButton(Constant.BUTTON.TEMPLATE,
			Constant.iconTemplate);

	/**
	 * 文件选择框
	 */
	private JFileChooser chooser;

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
	public ImportHouseNumberPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		initCenterPane();
	}

	/**
	 * 初始化中部面板
	 */
	private void initCenterPane() {
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportHouseNumberPanel.this.selectFile();
			}
		});
		buttonUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportHouseNumberPanel.this.upload();
			}
		});
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportHouseNumberPanel.this.reset();
			}
		});

		buttonTemplate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportHouseNumberPanel.this.download();
			}
		});

		panelCenter.add(labelFile);
		panelCenter.add(textFilePath);
		panelCenter.add(buttonFile);
		panelCenter.add(buttonUpload);
		panelCenter.add(buttonReset);
		panelCenter.add(buttonTemplate);

		this.add(panelCenter, BorderLayout.CENTER);
	}

	/**
	 * 重置
	 */
	private void reset() {
		textFilePath.setText("");
	}

	/**
	 * 选择上传文件
	 */
	private void selectFile() {
		chooser = new JFileChooser();
		int code = chooser.showOpenDialog(this);
		if (code == JFileChooser.APPROVE_OPTION) {
			textFilePath.setText(chooser.getSelectedFile().getPath());
		}
	}

	/**
	 * 上传操作
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	private void upload() {
		try {
			String path = textFilePath.getText();
			if (CommonUtil.isNotNull(path)) {
				File file = new File(path);
				if (file.exists()) {
					ExcelUtil excelUtil = new ExcelUtil(ConfigProperty
							.newInstance().getProvalue("export.filename1"),
							file);
					List<Map<String, Object>> list = excelUtil.getData(
							Constant.IMPORT_CLOUMN.HOUSE_COLUMNS, 0);
					mainService.insertHouseNumberByList(list);
					JOptionPane.showMessageDialog(this.mainFrame,
							Constant.MESSAGE.INFO_IMPORT,
							Constant.MESSAGE.TITLE_INFO,
							JOptionPane.DEFAULT_OPTION, Constant.iconInfo);
				} else {
					JOptionPane.showMessageDialog(this.mainFrame,
							Constant.MESSAGE.ERROR_PATH,
							Constant.MESSAGE.TITLE_ERROR,
							JOptionPane.DEFAULT_OPTION, Constant.iconError);
				}
			} else {
				JOptionPane.showMessageDialog(this.mainFrame,
						Constant.MESSAGE.ERROR_FILE,
						Constant.MESSAGE.TITLE_ERROR,
						JOptionPane.DEFAULT_OPTION, Constant.iconError);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.mainFrame,
					Constant.MESSAGE.ERROR_IMPORT,
					Constant.MESSAGE.TITLE_ERROR, JOptionPane.DEFAULT_OPTION,
					Constant.iconError);
			log.error(Constant.LOG.ERROR, e);
		}
	}

	/**
	 * 下载操作
	 */
	@SuppressWarnings("static-access")
	private void download() {
		chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int code = chooser.showSaveDialog(this);
		if (code == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			if (CommonUtil.isNotNull(path)) {
				try {
					// 读取路径
					String insPath = Constant.TEMPLATE_PATH
							+ ConfigProperty.newInstance().getProvalue(
									"template.importfile");
					ins = new FileInputStream(new File(insPath));
					// 输出路径
					String outPath = path
							+ "/"
							+ ConfigProperty.newInstance().getProvalue(
									"template.importfile");
					out = new FileOutputStream(new File(outPath));
					while (ins.read(buffers) != -1) {
						out.write(buffers);
						out.flush();
					}
					JOptionPane.showMessageDialog(this.mainFrame,
							Constant.MESSAGE.INFO_DOWNLOAD + outPath,
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

	@Override
	public void loadData() {
	}

	@Override
	public void queryGridData() {
	}
}
