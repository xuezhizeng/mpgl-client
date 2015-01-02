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
import com.mpgl.util.Constant;
import com.mpgl.vo.UserVo;

/**
 * 修改密码窗口
 * 
 * @author 廖陈特
 * 
 */
public class EditPasswordDialog extends BaseDialog {

	private static final long serialVersionUID = 300586431099146711L;

	@SuppressWarnings("unused")
	private JFrame frame;

	/**
	 * 中部面板
	 */
	private JTaskPane taskPane = new JTaskPane();

	/**
	 * 新密码
	 */
	private JLabel labelNewPassowrd = new JLabel("新密码:");

	/**
	 * 字段-新密码
	 */
	private JTextField textNewPassowrd = new JTextField(SIZE.TEXTFIELD.SPAN15);

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
	public EditPasswordDialog() {
		super();
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param frame
	 */
	public EditPasswordDialog(JFrame frame) {
		super(frame);
		this.frame = frame;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setTitle(Constant.DIALOG.EDIT_PASSWORD);
		this.setSize(Constant.EDITPASSWORDDIMEN);
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
				EditPasswordDialog.this.save();
			}
		});
		panelMenuBar.add(buttonCancel);
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditPasswordDialog.this.close();
			}
		});
		this.add(panelMenuBar, BorderLayout.SOUTH);
	}

	/**
	 * 初始化主内容面板
	 */
	private void initContentPanel() {
		JTaskPaneGroup roadGroup = new JTaskPaneGroup();
		roadGroup.setTitle("新密码");
		JPanel roadPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		roadPanel1.add(this.labelNewPassowrd);
		roadPanel1.add(this.textNewPassowrd);
		roadGroup.add(roadPanel1);
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
		String newPassword = textNewPassowrd.getText();
		if(CommonUtil.isNotNull(newPassword)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("password", newPassword);
			UserVo vo = (UserVo) session.get(Constant.USER);
			map.put("id", vo.getId());
			mainService.updateUserPassword(map);
			this.close();
		} else {
			JOptionPane.showMessageDialog(this.frame,
					Constant.MESSAGE.ERROR_NEWPASSWORD, Constant.MESSAGE.TITLE_ERROR,
					JOptionPane.ERROR_MESSAGE, Constant.iconError);
		}
		
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
		textNewPassowrd.setText("");
	}

	@Override
	public void start() {
		initForm();
		this.setVisible(true);
	}
}
