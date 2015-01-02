package com.mpgl.main.dao;

import java.util.List;
import java.util.Map;

import com.mpgl.vo.Form;
import com.mpgl.vo.HouseVo;
import com.mpgl.vo.MenuVo;
import com.mpgl.vo.RoleVo;
import com.mpgl.vo.SubMenuVo;
import com.mpgl.vo.UserVo;

/**
 * MainDao
 * 
 * @author 廖陈特
 * 
 */
public interface MainDao {

	/**
	 * 用户登录-查询信息
	 * 
	 * @param form
	 * @return
	 */
	List<UserVo> login(Form form);

	/**
	 * 校验用户账户是否存在
	 * 
	 * @param vo
	 * @return
	 */
	int checkUserName(UserVo vo);

	/**
	 * 修改用户密码
	 * 
	 * @param map
	 */
	void updateUserPassword(Map<String, Object> map);

	/**
	 * 插入门牌号数据
	 * 
	 * @param map
	 */
	void insertHouseNumber(Map<String, Object> map);

	/**
	 * 查询用户的角色列表
	 * 
	 * @param user
	 * @return
	 */
	List<RoleVo> queryRoleByUser(UserVo user);

	/**
	 * 查询角色拥有的菜单列表
	 * 
	 * @param role
	 * @return
	 */
	List<MenuVo> queryMenuByRole(RoleVo role);

	/**
	 * 查询菜单的子菜单列表
	 * 
	 * @param map
	 * @return
	 */
	List<SubMenuVo> querySubMenuByMenu(Map<String, Object> map);

	/**
	 * 查询字典表数据
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryDictionaryByKey(Form form);

	/**
	 * 查询用户列表
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryUserList(Form form);

	/**
	 * 查询不分页数据
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryUserListBySingle(Form form);

	/**
	 * 查询用户列表条数
	 * 
	 * @param form
	 * @return
	 */
	int queryUserListCount(Form form);

	/**
	 * 查询门牌列表
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryHouseNumberList(Form form);

	/**
	 * 查询不分页门牌数据
	 * 
	 * @param form
	 * @return
	 */
	List<Map<String, Object>> queryHouseNumberListBySingle(Form form);

	/**
	 * 查询门牌列表条数
	 * 
	 * @param form
	 * @return
	 */
	int queryHouseNumberListCount(Form form);

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
