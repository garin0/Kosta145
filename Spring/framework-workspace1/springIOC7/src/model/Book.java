package model;

public class Book {
	private String title;
	private String writer;
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
	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + "]";
	}
	
}
