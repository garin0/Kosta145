package model;

import java.util.List;

public class Dormitory implements Residence {
	private String schoolName;
	private List<Book> library;
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Book> getLibrary() {
		return library;
	}

	public void setLibrary(List<Book> library) {
		this.library = library;
	}

	@Override
	public void reside() {
		System.out.println("학교명:"+schoolName+" 서고:"+library);

	}

}
