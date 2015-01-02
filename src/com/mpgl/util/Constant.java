package com.mpgl.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/**
 * 常量类
 * 
 * @author 廖陈特
 * 
 */
public interface Constant {

	/**
	 * 默认日期格式
	 */
	SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 模版文件夹路径
	 */
	String TEMPLATE_PATH = "template/";

	/**
	 * Spring对象KEY
	 */
	String SPRING_CONTEXT = "springContext";

	/**
	 * DataGrid数据集KEY
	 */
	String ROW_KEY = "rows";

	/**
	 * DataGrid数据集总条数
	 */
	String ROW_TOTAL = "total";

	/**
	 * SESSION中用户信息存放KEY
	 */
	String USER = "USER";

	/**
	 * 进度条计数
	 */
	String PROGRESS_NUMBER = "PROGRESS_NUMBER";

	/**
	 * 屏幕大小
	 */
	Dimension SCREENDIMEN = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * 主界面大小
	 */
	Dimension MAINDIMEN = new Dimension(SCREENDIMEN.width, SCREENDIMEN.height);

	/**
	 * 门牌管理Dialog大小
	 */
	Dimension HOUSEDIALOGDIMEN = new Dimension(700, 600);

	/**
	 * 用户管理Dialog大小
	 */
	Dimension USERDIALOGDIMEN = new Dimension(400, 350);

	/**
	 * 修改密码窗口Dialog大小
	 */
	Dimension EDITPASSWORDDIMEN = new Dimension(300, 180);

	/**
	 * 系统设置窗口Dialog大小
	 */
	Dimension SYSTEM_SETTING = new Dimension(380, 220);

	/**
	 * 软件标志图片
	 */
	Image imageMain = Toolkit.getDefaultToolkit()
			.createImage("images/main.png");

	/**
	 * 登录框背景图片
	 */
	ImageIcon iconLoginBackground = new ImageIcon("images/Login.png");

	/**
	 * 信息框图片
	 */
	ImageIcon iconInfo = new ImageIcon("images/icon/info.png");

	/**
	 * 错误框图片
	 */
	ImageIcon iconError = new ImageIcon("images/icon/error.png");

	/**
	 * 警告框图片
	 */
	ImageIcon iconWaring = new ImageIcon("images/icon/waring.png");

	/**
	 * 新增
	 */
	ImageIcon iconAdd = new ImageIcon("images/icon/edit_add.png");

	/**
	 * 修改
	 */
	ImageIcon iconEdit = new ImageIcon("images/icon/pencil.png");

	/**
	 * 删除
	 */
	ImageIcon iconDel = new ImageIcon("images/icon/cancel.png");

	/**
	 * 查询
	 */
	ImageIcon iconQuery = new ImageIcon("images/icon/search.png");

	/**
	 * 重置
	 */
	ImageIcon iconReset = new ImageIcon("images/icon/reload.png");

	/**
	 * 上传
	 */
	ImageIcon iconUpload = new ImageIcon("images/icon/upload.png");

	/**
	 * 导出
	 */
	ImageIcon iconExport = new ImageIcon("images/icon/excel.png");

	/**
	 * 打印
	 */
	ImageIcon iconPrint = new ImageIcon("images/icon/print.png");

	/**
	 * 单位信息
	 */
	ImageIcon iconStar = new ImageIcon("images/icon/star.png");

	/**
	 * 系统设置
	 */
	ImageIcon iconSetting = new ImageIcon("images/icon/setting.png");

	/**
	 * LOGO
	 */
	ImageIcon iconSynchro = new ImageIcon("images/icon/synchro.png");

	/**
	 * 登录
	 */
	ImageIcon iconStart = new ImageIcon("images/icon/start.png");

	/**
	 * 退出
	 */
	ImageIcon iconExit = new ImageIcon("images/icon/exit.png");

	/**
	 * 用户头像
	 */
	ImageIcon iconPrivacy = new ImageIcon("images/icon/privacy.png");

	/**
	 * 保存
	 */
	ImageIcon iconSave = new ImageIcon("images/icon/ok.png");

	/**
	 * 关闭
	 */
	ImageIcon iconCancel = new ImageIcon("images/icon/cancel.png");

	/**
	 * 模板
	 */
	ImageIcon iconTemplate = new ImageIcon("images/icon/new.png");

	/**
	 * 导入数据 列名数组
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface IMPORT_CLOUMN {
		/**
		 * 门牌数据导入列名数组
		 */
		String[] HOUSE_COLUMNS = { "city", "road_name", "road_direction",
				"road_level", "road_start_end", "house_num_position",
				"house_num_point", "property_name", "property_phone",
				"now_user_name", "now_user_phone", "now_house_num",
				"old_house_num", "nature", "mark", "description" };
	}

	/**
	 * 导出数据 列名数组
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface EXPORT_CLOUMN {
		/**
		 * 门牌数据导出列名数组
		 */
		String[] HOUSE_COLUMNS = { "所属市县区及乡、镇、街道、村、居委会名称", "道路名称", "道路走向",
				"道路级别", "道路起止点", "门牌方位", "门牌坐标", "产权主姓名", "产权主联系电话", "现用户姓名",
				"现用户联系电话", "现门牌号码", "原门牌号码", "用户建筑物名称及性质", "相邻地名标志物名称", "备注" };

		/**
		 * 导出列宽度
		 */
		int[] HOUSE_WIDTHS = { 500, 200, 200, 200, 200, 200, 200, 200, 200,
				200, 200, 200, 200, 200, 200, 200 };

		/**
		 * 门牌数据导出列名Key数组
		 */
		String[] HOUSE_KEYS = { "city", "road_name", "road_direction",
				"road_level", "road_start_end", "house_num_position",
				"house_num_point", "property_name", "property_phone",
				"now_user_name", "now_user_phone", "now_house_num",
				"old_house_num", "nature", "mark", "description" };
	}

	/**
	 * JTable控件使用数组 列名数组
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface TABLE {
		/**
		 * 门牌数据列名数组
		 */
		String[] HOUSE_COLUMNS = { "ID", "所属市县区及乡、镇、街道、村、居委会名称", "道路名称",
				"道路走向", "道路级别", "道路起止点", "门牌方位", "门牌坐标", "产权主姓名", "产权主联系电话",
				"现用户姓名", "现用户联系电话", "现门牌号码", "原门牌号码", "用户建筑物名称及性质",
				"相邻地名标志物名称", "备注" };

		/**
		 * 门牌数据列名Key数组
		 */
		String[] HOUSE_KEYS = { "id", "city", "road_name", "road_direction",
				"road_level", "road_start_end", "house_num_position",
				"house_num_point", "property_name", "property_phone",
				"now_user_name", "now_user_phone", "now_house_num",
				"old_house_num", "nature", "mark", "description" };

		/**
		 * 用户数据列名数组
		 */
		String[] USER_COLUMNS = { "ID", "用户名", "密码", "实际姓名", "角色", "创建时间",
				"修改时间", "是否锁定" };

		/**
		 * 用户数据列名Key数组
		 */
		String[] USER_KEYS = { "id", "username", "password", "name",
				"role_name", "create_time", "update_time", "isLock" };
	}

	/**
	 * 菜单对应Code
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface MENU {

		/**
		 * 菜单代码CODE1
		 */
		String CODE1 = "HouseNumberManagerPanel";

		/**
		 * 菜单代码CODE2
		 */
		String CODE2 = "ImportHouseNumberPanel";

		/**
		 * 菜单代码CODE3
		 */
		String CODE3 = "UserManagerPanel";
	}

	/**
	 * 确认框-选择参数
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface CONFIRM {

		/**
		 * 确定
		 */
		int YSE = 0;

		/**
		 * 取消
		 */
		int NO = 1;
	}

	/**
	 * 提示信息
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface MESSAGE {

		/**
		 * 弹出框标题-欢迎使用
		 */
		String TITLE_WELCOME = "欢迎使用";

		/**
		 * 弹出框标题-安全退出
		 */
		String TITLE_EXIT = "安全退出";

		/**
		 * 弹出框标题-修改密码
		 */
		String TITLE_EDITPWD = "修改密码";

		/**
		 * 弹出框标题-单位信息
		 */
		String TITLE_UNIT = "单位信息";

		/**
		 * 弹出框标题-信息提示框
		 */
		String TITLE_INFO = "信息提示框";

		/**
		 * 弹出框标题-错误提示框
		 */
		String TITLE_ERROR = "错误提示框";

		/**
		 * 弹出框标题-删除确认框
		 */
		String TITLE_DELETE = "删除确认框";

		/**
		 * 弹出框内容-用户名重复
		 */
		String USER_REPEAT = "用户名重复";

		/**
		 * 弹出框内容-用户名或密码错误
		 */
		String USER_ERROR = "用户名或密码错误";

		/**
		 * 弹出框内容-请输入用户名和密码
		 */
		String USER_EMPTY = "请输入用户名和密码";

		/**
		 * 弹出框内容-确定要删除数据吗
		 */
		String DELETE_CONFIRM = "确定要删除数据吗?";

		/**
		 * 弹出框内容-请先选择数据,再进行操作
		 */
		String ERROR_SELECT = "请先选择数据,再进行操作.";

		/**
		 * 弹出框内容-服务器出错
		 */
		String ERROR_SERVER = "服务器出错.";

		/**
		 * 弹出框内容-请选择要上传的文件
		 */
		String ERROR_FILE = "请选择要上传的文件";

		/**
		 * 弹出框内容-您选择的文件不存在或者路径填写错误
		 */
		String ERROR_PATH = "您选择的文件不存在或者路径填写错误";

		/**
		 * 弹出框内容-导入失败
		 */
		String ERROR_IMPORT = "导入失败";

		/**
		 * 弹出框内容-新密码不能为空
		 */
		String ERROR_NEWPASSWORD = "新密码不能为空.";

		/**
		 * 弹出框内容-新密码不能为空
		 */
		String ERROR_ADDUSERNAME = "用户名不能为空.";

		/**
		 * 弹出框内容-修改成功
		 */
		String INFO_EDIT = "修改成功";

		/**
		 * 弹出框内容-导入成功
		 */
		String INFO_IMPORT = "导入成功";

		/**
		 * 弹出框内容-导出成功,文件保存路径为
		 */
		String INFO_EXPORT = "导出成功,文件保存路径为:";

		/**
		 * 弹出框内容-下载成功,文件保存路径为
		 */
		String INFO_DOWNLOAD = "下载成功,文件保存路径为:";

		/**
		 * 弹出框内容-系统设置保存成功,重启软件后生效
		 */
		String INFO_SETTING = "系统设置保存成功,重启软件后生效.";

		/**
		 * 弹出框内容-您确定要退出系统吗
		 */
		String INFO_EXIT = "您确定要退出系统吗?";

		/**
		 * 滴答滴
		 */
		String DIDADI = "滴答滴";
	}

	/**
	 * 常用按钮名称
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface BUTTON {

		String ADD = "新增";

		String EDIT = "修改";

		String DEL = "删除";

		String EXPORT = "导出";

		String PRINT = "打印";

		String QUERY = "查询";

		String RESET = "重置";

		String SAVE = "保存";

		String CLOSE = "关闭";

		String UNIT = "单位信息";

		String EDITPWD = "修改密码";

		String SETTING = "系统设置";

		String EXIT = "退出";

		String HOME = "首页";

		String LOGIN = "登录";

		String SELECT_FILE = "选择文件";

		String UPLOAD = "上传";

		String TEMPLATE = "模板";
	}

	/**
	 * Dialog常用标题明
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface DIALOG {

		String ADD = "新增数据";

		String EDIT = "修改数据";

		String EDIT_PASSWORD = "修改密码";

		String SYSTEM_SETTING = "系统设置";
	}

	/**
	 * 字体
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface FONT {

		Font SONGTI = new Font("新宋体", Font.PLAIN, 14);

		Font HEITI = new Font("黑体", Font.PLAIN, 14);
	}

	/**
	 * 日志输出标签名
	 * 
	 * @author 廖陈特
	 * 
	 */
	public interface LOG {
		String ERROR = "【错误】";

		String DEBUG = "【调试】";
	}
}