package com.mpgl.main.component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mpgl.vo.Form;

/**
 * 分页面板
 * 
 * @author 廖陈特
 * 
 */
public class PagePanel extends BasePanel {

	private static final long serialVersionUID = -3683876980692247626L;

	/**
	 * 父面板
	 */
	private BasePanel fatherPanel;

	/**
	 * 左侧面板
	 */
	private JPanel panelLeft = new JPanel();

	/**
	 * 右侧面板
	 */
	private JPanel panelRight = new JPanel();

	/**
	 * 上一页按钮
	 */
	private JButton buttonLeft = new JButton(new ImageIcon(
			"images/icon/left.png"));

	/**
	 * 下一页按钮
	 */
	private JButton buttonRight = new JButton(new ImageIcon(
			"images/icon/right.png"));

	/**
	 * 每页记录数标签
	 */
	private JLabel labelPageSize = new JLabel("每页显示记录数:50");

	/**
	 * 当前页显示标签
	 */
	private JLabel labelNowPage = null;

	/**
	 * 总页数显示标签
	 */
	private JLabel labelTotlePage = null;

	/**
	 * 总记录数标题标签
	 */
	private JLabel labelCountTitle = new JLabel("总记录数:");

	/**
	 * 总记录数显示标签
	 */
	private JLabel labetCount = null;

	/**
	 * 分隔符标签
	 */
	private JLabel labelSplit = new JLabel("/");

	/**
	 * 构造函数
	 * 
	 * @param fatherPanel
	 *            父面板
	 * @param form
	 *            表单对象
	 */
	public PagePanel(BasePanel fatherPanel, Form form) {
		this.setForm(form);
		this.fatherPanel = fatherPanel;
		this.setLayout(new FlowLayout());
		this.add(panelLeft);
		this.add(panelRight);
		initLeftPanel();
		initRightPanel();
	}

	/**
	 * 初始化左侧面板
	 */
	private void initLeftPanel() {
		panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLeft.add(labelPageSize);
	}

	/**
	 * 初始化右侧面板
	 */
	private void initRightPanel() {
		panelRight.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelRight.add(buttonLeft);
		buttonLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PagePanel.this.backPage();
			}
		});
		labelNowPage = new JLabel(this.getForm().getPage().getNowPage() + "");
		panelRight.add(labelNowPage);
		panelRight.add(labelSplit);
		labelTotlePage = new JLabel(this.getForm().getPage().getTotalPage()
				+ "");
		panelRight.add(labelTotlePage);
		panelRight.add(buttonRight);
		buttonRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PagePanel.this.nextPage();
			}
		});
		panelRight.add(labelCountTitle);
		labetCount = new JLabel(this.getForm().getPage().getCountData() + "");
		panelRight.add(labetCount);
	}

	/**
	 * 下一页操作
	 */
	private void nextPage() {
		this.getForm().getPage().nextPage();
		this.fatherPanel.queryGridData();
	}

	/**
	 * 上一页操作
	 */
	private void backPage() {
		this.getForm().getPage().lastPage();
		this.fatherPanel.queryGridData();
	}

	@Override
	public void loadData() {
		labelNowPage.setText(this.getForm().getPage().getNowPage() + "");
		labelTotlePage.setText(this.getForm().getPage().getTotalPage() + "");
		labetCount.setText(this.getForm().getPage().getCountData() + "");
	}

	@Override
	public void queryGridData() {
	}

}
