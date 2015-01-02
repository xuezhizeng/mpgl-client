package com.mpgl.main.component;

import javax.swing.JFrame;

import com.mpgl.main.service.MainService;
import com.mpgl.session.Session;
import com.mpgl.util.ConfigProperty;
import com.mpgl.vo.Form;

/**
 * 基本Frame
 * 
 * @author 廖陈特
 * 
 */
public abstract class BaseFrame extends JFrame {

	private static final long serialVersionUID = 705584399300992564L;

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
	 * 表单对象
	 */
	protected Form form = new Form();

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
}
