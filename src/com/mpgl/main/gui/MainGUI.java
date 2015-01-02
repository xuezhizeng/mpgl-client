package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.mpgl.main.component.BaseDialog;
import com.mpgl.main.component.BaseFrame;
import com.mpgl.main.component.BasePanel;
import com.mpgl.session.Session;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.Constant;
import com.mpgl.vo.MenuVo;
import com.mpgl.vo.SubMenuVo;
import com.mpgl.vo.UserVo;

/**
 * 主界面GUI
 * 
 * @author 廖陈特
 * 
 */
public class MainGUI extends BaseFrame {

	private static final long serialVersionUID = -1580742709387999070L;

	/**
	 * 上下文
	 */
	private ClassPathXmlApplicationContext app;

	/**
	 * SESSION
	 */
	private Session session = Session.newInstance();

	/**
	 * USER
	 */
	private UserVo user;

	/**
	 * 密码修改窗口
	 */
	private BaseDialog editPasswordDialog;

	/**
	 * 密码修改窗口
	 */
	private BaseDialog systemSettingDialog;

	/**
	 * 顶部面板
	 */
	private JPanel topPane = new JPanel();

	/**
	 * 分隔面板
	 */
	private JSplitPane splitPane = new JSplitPane();

	/**
	 * 分隔左侧面板
	 */
	private JScrollPane leftPane;

	/**
	 * 分割右侧面板
	 */
	private JPanel rigthPane;

	/**
	 * 底部面板
	 */
	private JPanel bottomPane = new JPanel();

	/**
	 * 构造函数
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public MainGUI() throws Exception {
		this.setIconImage(Constant.imageMain);
		this.setTitle(config.getProvalue("COMMON_TITLE"));
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(Constant.MAINDIMEN);
		this.setLocation(CommonUtil.getLocation(this.getSize()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}

	/**
	 * 初始化
	 */
	public void launch() {
		this.setVisible(true);
		this.initTopBar();
		this.initCenterContent();
		this.initBottomBar();
	}

	/**
	 * 初始化顶部菜单
	 */
	@SuppressWarnings("static-access")
	private void initTopBar() {
		this.topPane.setLayout(new BorderLayout());
		this.topPane.setBorder(BorderFactory.createEtchedBorder());
		this.topPane.setBackground(Color.WHITE);
		// 左侧
		JPanel panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton buttonLogo = new JButton(config.getProvalue("COMMON_TITLE"),
				Constant.iconSynchro);
		buttonLogo.setContentAreaFilled(false);
		panelLeft.add(buttonLogo);

		// 右侧
		UserVo user = (UserVo) session.get(Constant.USER);
		JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton buttonUser = new JButton(user.getName(), Constant.iconPrivacy);
		buttonUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainGUI.this,
						Constant.MESSAGE.DIDADI, Constant.MESSAGE.TITLE_INFO,
						JOptionPane.DEFAULT_OPTION, Constant.iconInfo);
			}
		});

		JButton buttonEditPassword = new JButton(Constant.BUTTON.EDITPWD,
				Constant.iconEdit);
		buttonEditPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.this.editPassword();
			}
		});

		JButton buttonDept = new JButton(Constant.BUTTON.UNIT,
				Constant.iconStar);
		buttonDept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainGUI.this,
						MainGUI.this.config.getProvalue("COMMON_DEPT"),
						Constant.MESSAGE.TITLE_UNIT,
						JOptionPane.DEFAULT_OPTION, Constant.iconInfo);
			}
		});

		JButton buttonSetting = new JButton(Constant.BUTTON.SETTING,
				Constant.iconSetting);
		buttonSetting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.this.systemSetting();
			}
		});

		JButton buttonExit = new JButton(Constant.BUTTON.EXIT,
				Constant.iconExit);
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(MainGUI.this,
						Constant.MESSAGE.INFO_EXIT,
						Constant.MESSAGE.TITLE_EXIT, JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, Constant.iconInfo);
				if (confirm == Constant.CONFIRM.YSE) {
					MainGUI.this.dispose();
				}
			}
		});

		panelRight.add(buttonUser);
		panelRight.add(buttonEditPassword);
		panelRight.add(buttonDept);
		panelRight.add(buttonSetting);
		panelRight.add(buttonExit);
		this.topPane.add(panelLeft, BorderLayout.WEST);
		this.topPane.add(panelRight, BorderLayout.CENTER);
		this.add(this.topPane, BorderLayout.NORTH);
	}

	/**
	 * 初始化中部区域
	 */
	private void initCenterContent() {
		this.initLeftPanel();
		this.initRightPanel();
		this.splitPane.setOneTouchExpandable(true);// 让分割线显示出箭头
		this.splitPane.setContinuousLayout(true);// 操作箭头，重绘图形
		this.splitPane.setDividerSize(10);
		splitPane.setMinimumSize(new Dimension(0, 0));
		this.splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);// 设置分割线方向
		this.add(splitPane, BorderLayout.CENTER);
	}

	/**
	 * 初始化左侧面板
	 */
	private void initLeftPanel() {
		this.app = (ClassPathXmlApplicationContext) session
				.get(Constant.SPRING_CONTEXT);
		this.user = (UserVo) session.get(Constant.USER);
		// 初始化菜单栏
		JTaskPane taskPane = new JTaskPane();
		JTaskPaneGroup groupHome = new JTaskPaneGroup();
		groupHome.setTitle(Constant.MESSAGE.TITLE_WELCOME);
		JButton buttonHome = new JButton(Constant.BUTTON.HOME);
		buttonHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.this.splitPane
						.setRightComponent(MainGUI.this.rigthPane);
			}
		});
		groupHome.add(buttonHome);
		taskPane.add(groupHome);

		List<MenuVo> menus = this.user.getRoleVo().getMenuList();
		for (MenuVo menu : menus) {
			JTaskPaneGroup group = new JTaskPaneGroup();
			group.setTitle(menu.getName());
			taskPane.add(group);
			List<SubMenuVo> subMenus = menu.getList();
			for (SubMenuVo subMenu : subMenus) {
				JButton button = new JButton(subMenu.getName());
				button.setActionCommand(subMenu.getCode());
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MainGUI.this.onClickMenu((BasePanel) app.getBean(e
								.getActionCommand()));
					}
				});
				group.add(button);
			}
		}
		leftPane = new JScrollPane(taskPane);
		this.splitPane.setLeftComponent(leftPane);
	}

	/**
	 * 初始化右侧面板
	 */
	private void initRightPanel() {
		rigthPane = new JPanel();
		Dimension WELCOME = new Dimension(Constant.SCREENDIMEN.width - 200, Constant.SCREENDIMEN.height - 100);
		ImageIcon image = new ImageIcon("images/Welcome.png");
		image.setImage(image.getImage().getScaledInstance(WELCOME.width, WELCOME.height, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(image);
		rigthPane.add(label);
		rigthPane.setBackground(Color.WHITE);
		this.splitPane.setRightComponent(new JScrollPane(rigthPane));
	}

	/**
	 * 初始化底部工具栏
	 */
	@SuppressWarnings("static-access")
	private void initBottomBar() {
		this.bottomPane.setBorder(BorderFactory.createEtchedBorder());
		this.bottomPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.bottomPane.setBackground(new Color(36, 168, 244));
		JLabel labelUnit = new JLabel(
				config.getProvalue("COMMON_PRODUCTION_UNIT"));
		this.bottomPane.add(labelUnit);
		this.add(this.bottomPane, BorderLayout.SOUTH);
	}

	/**
	 * 点击左侧菜单
	 */
	private void onClickMenu(BasePanel panel) {
		panel.setMainFrame(MainGUI.this);
		panel.loadData();
		MainGUI.this.splitPane.setRightComponent(panel);
	}

	/**
	 * 修改密码
	 */
	private void editPassword() {
		this.editPasswordDialog.start();
	}

	/**
	 * 系统设置
	 */
	private void systemSetting() {
		this.systemSettingDialog.start();
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public BaseDialog getEditPasswordDialog() {
		return editPasswordDialog;
	}

	public void setEditPasswordDialog(BaseDialog editPasswordDialog) {
		this.editPasswordDialog = editPasswordDialog;
	}

	public BaseDialog getSystemSettingDialog() {
		return systemSettingDialog;
	}

	public void setSystemSettingDialog(BaseDialog systemSettingDialog) {
		this.systemSettingDialog = systemSettingDialog;
	}

}
