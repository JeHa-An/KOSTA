package service;

import java.util.List;

import bean.Account;

public interface AccountService {
	void makeAccount(Account acc) throws Exception;

	Account accountInfo(String id) throws Exception;

	void deposit(String id, Integer money) throws Exception;

	void withdraw(String id, Integer money) throws Exception;

	List<Account> allAccountInfo() throws Exception;
}