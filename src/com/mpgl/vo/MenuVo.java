package com.mpgl.vo;

import java.util.List;

/**
 * 菜单VO
 * 
 * @author 廖陈特
 * 
 */
public class MenuVo {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 菜单名
	 */
	private String name;

	/**
	 * 子菜单数组
	 */
	private List<SubMenuVo> list;

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

	public List<SubMenuVo> getList() {
		return list;
	}

	public void setList(List<SubMenuVo> list) {
		this.list = list;
	}

}
