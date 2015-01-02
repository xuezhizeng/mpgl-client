package com.mpgl.main.component;

import java.awt.Dimension;

/**
 * 此接口定义相关组件的一些默认大小
 * 
 * @author user
 * 
 */
public interface SIZE {

	/**
	 * JTextField组件适用大小
	 * 
	 * @author user
	 * 
	 */
	public interface TEXTFIELD {

		int SPAN10 = 10;

		int SPAN15 = 15;

		int SPAN20 = 20;

		int SPAN30 = 30;

		int SPAN40 = 40;

		int SPAN80 = 80;
	}

	/**
	 * 下拉框组件大小
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface COMBOBOX {
		Dimension SPAN80 = new Dimension(80, 30);

		Dimension SPAN150 = new Dimension(150, 30);

		Dimension SPAN100 = new Dimension(100, 30);
	}
}
