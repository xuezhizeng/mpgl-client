package com.mpgl.main.component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mpgl.main.service.MainService;
import com.mpgl.session.Session;
import com.mpgl.util.ConfigProperty;
import com.mpgl.vo.Form;

/**
 * 基本Panel
 * 
 * @author 廖陈特
 * 
 */
public abstract class BasePanel extends JPanel {

	private static final long serialVersionUID = -961214927825003040L;

	/**
	 * 主窗口
	 */
	protected JFrame mainFrame;

	/**
	 * 配置文件configurtion.properties
	 */
	protected ConfigProperty config = ConfigProperty.newInstance();

	/**
	 * SESSION
	 */
	protected Session session = Session.newInstance();

	/**
	 * MainService
	 */
	protected MainService mainService;

	/**
	 * 新增窗口
	 */
	protected BaseDialog addDialog;

	/**
	 * 修改窗口
	 */
	protected BaseDialog editDialog;

	/**
	 * 表单
	 */
	protected Form form = new Form();

	/**
	 * 加载初始数据
	 */
	public abstract void loadData();

	/**
	 * 查询Grid数据
	 */
	public abstract void queryGridData();

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public BaseDialog getAddDialog() {
		return addDialog;
	}

	public void setAddDialog(BaseDialog addDialog) {
		this.addDialog = addDialog;
	}

	public BaseDialog getEditDialog() {
		return editDialog;
	}

	public void setEditDialog(BaseDialog editDialog) {
		this.editDialog = editDialog;
	}

}
