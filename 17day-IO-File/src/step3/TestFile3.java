package step3;

public class TestFile3 {

	public static void main(String[] args) {
		FileService service = new FileService();
		String fileName = "C:\\java-kosta\\util\\eclipse-jee-mars-2-win32-x86_64\\eclipse\\eclipse.exe";
		service.printfilePath(fileName);
		/* �ش� ���ϰ� ������ ���丮�� �ִ� ���ϸ� ����ϵ�
		 * �ڽ��� �����Ѵ�.
		 * .eclipseproduct
			artifacts.xml
			eclipse.ini
			eclipsec.exe
		 */
	}

}
