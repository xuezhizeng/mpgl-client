package com.mpgl.main.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.mpgl.main.component.BaseDialog;
import com.mpgl.main.component.SIZE;
import com.mpgl.util.Constant;

/**
 * 新增门牌窗口
 * 
 * @author 廖陈特
 * 
 */
public class AddHouseDialog extends BaseDialog {

	private static final long serialVersionUID = -8453968271176226030L;

	@SuppressWarnings("unused")
	private JFrame frame;

	/**
	 * 中部面板
	 */
	private JTaskPane taskPane = new JTaskPane();

	/**
	 * 旧门牌号
	 */
	private JLabel labelOldHouseNum = new JLabel("旧门牌号:");

	/**
	 * 字段-旧门牌号
	 */
	private JTextField textOldHouseNum = new JTextField(SIZE.TEXTFIELD.SPAN15);
	/**
	 * 道路名称
	 */
	private JLabel labelRoadName = new JLabel("道路名称:");

	/**
	 * 字段-道路名称
	 */
	private JTextField textRoadName = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 产权主姓名
	 */
	private JLabel labelPropertyName = new JLabel("产权人姓名:");

	/**
	 * 字段-产权主姓名
	 */
	private JTextField textPropertyName = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 现用户姓名
	 */
	private JLabel labelNowUserName = new JLabel("现用户姓名:");

	/**
	 * 字段-现用户姓名
	 */
	private JTextField textNowUserName = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 门牌号
	 */
	private JLabel labelNowHouseNum = new JLabel("现门牌号:");

	/**
	 * 字段-门牌号
	 */
	private JTextField textNowHouseNum = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 门牌方位
	 */
	private JLabel labelHouseNumPosition = new JLabel("门牌方位:");

	/**
	 * 字段-门牌方位
	 */
	private JTextField textHouseNumPosition = new JTextField(
			SIZE.TEXTFIELD.SPAN15);

	/**
	 * 所属市县区及乡、镇、街道、村、居委会名称
	 */
	private JLabel labelCity = new JLabel("所属市县区及乡、镇、街道、村、居委会名称:");

	/**
	 * 字段-所属市县区及乡、镇、街道、村、居委会名称
	 */
	private JTextField textCity = new JTextField(SIZE.TEXTFIELD.SPAN30);

	/**
	 * 用户建筑物名称及性质
	 */
	private JLabel labelNature = new JLabel("用户建筑物名称及性质:");

	/**
	 * 字段-用户建筑物名称及性质
	 */
	private JTextField textNature = new JTextField(SIZE.TEXTFIELD.SPAN20);

	/**
	 * 道路级别
	 */
	private JLabel labelRoadLevel = new JLabel("道路级别:");

	/**
	 * 字段-道路级别
	 */
	private JTextField textRoadLevel = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 道路走向
	 */
	private JLabel labelRoadDirection = new JLabel("道路走向:");

	/**
	 * 字段-道路走向
	 */
	private JTextField textRoadDirection = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 道路起止
	 */
	private JLabel labelRoadStartEnd = new JLabel("道路起止点:");

	/**
	 * 字段-道路起止
	 */
	private JTextField textRoadStartEnd = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 门牌坐标
	 */
	private JLabel labelHouseNumPoint = new JLabel("门牌坐标:");

	/**
	 * 字段-门牌坐标
	 */
	private JTextField textHouseNumPoint = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 产权人电话
	 */
	private JLabel labelPropertyPhone = new JLabel("产权人电话:");

	/**
	 * 字段-
	 */
	private JTextField textPropertyPhone = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 现用户电话
	 */
	private JLabel labelNowUserPhone = new JLabel("现用户电话:");

	/**
	 * 字段-现用户电话
	 */
	private JTextField textNowUserPhone = new JTextField(SIZE.TEXTFIELD.SPAN15);

	/**
	 * 标志建筑
	 */
	private JLabel labelMark = new JLabel("相邻地名标志物名称:");

	/**
	 * 字段-标志建筑
	 */
	private JTextField textMark = new JTextField(SIZE.TEXTFIELD.SPAN20);

	/**
	 * 描述
	 */
	private JLabel labelDescription = new JLabel("描述:");

	/**
	 * 字段-描述
	 */
	private JTextArea textDescription = new JTextArea(5, 40);

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
	public AddHouseDialog() {
		super();
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param frame
	 *            主窗口
	 */
	public AddHouseDialog(JFrame frame) {
		super(frame);
		this.frame = frame;
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		this.setTitle(Constant.DIALOG.ADD);
		this.setSize(Constant.HOUSEDIALOGDIMEN);
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
				AddHouseDialog.this.save();
			}
		});
		panelMenuBar.add(buttonCancel);
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddHouseDialog.this.close();
			}
		});
		this.add(panelMenuBar, BorderLayout.SOUTH);
	}

	/**
	 * 初始化主内容面板
	 */
	private void initContentPanel() {

		JTaskPaneGroup roadGroup = new JTaskPaneGroup();
		roadGroup.setTitle("道路信息");
		JPanel roadPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel roadPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel roadPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		roadPanel1.add(this.labelCity);
		roadPanel1.add(this.textCity);
		roadPanel2.add(this.labelRoadName);
		roadPanel2.add(this.textRoadName);
		roadPanel2.add(this.labelRoadDirection);
		roadPanel2.add(this.textRoadDirection);
		roadPanel3.add(this.labelRoadLevel);
		roadPanel3.add(this.textRoadLevel);
		roadPanel3.add(this.labelRoadStartEnd);
		roadPanel3.add(this.textRoadStartEnd);
		roadGroup.add(roadPanel1);
		roadGroup.add(roadPanel2);
		roadGroup.add(roadPanel3);

		JTaskPaneGroup houseGroup = new JTaskPaneGroup();
		houseGroup.setTitle("门牌信息");
		JPanel housePanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		housePanel1.add(this.labelNowHouseNum);
		housePanel1.add(this.textNowHouseNum);
		housePanel1.add(this.labelOldHouseNum);
		housePanel1.add(this.textOldHouseNum);

		JPanel housePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		housePanel2.add(this.labelHouseNumPosition);
		housePanel2.add(this.textHouseNumPosition);
		housePanel2.add(this.labelHouseNumPoint);
		housePanel2.add(this.textHouseNumPoint);
		houseGroup.add(housePanel1);
		houseGroup.add(housePanel2);

		JTaskPaneGroup propertyGroup = new JTaskPaneGroup();
		propertyGroup.setTitle("户主信息");
		JPanel propertyPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		propertyPanel1.add(this.labelPropertyName);
		propertyPanel1.add(this.textPropertyName);
		propertyPanel1.add(this.labelPropertyPhone);
		propertyPanel1.add(this.textPropertyPhone);

		JPanel propertyPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		propertyPanel2.add(this.labelNowUserName);
		propertyPanel2.add(this.textNowUserName);
		propertyPanel2.add(this.labelNowUserPhone);
		propertyPanel2.add(this.textNowUserPhone);
		propertyGroup.add(propertyPanel1);
		propertyGroup.add(propertyPanel2);

		JTaskPaneGroup otherGroup = new JTaskPaneGroup();
		otherGroup.setTitle("其他");
		JPanel otherPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		otherPanel1.add(this.labelNature);
		otherPanel1.add(this.textNature);
		JPanel otherPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		otherPanel2.add(this.labelMark);
		otherPanel2.add(this.textMark);
		JPanel otherPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		otherPanel3.add(this.labelDescription);
		otherPanel3.add(this.textDescription);

		otherGroup.add(otherPanel1);
		otherGroup.add(otherPanel2);
		otherGroup.add(otherPanel3);

		taskPane.add(roadGroup);
		taskPane.add(houseGroup);
		taskPane.add(propertyGroup);
		taskPane.add(otherGroup);
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
		houseVo.setCity(this.textCity.getText());
		houseVo.setDescription(this.textDescription.getText());
		houseVo.setHouse_num_point(this.textHouseNumPoint.getText());
		houseVo.setHouse_num_position(this.textHouseNumPosition.getText());
		houseVo.setMark(this.textMark.getText());
		houseVo.setNature(this.textNature.getText());
		houseVo.setNow_house_num(this.textNowHouseNum.getText());
		houseVo.setNow_user_name(this.textNowUserName.getText());
		houseVo.setNow_user_phone(this.textNowUserPhone.getText());
		houseVo.setOld_house_num(this.textOldHouseNum.getText());
		houseVo.setProperty_name(this.textPropertyName.getText());
		houseVo.setProperty_phone(this.textPropertyPhone.getText());
		houseVo.setRoad_direction(this.textRoadDirection.getText());
		houseVo.setRoad_level(this.textRoadLevel.getText());
		houseVo.setRoad_name(this.textRoadName.getText());
		houseVo.setRoad_start_end(this.textRoadStartEnd.getText());
		mainService.addHouseNumber(houseVo);
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
		textCity.setText("");
		textDescription.setText("");
		textHouseNumPoint.setText("");
		textHouseNumPosition.setText("");
		textNature.setText("");
		textMark.setText("");
		textNowHouseNum.setText("");
		textNowUserName.setText("");
		textNowUserPhone.setText("");
		textOldHouseNum.setText("");
		textPropertyName.setText("");
		textPropertyPhone.setText("");
		textRoadDirection.setText("");
		textRoadLevel.setText("");
		textRoadName.setText("");
		textRoadStartEnd.setText("");
	}

	@Override
	public void start() {
		initForm();
		this.setVisible(true);
	}

}
