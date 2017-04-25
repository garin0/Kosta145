package model;

public class MovieVO {
	private String movieId;
	private String title;
	private String genre;
	private int attendance;
	private DirectorVO directorVO;
	public MovieVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieVO(String movieId, String title, String genre, int attendance, DirectorVO directorVO) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.attendance = attendance;
		this.directorVO = directorVO;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public DirectorVO getDirectorVO() {
		return directorVO;
	}
	public void setDirectorVO(DirectorVO directorVO) {
		this.directorVO = directorVO;
	}
	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", attendance=" + attendance
				+ ", directorVO=" + directorVO + "]";
	}
	
}	
