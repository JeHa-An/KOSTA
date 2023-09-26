package service;

import dao.AccountDAO;
import dto.Account;

public class AccountService {
	private AccountDAO dao = new AccountDAO();
	
	public void makeAccount(Account acc) throws Exception {
		Account sacc = dao.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("동일한 계좌번호가 등록되어 있습니다.");
		dao.insertAccount(acc);
	}
}
