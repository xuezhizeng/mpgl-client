package com.mpgl.main.component;

import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

/**
 * TABLE数据模型
 * 
 * @author 廖陈特
 * 
 */
public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5664650190551856079L;

	/**
	 * 数据源
	 */
	private List<Map<String, Object>> list;

	/**
	 * 表头数组
	 */
	private String[] cloumns;

	/**
	 * 数据键值数组
	 */
	private String[] keys;

	/**
	 * 构造函数
	 * 
	 * @param cloumns
	 *            表头数组
	 * @param keys
	 *            数据键值数组
	 * @param list
	 *            数据源
	 */
	public TableModel(String[] cloumns, String[] keys,
			List<Map<String, Object>> list) {
		this.cloumns = cloumns;
		this.keys = keys;
		this.list = list;
	}

	/**
	 * 数据格式化,把相关ID转成对应的文本显示
	 * 
	 * @param key
	 * @param list
	 */
	public void formatter(String key, List<Map<String, Object>> convertList) {
		for (Map<String, Object> dataMap : list) {
			Object data_value = dataMap.get(key) + "";
			for (Map<String, Object> convertMap : convertList) {
				if (convertMap.get("valueField").equals(data_value)) {
					dataMap.put(key, convertMap.get("textField"));
					break;
				}
			}
		}
	}

	@Override
	public int getRowCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public int getColumnCount() {
		return cloumns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return list.get(rowIndex).get(keys[columnIndex]);
	}

	@Override
	public String getColumnName(int column) {
		return this.cloumns[column];
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

	public String[] getCloumns() {
		return cloumns;
	}

	public void setCloumns(String[] cloumns) {
		this.cloumns = cloumns;
	}

}
