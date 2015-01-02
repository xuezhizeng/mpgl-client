package com.mpgl.main.component;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import javax.swing.JDialog;
import com.mpgl.main.service.MainService;
import com.mpgl.session.Session;
import com.mpgl.util.ConfigProperty;
import com.mpgl.vo.Form;
import com.mpgl.vo.HouseVo;
import com.mpgl.vo.UserVo;

/**
 * 基本Dialog
 * 
 * @author 廖陈特
 * 
 */
public abstract class BaseDialog extends JDialog {

	private static final long serialVersionUID = 1495965655127677125L;

	protected Form form = new Form();

	protected HouseVo houseVo = new HouseVo();

	protected UserVo userVo = new UserVo();

	/**
	 * 配置文件configurtion.properties
	 */
	protected ConfigProperty config = ConfigProperty.newInstance();

	public BaseDialog() {
		super();
	}

	public BaseDialog(Dialog owner, boolean modal) {
		super(owner, modal);
	}

	public BaseDialog(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}

	public BaseDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
	}

	public BaseDialog(Dialog owner, String title) {
		super(owner, title);
	}

	public BaseDialog(Dialog owner) {
		super(owner);
	}

	public BaseDialog(Frame owner, boolean modal) {
		super(owner, modal);
	}

	public BaseDialog(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
	}

	public BaseDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
	}

	public BaseDialog(Frame owner, String title) {
		super(owner, title);
	}

	public BaseDialog(Frame owner) {
		super(owner);
	}

	public BaseDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
	}

	public BaseDialog(Window owner, String title, ModalityType modalityType,
			GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
	}

	public BaseDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
	}

	public BaseDialog(Window owner, String title) {
		super(owner, title);
	}

	public BaseDialog(Window owner) {
		super(owner);
	}

	protected Session session = Session.newInstance();

	protected MainService mainService;

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	/**
	 * 启动窗口
	 */
	public void start() {
		this.setVisible(true);
	}

	/**
	 * 启动窗口
	 * 
	 * @param id
	 *            参数
	 */
	public void start(String id) {
		start();
	}

}
