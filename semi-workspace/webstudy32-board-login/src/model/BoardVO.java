package model;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private int hits;
	private String writer;
	private String timePosted;
	private String id;
	private PagingBean pagingbean;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String content, int hits, String timePosted, String id,
			PagingBean pagingbean) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.timePosted = timePosted;
		this.id = id;
		this.pagingbean = pagingbean;
	}

	public BoardVO(String title, String content, String id) {
		this.title = title;
		this.content = content;
		this.id = id;
	}

	public BoardVO(int no, String title, int hits, String writer, String timePosted) {
		super();
		this.no = no;
		this.title = title;
		this.hits = hits;
		this.writer = writer;
		this.timePosted = timePosted;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PagingBean getPagingbean() {
		return pagingbean;
	}

	public void setPagingbean(PagingBean pagingbean) {
		this.pagingbean = pagingbean;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", hits=" + hits + ", timePosted="
				+ timePosted + ", id=" + id + "]";
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
