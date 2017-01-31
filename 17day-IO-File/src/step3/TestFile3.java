package step3;

public class TestFile3 {

	public static void main(String[] args) {
		FileService service = new FileService();
		String fileName = "C:\\java-kosta\\util\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\eclipse.exe";
		service.printfilePath(fileName);
		/* 해당 파일과 동일한 디렉토리에 있는 파일명만 출력하되
		 * 자신은 제외한다.
		 * .eclipseproduct
			artifacts.xml
			eclipse.ini
			eclipsec.exe
		 */
	}

}
