package test;

import java.sql.SQLException;

import model.AccountDAO;
import model.AccountLoginException;
import model.AccountNotFoundException;
import model.InsufficientBalanceException;
import model.NoMoneyException;
//step5 계좌이체 테스트 
/**
 * 계좌 이체 테스트 클래스
 * @author KOSTA
 *
 */
public class TestUnit5 {
	/**
	 * 계좌 이체 기능 테스트 및 트랜잭션 처리 테스트
	 * @param args
	 */
	public static void main(String[] args) {		
			try {
				AccountDAO dao = new AccountDAO();
				dao.transfer("1","4567","2",100);
				System.out.println("이체 완료");			
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			} catch (NoMoneyException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (AccountNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			} catch (AccountLoginException e) {
				System.out.println(e.getMessage());
			}				
		
	}
}