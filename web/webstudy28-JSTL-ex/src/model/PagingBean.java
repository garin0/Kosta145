package model;

public class PagingBean {
	private int nowPage; //현재 페이지
	private int startPage; // 페이징 넘버링 시작번호
	private int endPage;
	public PagingBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagingBean(int nowPage, int startPage, int endPage) {
		super();
		this.nowPage = nowPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
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
	@Override
	public String toString() {
		return "PagingBean [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
