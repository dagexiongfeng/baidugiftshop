package baidu.giftshop.bean;

public class PageBean {
	 private Integer currentPage=1;//设置当前页面
	 
	 private Integer previousPage=0;
	 
	 private Integer nextPage=2;
	 
	 private Integer firstPage=1;
	 
	 private Integer lastPage;
	 
	 private Integer perPage=4;
	 
	 private Integer allRecords;
	 
	 private Integer allPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getAllRecords() {
		return allRecords;
	}

	public void setAllRecords(Integer allRecords) {
		this.allRecords = allRecords;
	}

	public Integer getAllPage() {
		return allPage;
	}

	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}

	public PageBean init(PageBean pageBean,int totalSize){
		pageBean.setAllRecords(totalSize);
		pageBean.setAllPage(totalSize % pageBean.getPerPage() == 0 ? totalSize/pageBean.getPerPage() : totalSize/pageBean.getPerPage()+1);
		pageBean.setFirstPage(1);
		pageBean.setLastPage(pageBean.getAllPage());
		if(pageBean.getCurrentPage() == 1)
			pageBean.setPreviousPage(1);
		else
			pageBean.setPreviousPage(pageBean.getCurrentPage() - 1);
		// || pageBean.getCurrentPage() > pageBean.getAllPage()
		if(pageBean.getCurrentPage() == pageBean.getAllPage())
			pageBean.setNextPage(pageBean.getAllPage());
		else
			pageBean.setNextPage(pageBean.getCurrentPage() + 1);
		return pageBean;
	}
}


