package com.mpgl.util;

import java.awt.Dimension;
import java.awt.Point;

/**
 * 公共方法类
 * 
 * @author 廖陈特
 * 
 */
public class CommonUtil {

	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		boolean isNotNull = false;
		if (null != str && !"".equals(str)) {
			isNotNull = true;
		}
		return isNotNull;
	}

	/**
	 * Object转String
	 * 
	 * @param object
	 * @return
	 */
	public static String getString(Object object) {
		return object == null ? "" : object.toString();
	}

	/**
	 * 获取使窗口位于屏幕中央的起始坐标
	 * 
	 * @param dimension
	 *            窗口大小
	 * @return Point 坐标对象
	 */
	public static Point getLocation(Dimension dimension) {
		Point point = new Point();
		int x = 0;
		int y = 0;
		x = (Constant.SCREENDIMEN.width - dimension.width) / 2;
		y = (Constant.SCREENDIMEN.height - dimension.height) / 2;
		point.setLocation(x, y);
		return point;
	}
}
