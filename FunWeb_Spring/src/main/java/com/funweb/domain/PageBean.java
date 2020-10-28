package com.funweb.domain;

public class PageBean {
	
	private int count;
	private int pageSize;
	private String pageNum;
	private int currentPage;
	private int startRow;
	private int endRow;
	private int pageCount;
	private int pageBlock;
	private int startPage;
	private int endPage;
	private String category;
	private String search;
	
	
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		//페이징 관련 계산 메서드 호출
		init();
	}
	public void init() {
		//페이징 갯수 count%pageSize해서 나머지가 0이면 +0 나머지가 있으면 +1
		pageCount= count/pageSize+(count%pageSize==0?0:1);
		// 보여질 페이징 갯수 넘어가면 다음/이전 생김
		pageBlock=5;
		// startPage 시작페이지 페이지가 3개 보이는 것중 첫번째 페이지
		startPage= (currentPage-1)/pageBlock*pageBlock+1;
		// endPage 페이지 3개 보이는 것중 마지막 페이지
		endPage= startPage + pageBlock -1;
		if(endPage > pageCount){
		 	endPage=pageCount;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
