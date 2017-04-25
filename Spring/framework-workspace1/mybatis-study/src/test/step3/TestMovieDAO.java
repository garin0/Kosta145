package test.step3;

import java.util.List;

import model.DirectorVO;
import model.MovieDAO;
import model.MovieVO;

public class TestMovieDAO {

	public static void main(String[] args) {
		MovieDAO dao = MovieDAO.getInstance();
		/*String directorId = "a";
		Map<String, String> directorMap = dao.getDirectorInfo(directorId);
		System.out.println(directorMap);*/
		/*Map<String,Object> map = new HashMap<String, Object>();
		map.put("MOVIE_ID", "s");
		map.put("MOVIE_TITLE", "설국열차");
		map.put("MOVIE_GENRE", "SF");
		map.put("MOVIE_ATTENDANCE", 1000);
		map.put("DIRECTOR_ID", "a");
		dao.insertMovieMap(map);*/
		/*String movieId = "s";
		Map<String, Object> reMap = dao.getMoviewMap(movieId);
		System.out.println(reMap.get("TITLE")); //설국열차
		System.out.println(reMap.get("GENRE")); //SF
		System.out.println(reMap.get("ATTENDANCE")); //1000
		System.out.println(reMap.get("DIRECTOR_NAME")); //봉준호*/
		/*DirectorVO dvo = new DirectorVO("b","박찬욱","올드보이");
		dao.insertDirectorVO(dvo);
		System.out.println(dao.getDirectorInfo("b"));*/
		/*List<DirectorVO> list = dao.getAllDirectorList();
		for(DirectorVO dvo:list)
			System.out.println(dvo);*/
		/*MovieVO mvo = new MovieVO();
		mvo.setMovieId("g");
		mvo.setTitle("괴물");
		mvo.setGenre("코미디");
		mvo.setAttendance(2000);
		DirectorVO dvo = new DirectorVO();
		dvo.setDirectorId("a");
		mvo.setDirectorVO(dvo);
		dao.insertMovieVO(mvo);
		System.out.println(dao.getMoviewMap("g"));*/
		/*List<MovieVO> list = dao.getMovieListAndDirectorInfo();
		for(MovieVO mvo:list)
			System.out.println(mvo.getTitle()+" "+mvo.getDirectorVO().getDirectorName());*/
		MovieVO vo = dao.getMovieAndDirectorDetailInfo("g");
		System.out.println(vo.getMovieId());
		System.out.println(vo.getTitle());
		System.out.println(vo.getGenre());
		System.out.println(vo.getAttendance());
		System.out.println(vo.getDirectorVO().getDirectorId());
		System.out.println(vo.getDirectorVO().getDirectorName());
		System.out.println(vo.getDirectorVO().getIntro());
		}

}
