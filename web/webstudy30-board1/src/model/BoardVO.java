package model;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String password;
	private String content;
	private int hits;
	private String timePosted;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVO(int no, String title, String writer, String password, String content, int hit, String timePosted) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.password = password;
		this.content = content;
		this.hits = hit;
		this.timePosted = timePosted;
	}
	public BoardVO(int no, String title, String writer, String timePosted, int hit) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.timePosted = timePosted;
		this.hits = hit;
	}
	public BoardVO(String title, String writer, String timePosted, int hits, String content,int no) {
		this.title = title;
		this.writer = writer;
		this.timePosted = timePosted;
		this.hits = hits;
		this.content = content;
		this.no = no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

}
