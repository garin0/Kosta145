package test;

import java.sql.SQLException;

import model.MemberDAO;

public class TestMemberDAO5 {

	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			String address = "�Ǳ�";
			int count = dao.getMemberCountByAddress(address);
			System.out.println(address + "�� ��� ȸ����: " + count);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
