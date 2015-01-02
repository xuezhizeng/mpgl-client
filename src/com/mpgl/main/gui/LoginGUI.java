package com.mpgl.main.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mpgl.main.service.MainService;
import com.mpgl.session.Session;
import com.mpgl.util.CommonUtil;
import com.mpgl.util.ConfigProperty;
import com.mpgl.util.Constant;
import com.mpgl.vo.Form;
import com.mpgl.vo.MenuVo;
import com.mpgl.vo.RoleVo;
import com.mpgl.vo.UserVo;

/**
 * 登录界面
 * 
 * @author 廖陈特
 * 
 */
public class LoginGUI extends JFrame {

	private static final long serialVersionUID = -4989500718584984048L;

	/**
	 * Session对象
	 */
	public Session session = Session.newInstance();

	/**
	 * 表单
	 */
	private Form form;

	/**
	 * 用户对象
	 */
	private UserVo user;

	/**
	 * 数据库Service
	 */
	private MainService mainService;

	/**
	 * 主界面对象
	 */
	private JFrame mainFrame;

	/**
	 * 背景标签
	 */
	private JLabel label_bg;

	/**
	 * 用户名
	 */
	private JLabel labelUsername;

	/**
	 * 字段-用户名
	 */
	private JTextField textUsername;

	/**
	 * 密码
	 */
	private JLabel labelPassword;

	/**
	 * 字段-密码
	 */
	private JPasswordField textPassword;

	/**
	 * 登录按钮
	 */
	private JButton buttonLogin;

	/**
	 * 关闭按钮
	 */
	private JButton buttonClose;

	/**
	 * 构造函数
	 * 
	 * @throws Exception
	 */
	public LoginGUI() throws Exception {
		this.mainFrame = this;
		initUIStyle();
	}

	/**
	 * 启动
	 */
	@SuppressWarnings("static-access")
	public void launch() {
		mainFrame.setLayout(null);
		mainFrame.setUndecorated(true);
		this.setIconImage(Constant.imageMain);
		this.setTitle(ConfigProperty.newInstance().getProvalue("COMMON_TITLE"));
		launchBackground();
		launchComponent();
		mainFrame.setSize(Constant.iconLoginBackground.getIconWidth(),
				Constant.iconLoginBackground.getIconHeight());
		this.mainFrame.setLocation(CommonUtil.getLocation(this.mainFrame
				.getSize()));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	/**
	 * 初始化UI样式
	 * 
	 * @throws Exception
	 */
	private void initUIStyle() throws Exception {
		UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		Font font = Constant.FONT.SONGTI;
		UIManager.put("ToolTip.font", font);
		UIManager.put("Table.font", font);
		UIManager.put("TableHeader.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("ComboBox.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("PasswordField.font", font);
		UIManager.put("TextArea.font", font);
		UIManager.put("TextPane.font", font);
		UIManager.put("EditorPane.font", font);
		UIManager.put("FormattedTextField.font", font);
		UIManager.put("Button.font", font);
		UIManager.put("CheckBox.font", font);
		UIManager.put("RadioButton.font", font);
		UIManager.put("ToggleButton.font", font);
		UIManager.put("ProgressBar.font", font);
		UIManager.put("DesktopIcon.font", font);
		UIManager.put("TitledBorder.font", font);
		UIManager.put("Label.font", font);
		UIManager.put("List.font", font);
		UIManager.put("TabbedPane.font", font);
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		UIManager.put("PopupMenu.font", font);
		UIManager.put("CheckBoxMenuItem.font", font);
		UIManager.put("RadioButtonMenuItem.font", font);
		UIManager.put("Spinner.font", font);
		UIManager.put("Tree.font", font);
		UIManager.put("ToolBar.font", font);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);

	}

	/**
	 * 初始化背景
	 */
	private void launchBackground() {
		label_bg = new JLabel(Constant.iconLoginBackground);
		label_bg.setBounds(0, 0, Constant.iconLoginBackground.getIconWidth(),
				Constant.iconLoginBackground.getIconHeight());
		mainFrame.getLayeredPane()
				.add(label_bg, new Integer(Integer.MIN_VALUE));
		((JPanel) mainFrame.getContentPane()).setOpaque(false);
	}

	/**
	 * 初始化组件
	 */
	private void launchComponent() {
		Dimension panelDimension = new Dimension(250, 30);
		int x = 320;
		int y = 160;
		int z = 40;
		JPanel panelUsername = new JPanel();
		panelUsername.setLayout(new GridLayout(1, 2));
		panelUsername.setOpaque(false);
		panelUsername.setSize(panelDimension);
		panelUsername.setLocation(x, y);
		this.mainFrame.add(panelUsername);
		labelUsername = new JLabel("用户名:");
		labelUsername.setHorizontalAlignment(JLabel.RIGHT);
		textUsername = new JTextField("admin");
		panelUsername.add(labelUsername);
		panelUsername.add(textUsername);

		JPanel panelPassword = new JPanel();
		panelPassword.setLayout(new GridLayout(1, 2));
		panelPassword.setOpaque(false);
		panelPassword.setSize(panelDimension);
		panelPassword.setLocation(x, y + z);
		this.mainFrame.add(panelPassword);
		labelPassword = new JLabel("密码:");
		labelPassword.setHorizontalAlignment(JLabel.RIGHT);
		textPassword = new JPasswordField("admin123");
		panelPassword.add(labelPassword);
		panelPassword.add(textPassword);

		JPanel panelToolbar = new JPanel();
		panelToolbar.setLayout(new GridLayout(1, 2));
		panelToolbar.setOpaque(false);
		panelToolbar.setSize(200, 35);
		panelToolbar.setLocation(x + 65, y + z + z);
		this.mainFrame.add(panelToolbar);
		buttonLogin = new JButton(Constant.BUTTON.LOGIN, Constant.iconStart);
		buttonClose = new JButton(Constant.BUTTON.EXIT, Constant.iconExit);
		panelToolbar.add(buttonLogin);
		panelToolbar.add(buttonClose);

		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginGUI.this.login();
			}
		});

		buttonClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginGUI.this.dispose();
			}
		});
	}

	/**
	 * 登录
	 */
	@SuppressWarnings("deprecation")
	private void login() {
		String username = textUsername.getText();
		String password = textPassword.getText();
		if (CommonUtil.isNotNull(username) && CommonUtil.isNotNull(password)) {
			LoginGUI.this.form = new Form();
			LoginGUI.this.form.setUsername(username);
			LoginGUI.this.form.setPassword(password);
			LoginGUI.this.user = LoginGUI.this.mainService
					.login(LoginGUI.this.form);
			if (LoginGUI.this.user != null) {
				try {
					RoleVo role = mainService.getRoleByUser(LoginGUI.this.user);
					List<MenuVo> menus = mainService.getMenuByRole(role);
					role.setMenuList(menus);
					LoginGUI.this.user.setRoleVo(role);
					LoginGUI.this.session
							.put(Constant.USER, LoginGUI.this.user);
					MainGUI mainGUI = (MainGUI) ((ClassPathXmlApplicationContext) session
							.get(Constant.SPRING_CONTEXT)).getBean("MainGUI");
					mainGUI.launch();
					LoginGUI.this.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(LoginGUI.this.mainFrame,
						Constant.MESSAGE.USER_ERROR,
						Constant.MESSAGE.TITLE_ERROR,
						JOptionPane.ERROR_MESSAGE, Constant.iconError);
			}
		} else {
			JOptionPane.showMessageDialog(LoginGUI.this.mainFrame,
					Constant.MESSAGE.USER_EMPTY, Constant.MESSAGE.TITLE_ERROR,
					JOptionPane.ERROR_MESSAGE, Constant.iconError);
		}
	}

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml",
						"config/spring/main.xml" }, true);
		LoginGUI login = (LoginGUI) app.getBean("LoginGUI");
		login.session.put(Constant.SPRING_CONTEXT, app);
		login.launch();
	}

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

}
