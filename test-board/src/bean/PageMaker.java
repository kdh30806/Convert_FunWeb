package bean;

public class PageMaker {

	private PageBean pd;
	private int pageCount;
	private int pageBlock;
	private int startPage;
	private int endPage;
	
	public void cal() {		
		pageBlock = 5;
		pageCount = pd.getCount() / pd.getPageSize() + (pd.getCount() % pd.getPageSize() == 0 ? 0 : 1);
		startPage = (pd.getPageNum() - 1) / pageBlock * pageBlock + 1;
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount) {
			endPage = pageCount;		
		}
		
	}
	public PageBean getPageDAO() {
		return pd;
	}
	public void setPageDAO(PageBean pageDAO) {
		this.pd = pageDAO;
		cal();
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
