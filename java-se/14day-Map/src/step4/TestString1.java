package step4;

public class TestString1 {

	public static void main(String[] args) {
		String name1 = "������";
		String name2 = new String("������");
		String name3 = "������";
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
		// ���ڿ� �񱳴� equals() �� �ؾ� �Ѵ�.
		System.out.println(name1.equals(name2));
		System.out.println(name1.indexOf("��"));
		System.out.println(name1.indexOf("��"));
		String name4 = " ������";
		System.out.println(name1.equals(name4));
		// trim()�� �̿��� �� ���� �����ϸ� �ȴ�.
		System.out.println(name1.equals(name4.trim()));
		String name5 = "�������ٸ�";
		System.out.println(name5.substring(2));
		// substring(beginIndex,endIndex);�� �̿��� ���ٸ� ���
		System.out.println(name5.substring(2, 4));
		// name5�� ���� �����ϸ� true
		System.out.println(name5.startsWith("����"));
		// name5�� ���� �������� true or false
		System.out.println(name5.endsWith("��"));
		String name6 = "javaking";
		String name7 = "JAVAking";
		System.out.println(name6.equals(name7));
		// ��ҹ��� ���� ���� ��
		System.out.println(name7.equalsIgnoreCase(name6));
		String name8 = "���ε�Ʈ����";
		System.out.println(name8.replace("Ʈ����", "��"));
		String name9 = "ch.qos.logback.classic_1.0.7.v20121108-1250.jar";
		System.out.println(name9.lastIndexOf(".")); // ������ . �ε��� ��ġ
		System.out.println(name9.indexOf(".")); // ù��° . �ε��� ��ġ
		String menu = "����,����,����,ġŲ,����";
		String ma[] = menu.split(",");
		for (int i = 0; i < ma.length; i++) {
			System.out.println(ma[i]);
		}
	}

}
