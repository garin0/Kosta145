package school;

public class DuplicateTelException extends Exception {
	private static final long serialVersionUID = 5116982927894760626L;

	public DuplicateTelException() {
		super("��ȭ��ȣ�� �ߺ��˴ϴ�.");
	}

	public DuplicateTelException(String message) {
		super(message);
	}
}
