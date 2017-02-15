package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	public AccountDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
	}

	/**
	 * @throws SQLException
	 * 
	 */
	public boolean isExistAccount(String accountName) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select  count(*) from account where acc_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountName);
			rs = pstmt.executeQuery();
			while (rs.next() && rs.getInt(1) > 0) {
				flag = true;
			}

		} finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	public void createAccount(AccountVO vo) throws SQLException, CreateAccountException {
		if (vo.getBalance() < 1000)
			throw new CreateAccountException("1000�� �̻� �Ա����ּ���!");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "insert into account(acc_no,name,password,balance) values(acc_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setInt(3, vo.getBalance());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public String selectBalance(String accountNo, String password) throws SQLException, AccountLoginException {
		String nowBalance = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select balance from account where acc_no = ?  and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountNo);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				nowBalance = rs.getString(1);
			else
				throw new AccountLoginException("���¹�ȣ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} finally {
			closeAll(rs, pstmt, con);
		}
		return nowBalance;
	}

	public void deposit(String accountNo, int money) throws SQLException, NoMoneyException, AccountNotFoundException {
		if (money <= 0)
			throw new NoMoneyException("�Աݾ��� 0���� �ʰ��ؾ� �մϴ�!");
		if (isExistAccount(accountNo) == false)
			throw new AccountNotFoundException("�Աݰ��°� �������� �ʽ��ϴ�");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update account set balance = balance + ? where acc_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void withdraw(String accountNo, String password, int money)
			throws NoMoneyException, SQLException, AccountLoginException, InsufficientBalanceException {
		if (money < 1)
			throw new NoMoneyException("��ݾ��� 0���� �ʰ��ؾ� �մϴ�");
		String balance = selectBalance(accountNo, password);
		if (Integer.parseInt(balance) < money)
			throw new InsufficientBalanceException("�ܾ׺����Ͽ� ����� �� �����ϴ�");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "update account set balance = balance - ? where acc_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	/**
	 * ���� ��ü �۾� ���� ��ݾ��� �Աݾ���
	 * 
	 * �� �� ������ ��� ���������� �Ϸ�Ǿ��� ��� ���� �����ͺ��̽��� �۾������ �ݿ�(commit)
	 * 
	 * ���� �� ������ �߻��Ǹ� �۾� ��� (rollback)
	 * 
	 * @param myAccount
	 * @param password
	 * @param recAccount
	 * @param money
	 * @throws SQLException
	 * @throws NoMoneyException
	 * @throws AccountNotFoundException
	 * @throws AccountLoginException
	 * @throws InsufficientBalanceException
	 */
	public void transfer(String myAccount, String password, String recAccount, int transferMoney) throws SQLException,
			NoMoneyException, AccountNotFoundException, AccountLoginException, InsufficientBalanceException {
		if (transferMoney <= 0)
			throw new NoMoneyException("�߸��� ��ü���Դϴ�!");
		if (!isExistAccount(recAccount))
			throw new AccountNotFoundException("��ü���� ���°� �������� �ʽ��ϴ�");

		// �ܾ���ȸ�� ��й�ȣ üũ�ȴ�
		// ��й�ȣ �ٸ� ��쿡�� AccountLoginException �߻�
		int balance = Integer.parseInt(this.selectBalance(myAccount, password));
		// ��ü���� �ܾ׺��� ũ�ٸ� �ܾ׺��� ���� �߻����Ѿ� �Ѵ�.
		if (transferMoney > balance) {
			throw new InsufficientBalanceException("�ܾ� �����Ͽ� ���� �Ұ�");
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = this.getConnection();
			con.setAutoCommit(false); // ���� commit ���� ����
			String withdrawSql = "update account set balance = balance - ? where acc_no = ?";
			pstmt = con.prepareStatement(withdrawSql);
			pstmt.setInt(1, transferMoney);
			pstmt.setString(2, myAccount);
			int withdrawMoeny = pstmt.executeUpdate();
			System.out.println("��ü ����۾� �Ϸ�" + withdrawMoeny);
			pstmt.close();
			String sql = "update account set balance = balance + ? where acc_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, transferMoney);
			pstmt.setString(2, recAccount);
			int depositMoney = pstmt.executeUpdate();
			System.out.println("��ü �Ա��۾� �Ϸ�" + depositMoney);
			con.commit();
			System.out.println("commit:���� db�� ����");
		} catch (Throwable t) {
			con.rollback();
			System.out.println("rollback:�۾� ���");
			throw t;
		} finally {
			closeAll(pstmt, con);
		}

	}
}
