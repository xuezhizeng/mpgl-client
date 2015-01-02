package com.mpgl.main.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;

/**
 * 下拉框组件数据模型 继承自DefaultComboBoxModel,添加对List<Map>数据支持,模拟WEB端下拉框
 * 
 * @author 廖陈特
 * 
 */
public class ComboboxModel extends DefaultComboBoxModel {

	private static final long serialVersionUID = -7629379686967132855L;

	/**
	 * 数据源
	 */
	private List<Map<String, Object>> list;

	/**
	 * 当前选择对象
	 */
	private Object selectedObject;

	/**
	 * 构造函数
	 */
	public ComboboxModel() {
		list = new ArrayList<Map<String, Object>>();
	}

	/**
	 * 构造方法
	 * 
	 * @param list
	 *            数据源
	 */
	public ComboboxModel(List<Map<String, Object>> list) {
		this.list = list;
		if (list != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("textField", "全部");
			map.put("valueField", "");
			list.add(0, map);
		}
		if (getSize() > 0) {
			selectedObject = getElementAt(0);
		}
	}

	/**
	 * 构造方法
	 * 
	 * @param list
	 *            数据源
	 * @param noFill
	 *            不填 全部选项
	 */
	public ComboboxModel(List<Map<String, Object>> list, boolean noFill) {
		this.list = list;
		if (getSize() > 0) {
			selectedObject = getElementAt(0);
		}
	}

	/**
	 * Set the value of the selected item. The selected item may be null.
	 * <p>
	 * 
	 * @param anObject
	 *            The combo box value or null for no selection.
	 */
	public void setSelectedItem(Object anObject) {
		if ((selectedObject != null && !selectedObject.equals(anObject))
				|| selectedObject == null && anObject != null) {
			selectedObject = anObject;
		}
		fireContentsChanged(this, -1, -1);
	}

	// implements javax.swing.ComboBoxModel
	public Object getSelectedItem() {
		return selectedObject;
	}

	/**
	 * 返回选择对象的VALUE
	 * 
	 * @return
	 */
	public String getSelectItemValue() {
		String value = null;
		for (Map<String, Object> map : list) {
			if (map.get("textField").toString().equals(selectedObject)) {
				value = map.get("valueField").toString();
			}
		}
		return value;
	}

	public void setSelectedItemByValue(Object value) {
		Object anObject = null;
		for (Map<String, Object> map : list) {
			if (map.get("valueField").toString().equals(value + "")) {
				anObject = map.get("textField");
			}
		}
		if ((selectedObject != null && !selectedObject.equals(anObject))
				|| selectedObject == null && anObject != null) {
			selectedObject = anObject;
		}
		fireContentsChanged(this, -1, -1);
	}

	// implements javax.swing.ListModel
	public int getSize() {
		return list.size();
	}

	// implements javax.swing.ListModel
	public Object getElementAt(int index) {
		if (index >= 0 && index < list.size())
			return list.get(index).get("textField");
		else
			return null;
	}

	/**
	 * Returns the index-position of the specified object in the list.
	 * 
	 * @param anObject
	 * @return an int representing the index position, where 0 is the first
	 *         position
	 */
	public int getIndexOf(Object anObject) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			if (map.get("textField").toString().equals(anObject)) {
				index = i;
			}
		}
		return index;

	}
}
