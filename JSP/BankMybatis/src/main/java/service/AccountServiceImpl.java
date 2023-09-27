package service;

import java.util.List;

import bean.Account;
import dao.AccountDAO;
import dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDAOImpl();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDao.insertAccount(acc);
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDao.selectAccount(id);
	}

	@Override
	public void deposit(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if (acc == null)
			throw new Exception("계좌번호 오류");
		acc.deposit(money);
		accountDao.updateBalance(acc);
	}

	@Override
	public void withdraw(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if (acc == null)
			throw new Exception("계좌번호 오류");
		acc.withdraw(money);
		accountDao.updateBalance(acc);
	}

	public List<Account> allAccountInfo() throws Exception {
		return accountDao.selectAccountList();
	}
}