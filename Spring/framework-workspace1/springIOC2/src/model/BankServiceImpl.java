package model;
/**
 * Controller -- BankService -- DAO
 * @author KOSTA
 *
 */
public class BankServiceImpl implements BankService {
	private BankDAO bankDAO;
	//Spring Container로 부터 DAO 객체를 주입받도록 한다.
	//(DI :Dependcy Injection)
	public BankServiceImpl(BankDAO bankDAO) {
		super();
		this.bankDAO = bankDAO;
		System.out.println("Spring Container로부터 주입받는다. "+bankDAO);
	}

	@Override
	public void deposit(int money) {
		bankDAO.deposit(money);
	}

}
