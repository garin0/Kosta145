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
			throw new CreateAccountException("1000원 이상 입금해주세요!");
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
				throw new AccountLoginException("계좌번호와 비밀번호가 일치하지 않습니다.");
		} finally {
			closeAll(rs, pstmt, con);
		}
		return nowBalance;
	}

	public void deposit(String accountNo, int money) throws SQLException, NoMoneyException, AccountNotFoundException {
		if (money <= 0)
			throw new NoMoneyException("입금액은 0원을 초과해야 합니다!");
		if (isExistAccount(accountNo) == false)
			throw new AccountNotFoundException("입금계좌가 존재하지 않습니다");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			throw new NoMoneyException("출금액은 0원을 초과해야 합니다");
		String balance = selectBalance(accountNo, password);
		if (Integer.parseInt(balance) < money)
			throw new InsufficientBalanceException("잔액부족하여 출금할 수 없습니다");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "update account set balance = balance - ? where acc_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			rs = pstmt.executeQuery();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void transfer(String myAccount, String password, String recAccount, int money) throws SQLException,
			NoMoneyException, AccountNotFoundException, AccountLoginException, InsufficientBalanceException {
		if (money <= 0)
			throw new NoMoneyException("잘못된 이체액입니다!");
		if (!isExistAccount(recAccount))
			throw new AccountNotFoundException("이체받을 계좌가 존재하지 않습니다");
		withdraw(myAccount, password, money);
		deposit(recAccount, money);

	}
}
