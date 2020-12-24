package bean;

public class PageBean {

	private int count; // 전체 글 갯수
	private int pageNum; // 페이지 번호
	private int pageSize; // 한 페이지에 출력할 게시글 수
	private int startRow;
	private int endRow;

	public void cal() {
		pageSize = 7;
		startRow = (pageNum - 1) * pageSize + 1;
		endRow = pageNum * pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		cal();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		this.pageNum = Integer.parseInt(pageNum);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}