package com.mpgl.vo;

/**
 * 查询表单Vo
 * 
 * @author user
 * 
 */
public class Form {

	/**
	 * 用户ID
	 */
	private String user_id;

	/**
	 * 用户实际姓名
	 */
	private String name;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 角色ID
	 */
	private String role_id;

	/**
	 * 账户是否锁定
	 */
	private String isLock;

	/**
	 * 字典表KEY
	 */
	private String dictionaryKey;

	/**
	 * 门牌数据ID
	 */
	private String house_id;

	/**
	 * 道路名称
	 */
	private String road_name;

	/**
	 * 产权主姓名
	 */
	private String property_name;

	/**
	 * 现用户姓名
	 */
	private String now_user_name;

	/**
	 * 现门牌号
	 */
	private String now_house_num;

	/**
	 * 门牌方位
	 */
	private String house_num_position;

	/**
	 * 所属市县区及乡、镇、街道、村、居委会名称
	 */
	private String city;

	/**
	 * 用户建筑物名称及性质
	 */
	private String nature;

	/**
	 * 门牌号
	 */
	private String houseNumber;

	/**
	 * 街道名
	 */
	private String streetName;

	/**
	 * 分页对象
	 */
	private PageVo page;

	public Integer getPageSize() {
		return page == null ? null : page.getPageSize();
	}

	public Integer getPageIndex() {
		return page == null ? null : page.getPageIndex();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDictionaryKey() {
		return dictionaryKey;
	}

	public void setDictionaryKey(String dictionaryKey) {
		this.dictionaryKey = dictionaryKey;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getNow_user_name() {
		return now_user_name;
	}

	public void setNow_user_name(String now_user_name) {
		this.now_user_name = now_user_name;
	}

	public String getNow_house_num() {
		return now_house_num;
	}

	public void setNow_house_num(String now_house_num) {
		this.now_house_num = now_house_num;
	}

	public String getHouse_num_position() {
		return house_num_position;
	}

	public void setHouse_num_position(String house_num_position) {
		this.house_num_position = house_num_position;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getHouse_id() {
		return house_id;
	}

	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PageVo getPage() {
		return page;
	}

	public void setPage(PageVo page) {
		this.page = page;
	}
}
