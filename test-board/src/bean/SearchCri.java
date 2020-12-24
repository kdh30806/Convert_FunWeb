package bean;

public class SearchCri {
	
	private String searchFlag;
	private String search;
	private String pageNum;
	
	
	public SearchCri(String searchFlag, String search, String pageNum) {
		super();		
		if(searchFlag == null) {
			searchFlag = "false";
		}
		this.searchFlag = searchFlag;
		this.search = search;
		if(pageNum == null) {
			pageNum = "1";
		}
		this.pageNum = pageNum;
	}
	
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	
}
