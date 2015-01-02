package com.mpgl.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mpgl.main.dao.MainDao;
import com.mpgl.main.service.MainService;
import com.mpgl.util.Constant;
import com.mpgl.vo.Form;
import com.mpgl.vo.HouseVo;
import com.mpgl.vo.MenuVo;
import com.mpgl.vo.RoleVo;
import com.mpgl.vo.UserVo;

/**
 * MainServiceImpl
 * 
 * @author 廖陈特
 * 
 */
public class MainServiceImpl implements MainService {

	/**
	 * Dao
	 */
	private MainDao mainDao;

	public MainDao getMainDao() {
		return mainDao;
	}

	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Override
	public UserVo login(Form form) {
		UserVo user = null;
		List<UserVo> list = mainDao.login(form);
		if (list != null && list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}

	@Override
	public void insertHouseNumberByList(List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			mainDao.insertHouseNumber(map);
		}
	}

	@Override
	public RoleVo getRoleByUser(UserVo user) {
		RoleVo vo = null;
		List<RoleVo> list = mainDao.queryRoleByUser(user);
		if (list != null && list.size() > 0) {
			vo = list.get(0);
		}
		return vo;
	}

	@Override
	public List<MenuVo> getMenuByRole(RoleVo role) {
		List<MenuVo> list = mainDao.queryMenuByRole(role);
		if (list != null && list.size() > 0) {
			for (MenuVo menu : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_id", role.getId());
				map.put("menu_id", menu.getId());
				menu.setList(mainDao.querySubMenuByMenu(map));
			}
		}
		return list;
	}

	@Override
	public Map<String, Object> queryUserDataGrid(Form form) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = mainDao.queryUserList(form);
		int count = mainDao.queryUserListCount(form);
		map.put(Constant.ROW_KEY, list);
		map.put(Constant.ROW_TOTAL, count);
		return map;
	}

	@Override
	public Map<String, Object> queryUser(Form form) {
		Map<String, Object> map = null;
		List<Map<String, Object>> list = mainDao.queryUserListBySingle(form);
		if (list != null && list.size() > 0) {
			map = list.get(0);
		}
		return map;
	}

	@Override
	public void addUser(UserVo vo) {
		mainDao.addUser(vo);
	}

	@Override
	public void updateUser(UserVo vo) {
		mainDao.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVo vo) {
		mainDao.deleteUser(vo);
	}

	@Override
	public List<Map<String, Object>> queryDictionaryByKey(Form form) {
		return mainDao.queryDictionaryByKey(form);
	}

	@Override
	public List<Map<String, Object>> queryRoleList() {
		return mainDao.queryRoleList();
	}

	@Override
	public Map<String, Object> queryHouseNumberDataGrid(Form form) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = mainDao.queryHouseNumberList(form);
		int count = mainDao.queryHouseNumberListCount(form);
		map.put(Constant.ROW_KEY, list);
		map.put(Constant.ROW_TOTAL, count);
		return map;
	}

	@Override
	public Map<String, Object> queryHouseNumber(Form form) {
		Map<String, Object> map = null;
		List<Map<String, Object>> list = mainDao
				.queryHouseNumberListBySingle(form);
		if (list != null && list.size() > 0) {
			map = list.get(0);
		}
		return map;
	}

	@Override
	public void addHouseNumber(HouseVo vo) {
		mainDao.addHouseNumber(vo);
	}

	@Override
	public void updateHouseNumber(HouseVo vo) {
		mainDao.updateHouseNumber(vo);
	}

	@Override
	public void deleteHouseNumber(HouseVo vo) {
		mainDao.deleteHouseNumber(vo);
	}

	@Override
	public List<Map<String, Object>> queryHouseNumberList(Form form) {
		return mainDao.queryHouseNumberListBySingle(form);
	}

	@Override
	public void updateUserPassword(Map<String, Object> map) {
		mainDao.updateUserPassword(map);
	}

	@Override
	public boolean checkUserName(UserVo user) {
		boolean isCheck = true;
		int count = mainDao.checkUserName(user);
		if (count > 0) {
			isCheck = false;
		}
		return isCheck;
	}
}
