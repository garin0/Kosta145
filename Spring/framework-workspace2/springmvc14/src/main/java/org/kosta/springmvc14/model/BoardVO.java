package org.kosta.springmvc14.model;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private int hit;
	private String time_posted;
	private String smid;
	private MemberVO memberVO;
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String content, int hit, String time_posted, String smid, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.time_posted = time_posted;
		this.smid = smid;
		this.memberVO = memberVO;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTime_posted() {
		return time_posted;
	}
	public void setTime_posted(String time_posted) {
		this.time_posted = time_posted;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String getSmid() {
		return smid;
	}

	public void setSmid(String smid) {
		this.smid = smid;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", time_posted="
				+ time_posted + ", smid=" + smid + ", memberVO=" + memberVO + "]";
	}

	
}
