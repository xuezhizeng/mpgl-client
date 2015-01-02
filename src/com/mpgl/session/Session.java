package com.mpgl.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Session对象 [模拟WEB中的SESSION][单例]
 * 
 * @author 廖陈特
 * 
 */
public class Session {

	/**
	 * 会话ID
	 */
	private String SessionID;

	/**
	 * 单例
	 */
	private static Session session;

	/**
	 * 数据存放对象
	 */
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 构造函数
	 */
	private Session() {
		SessionID = UUID.randomUUID().toString();
	}

	/**
	 * 创建SESSION
	 * 
	 * @return
	 */
	public static Session newInstance() {
		if (session == null) {
			session = new Session();
		}
		return session;
	}

	/**
	 * 根据KEY获取SESSION中的值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return map.get(key);
	}

	/**
	 * 存放数据到SESSION
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		map.put(key, value);
	}
}
