package com.mpgl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 资源配置文件操作类[单例]
 * 
 * @author 廖陈特
 * 
 */
public class ConfigProperty {

	/**
	 * 日志
	 */
	private static Logger log = Logger.getLogger(ConfigProperty.class);

	/**
	 * 单例对象
	 */
	private static ConfigProperty instance;

	/**
	 * 资源对象
	 */
	private Properties properties;

	/**
	 * 文件路径
	 */
	private static final String CONFIG_FILE = "/config/base/configurtion.properties";

	/**
	 * 构造函数
	 */
	private ConfigProperty() {
		properties = new Properties();
		InputStream ins = null;
		try {
			ins = ConfigProperty.class.getResourceAsStream(CONFIG_FILE);
			properties.load(ins);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					log.error(Constant.LOG.ERROR, e);
				}
			}
		}
	}

	/**
	 * 创建实例
	 * 
	 * @return ConfigProperty
	 */
	public static ConfigProperty newInstance() {
		if (instance == null) {
			instance = new ConfigProperty();
		}
		return instance;
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * 根据键值获取值
	 * 
	 * @param Key
	 * @return
	 */
	public String getProvalue(String Key) {
		Properties props = ConfigProperty.newInstance().getProperties();
		return props.getProperty(Key);
	}

	/**
	 * 设置资源文件键值对
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void setProvalue(String key, String value) {
		Properties props = ConfigProperty.newInstance().getProperties();
		props.setProperty(key, value);
	}

	/**
	 * 更新资源文件
	 */
	public void updateProperty() {
		FileOutputStream out = null;
		try {
			Properties props = ConfigProperty.newInstance().getProperties();
			out = new FileOutputStream(new File(ConfigProperty.class
					.getResource("/").getPath() + CONFIG_FILE));
			props.store(out, "Copyright (c) Boxcode Studio");
			out.flush();
			instance = null;
			ConfigProperty.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.error(Constant.LOG.ERROR, e);
				}
			}
		}
	}
}
