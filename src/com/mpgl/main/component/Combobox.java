package com.mpgl.main.component;

import javax.swing.JComboBox;

/**
 * 下拉框组件 继承自JComboBox,添加对List<Map>格式数据支持,模拟WEB下拉框
 * 
 * @author 廖陈特
 * 
 */
public class Combobox extends JComboBox {

	private static final long serialVersionUID = -7533696576705883219L;

	/**
	 * 获取选择对象的VALUE值
	 * 
	 * @return
	 */
	public String getSelectItemValue() {
		ComboboxModel model = null;
		if (this.getModel() instanceof ComboboxModel) {
			model = (ComboboxModel) this.getModel();
		}
		return model == null ? null : model.getSelectItemValue();
	}

	/**
	 * 设置对象VALUE值，组件会自动选择该项
	 * 
	 * @param value
	 */
	public void setSelectedItemByValue(Object value) {
		ComboboxModel model = null;
		if (this.getModel() instanceof ComboboxModel) {
			model = (ComboboxModel) this.getModel();
			model.setSelectedItemByValue(value);
		}
	}
}
