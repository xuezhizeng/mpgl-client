package com.mpgl.vo;

/**
 * 子菜单VO
 * 
 * @author 廖陈特
 * 
 */
public class SubMenuVo {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 子菜单名
	 */
	private String name;

	/**
	 * 父菜单ID
	 */
	private String menu_id;

	/**
	 * 对应页面路径
	 */
	private String path;

	/**
	 * 对应客户端CODE
	 */
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
