package dao;

import java.util.List;

import bean.Account;

public interface AccountDAO {
	void insertAccount(Account acc) throws Exception;

	Account selectAccount(String id) throws Exception;

	void updateBalance(Account acc) throws Exception;

	List<Account> selectAccountList() throws Exception;
}