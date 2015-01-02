package com.mpgl.vo;

/**
 * 分页Vo
 * 
 * @author user
 * 
 */
public class PageVo {

	/**
	 * 总记录数
	 */
	private int countData;

	/**
	 * 当前页
	 */
	private int nowPage;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 计算后记录开始点
	 */
	private int pageIndex;

	/**
	 * 页码尺寸
	 */
	private int pageSize;

	public PageVo() {
		nowPage = 1;
		totalPage = 1;
		pageIndex = 0;
		pageSize = 50;
		countData = 0;
	}

	/**
	 * 计算下一页
	 */
	public void nextPage() {
		if (nowPage != totalPage) {
			nowPage++;
			pageIndex = (nowPage - 1) * pageSize + 1;
		}
	}

	/**
	 * 计算上一页
	 */
	public void lastPage() {
		if (nowPage != 1) {
			nowPage--;
			pageIndex = (nowPage - 1) * pageSize;
		} else {
			pageIndex = 0;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCountData() {
		return countData;
	}

	public void setCountData(int countData) {
		this.countData = countData;
		if (countData != 0) {
			if (countData % 50 == 0) {
				totalPage = countData / 50;
			} else {
				totalPage = countData / 50 + 1;
			}
		} else {
			nowPage = 1;
			totalPage = 1;
		}
	}
}
