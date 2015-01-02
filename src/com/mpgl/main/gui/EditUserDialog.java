package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
import com.mpgl.main.component.Combobox;
import com.mpgl.main.component.ComboboxModel;
import com.mpgl.main.component.SIZE;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.Constant;

/**
 * 修改用户窗口
 * 
 * @author 廖陈特
 * 
 */
public class EditUserDialog extends BaseDialog {

	private static final long serialVersionUID = 4589142524036735166L;

	@SuppressWarnings("unused")
	private JFrame frame;

	/**
	 * 中部面板
	 */
	private JTaskPane taskPane = new JTaskPane();

	/**
	 * 用户名
	 */
	private JLabel labelUsername = new JLabel("用户帐号:");

	/**
	 * 查询字段-用户名
	 */
	private JTextField textUsername = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 密码
	 */
	private JLabel labelPassword = new JLabel("用户密码:");

	/**
	 * 密码实际姓名
	 */
	private JTextField textPassword = new JTextField(SIZE.TEXTFIELD.SPAN15);
	/**
	 * 实际姓名
	 */
	private JLabel labelName = new JLabel("实际姓名:");

	/**
	 * 查询字段-实际姓名
	 */
	private JTextField textName = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 角色
	 */
	private JLabel labelRole = new JLabel("赋予角色:");

	/**
	 * 查询字段-角色
	 */
	private Combobox comboboxRole = new Combobox();

	/**
	 * 是否锁定
	 */
	private JLabel labelIsLock = new JLabel("是否锁定:");

	/**
	 * 查询字段-是否锁定
	 */
	private Combobox comboboxIsLock = new Combobox();

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
	public EditUserDialog() {
		super();
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param frame
	 *            主窗口
	 */
	public EditUserDialog(JFrame frame) {
		super(frame);
		this.frame = frame;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setTitle(Constant.DIALOG.EDIT);
		this.setSize(Constant.USERDIALOGDIMEN);
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
				EditUserDialog.this.save();
			}
		});
		panelMenuBar.add(buttonCancel);
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditUserDialog.this.close();
			}
		});
		this.add(panelMenuBar, BorderLayout.SOUTH);
	}

	/**
	 * 初始化主内容面板
	 */
	private void initContentPanel() {
		JTaskPaneGroup roadGroup = new JTaskPaneGroup();
		roadGroup.setTitle("用户信息");
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(this.labelUsername);
		this.textUsername.setEditable(false);
		panel1.add(this.textUsername);
		panel2.add(this.labelPassword);
		panel2.add(this.textPassword);
		panel3.add(this.labelName);
		panel3.add(this.textName);
		panel4.add(this.labelRole);
		panel4.add(this.comboboxRole);
		panel5.add(this.labelIsLock);
		panel5.add(this.comboboxIsLock);
		roadGroup.add(panel1);
		roadGroup.add(panel2);
		roadGroup.add(panel3);
		roadGroup.add(panel4);
		roadGroup.add(panel5);
		taskPane.add(roadGroup);
		this.add(new JScrollPane(taskPane), BorderLayout.CENTER);
	}

	/**
	 * 初始化表单组件宽度
	 */
	private void initFormCompomentWidth() {
		this.comboboxRole.setPreferredSize(SIZE.COMBOBOX.SPAN150);
		this.comboboxIsLock.setPreferredSize(SIZE.COMBOBOX.SPAN150);
	}

	/**
	 * 保存数据
	 */
	private void save() {
		if(!CommonUtil.isNotNull(this.textPassword.getText())) {
			JOptionPane.showMessageDialog(this.frame,
					Constant.MESSAGE.ERROR_NEWPASSWORD, Constant.MESSAGE.TITLE_ERROR,
					JOptionPane.ERROR_MESSAGE, Constant.iconError);
			return;
		}
		userVo.setId(form.getUser_id());
		userVo.setUsername(this.textUsername.getText());
		userVo.setPassword(this.textPassword.getText());
		userVo.setName(this.textName.getText());
		userVo.setRole_id(this.comboboxRole.getSelectItemValue());
		userVo.setIsLock(this.comboboxIsLock.getSelectItemValue());
		userVo.setUpdate_time(Constant.DEFAULT_DATE_FORMAT.format(new Date()));
		mainService.updateUser(userVo);
		this.close();
	}

	/**
	 * 关闭窗口
	 */
	private void close() {
		this.dispose();
	}

	/**
	 * 初始化下拉框的值
	 */
	private void loadComboboxData() {
		this.form.setDictionaryKey("isLock");
		ComboboxModel modelIsLock = new ComboboxModel(
				mainService.queryDictionaryByKey(form), false);
		comboboxIsLock.setModel(modelIsLock);
		ComboboxModel modelRole = new ComboboxModel(
				mainService.queryRoleList(), false);
		comboboxRole.setModel(modelRole);
	}

	/**
	 * 初始化表单
	 */
	private void initForm(String id) {
		form.setUser_id(id);
		Map<String, Object> map = mainService.queryUser(form);
		this.textName.setText(CommonUtil.getString(map.get("name")));
		this.textUsername.setText(CommonUtil.getString(map.get("username")));
		this.textPassword.setText(CommonUtil.getString(map.get("password")));
		this.comboboxIsLock.setSelectedItemByValue(CommonUtil.getString(map
				.get("isLock")));
		this.comboboxRole.setSelectedItemByValue(CommonUtil.getString(map
				.get("role_id")));
	}

	@Override
	public void start(String id) {
		loadComboboxData();
		initForm(id);
		this.setVisible(true);
	}
}
