package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.mpgl.main.component.BaseDialog;
import com.mpgl.main.component.SIZE;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.ConfigProperty;
import com.mpgl.util.Constant;
import com.mpgl.vo.UserVo;

/**
 * 
 * @author 廖陈特
 * 
 */
public class SystemSettingDialog extends BaseDialog {

	private static final long serialVersionUID = -5162975834456045660L;

	@SuppressWarnings("unused")
	private JFrame frame;

	/**
	 * 中部面板
	 */
	private JTaskPane taskPane = new JTaskPane();

	/**
	 * 系统名称
	 */
	private JLabel labelSystemName = new JLabel("系统名称:");

	/**
	 * 字段-系统名称
	 */
	private JTextField textSystemName = new JTextField(SIZE.TEXTFIELD.SPAN30);
	/**
	 * 使用单位
	 */
	private JLabel labelDept = new JLabel("使用单位:");

	/**
	 * 字段-使用单位
	 */
	private JTextField textDept = new JTextField(SIZE.TEXTFIELD.SPAN30);

	/**
	 * 底部菜单面板
	 */
	private JPanel panelMenuBar = new JPanel();

	/**
	 * 保存按钮
	 */
	private JButton buttonSave = new JButton(Constant.BUTTON.SAVE,
			Constant.iconSave);

	/**
	 * 关闭按钮
	 */
	private JButton buttonCancel = new JButton(Constant.BUTTON.CLOSE,
			Constant.iconCancel);

	/**
	 * 构造函数
	 */
	public SystemSettingDialog() {
		super();
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param frame
	 */
	public SystemSettingDialog(JFrame frame) {
		super(frame);
		this.frame = frame;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setTitle(Constant.DIALOG.SYSTEM_SETTING);
		this.setSize(Constant.SYSTEM_SETTING);
		setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);

		initMenuBar();
		initFormCompomentWidth();
		initContentPanel();
	}

	/**
	 * 初始化菜单栏
	 */
	private void initMenuBar() {
		panelMenuBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelMenuBar.add(buttonSave);
		buttonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemSettingDialog.this.save();
			}
		});
		panelMenuBar.add(buttonCancel);
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemSettingDialog.this.close();
			}
		});
		this.add(panelMenuBar, BorderLayout.SOUTH);
	}

	/**
	 * 初始化主内容面板
	 */
	private void initContentPanel() {
		JTaskPaneGroup roadGroup = new JTaskPaneGroup();
		roadGroup.setTitle("基本信息");
		JPanel roadPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		roadPanel1.add(this.labelSystemName);
		roadPanel1.add(this.textSystemName);
		JPanel roadPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		roadPanel2.add(this.labelDept);
		roadPanel2.add(this.textDept);
		roadGroup.add(roadPanel1);
		roadGroup.add(roadPanel2);
		taskPane.add(roadGroup);
		this.add(new JScrollPane(taskPane), BorderLayout.CENTER);
	}

	/**
	 * 初始化表单组件宽度
	 */
	private void initFormCompomentWidth() {
	}

	/**
	 * 保存数据
	 */
	private void save() {
		String systemName = textSystemName.getText();
		String deptName = textDept.getText();
		this.config.setProvalue("COMMON_TITLE", systemName);
		this.config.setProvalue("COMMON_DEPT", deptName);
		this.config.updateProperty();
		JOptionPane.showMessageDialog(this, Constant.MESSAGE.INFO_SETTING,
				Constant.MESSAGE.TITLE_INFO, JOptionPane.DEFAULT_OPTION,
				Constant.iconInfo);
		this.close();
	}

	/**
	 * 关闭窗口
	 */
	private void close() {
		this.dispose();
	}

	/**
	 * 初始化表单
	 */
	private void initForm() {
		this.textSystemName.setText(this.config.getProvalue("COMMON_TITLE"));
		this.textDept.setText(this.config.getProvalue("COMMON_DEPT"));
	}

	@Override
	public void start() {
		initForm();
		this.setVisible(true);
	}
}
