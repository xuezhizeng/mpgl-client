package com.mpgl.main.service;

import java.util.List;
import java.util.Map;

import com.mpgl.vo.Form;
import com.mpgl.vo.HouseVo;
import com.mpgl.vo.MenuVo;
import com.mpgl.vo.RoleVo;
import com.mpgl.vo.UserVo;

/**
 * MainService
 * 
 * @author 廖陈特
 * 
 */
public interface MainService {

	/**
	 * 用户登录
	 * 
	 * @param form
	 * @return UserVo 用户信息
	 */
	UserVo login(Form form);

	/**
	 * 检测用户账户是否存在
	 * 
	 * @param user
	 * @return
	 */
	boolean checkUserName(UserVo user);

	/**
	 * 修改用户密码
	 * 
	 * @param map
	 */
	void updateUserPassword(Map<String, Object> map);

	/**
	 * 批量插入门牌号数据
	 * 
	 * @param list
	 */
	void insertHouseNumberByList(List<Map<String, Object>> list);

	/**
	 * 获取用户的角色
	 * 
	 * @param user
	 * @return
	 */
	RoleVo getRoleByUser(UserVo user);

	/**
	 * 获取角色的菜单权限
	 * 
	 * @param role
	 * @return
	 */
	List<MenuVo> getMenuByRole(RoleVo role);

	/**
	 * 根据KEY查询字典表数据
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryDictionaryByKey(Form form);

	/**
	 * 查询单个用户信息
	 * 
	 * @param form
	 * @return
	 */
	Map<String, Object> queryUser(Form form);

	/**
	 * 查询用户列表
	 * 
	 * @param form
	 * @return
	 */
	Map<String, Object> queryUserDataGrid(Form form);

	/**
	 * 查询单个门牌数据
	 * 
	 * @param form
	 * @return
	 */
	Map<String, Object> queryHouseNumber(Form form);

	/**
	 * 查询门牌列表
	 * 
	 * @param form
	 * @return
	 */
	Map<String, Object> queryHouseNumberDataGrid(Form form);

	/**
	 * 查询导出门牌数据
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryHouseNumberList(Form form);

	/**
	 * 查询角色列表
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryRoleList();

	/**
	 * 新增用户
	 * 
	 * @param vo
	 */
	void addUser(UserVo vo);

	/**
	 * 修改用户
	 * 
	 * @param vo
	 */
	void updateUser(UserVo vo);

	/**
	 * 删除用户
	 * 
	 * @param vo
	 */
	void deleteUser(UserVo vo);

	/**
	 * 新增门牌
	 * 
	 * @param vo
	 */
	void addHouseNumber(HouseVo vo);

	/**
	 * 修改门牌
	 * 
	 * @param vo
	 */
	void updateHouseNumber(HouseVo vo);

	/**
	 * 删除门牌
	 * 
	 * @param vo
	 */
	void deleteHouseNumber(HouseVo vo);

}
