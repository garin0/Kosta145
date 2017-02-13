package school;

public class DuplicateTelException extends Exception {
	private static final long serialVersionUID = 5116982927894760626L;

	public DuplicateTelException() {
		super("전화번호가 중복됩니다.");
	}

	public DuplicateTelException(String message) {
		super(message);
	}
}
