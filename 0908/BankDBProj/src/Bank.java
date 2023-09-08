import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import dao.AccountDAO;
import exc.BankError;
import exc.BankException;

public class Bank {
	Scanner sc = new Scanner(System.in);

	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(!(sel>=0 && sel<=5)) {
			throw new BankException("메뉴오류", BankError.MENU);
		}
		return sel;
	}
	
	void selAccMenu() throws BankException {
		System.out.println("[계좌개설]");
		System.out.println("1.일반계좌");
		System.out.println("2.특수계좌");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1:makeAccount(); break;
		case 2:makeSpecialAccount(); break;
		default : 
			throw new BankException("메뉴오류", BankError.MENU);
		}
	}
	
	void makeAccount() throws BankException {
		Connection conn = AccountDAO.getConnection();
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = AccountDAO.selectAccount(conn, id);
		if(acc!=null) {
			AccountDAO.close(conn);
			throw new BankException("계좌오류", BankError.EXISTID);
		}
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
		AccountDAO.insertAccount(conn, new Account(id,name,money));
		AccountDAO.close(conn);
	}
	
	void makeSpecialAccount() throws BankException {
		Connection conn = AccountDAO.getConnection();
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = AccountDAO.selectAccount(conn, id);
		if(acc!=null) {
			AccountDAO.close(conn);
			throw new BankException("계좌오류", BankError.EXISTID);
		}
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V,Gold-G,Silver-S,Normal-N):");
		String grade = sc.nextLine();
		//추가
		AccountDAO.insertAccount(conn, new SpecialAccount(id,name,money,grade));
		AccountDAO.close(conn);
	}
	
	void deposit() throws BankException {
		Connection conn = AccountDAO.getConnection();
		System.out.println("[입금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = AccountDAO.selectAccount(conn, id);
		if(acc==null) {
			AccountDAO.close(conn);
			throw new BankException("계좌오류", BankError.NOID);
		}
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
		acc.deposit(money);
		AccountDAO.updateAccount(conn, acc);
		AccountDAO.close(conn);
	}
	
	void withdraw() throws BankException {
		Connection conn = AccountDAO.getConnection();
		System.out.println("[출금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = AccountDAO.selectAccount(conn, id);
		if(acc==null) {
			AccountDAO.close(conn);
			throw new BankException("계좌오류", BankError.NOID);
		}
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		acc.withdraw(money);
		AccountDAO.updateAccount(conn, acc);
		
		AccountDAO.close(conn);
	}
	
	void accountInfo() throws BankException {
		Connection conn = AccountDAO.getConnection();
		System.out.println("[계좌조회]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = AccountDAO.selectAccount(conn, id);
		if(acc==null) {
			AccountDAO.close(conn);
			throw new BankException("계좌오류", BankError.NOID);
		}
		System.out.println(acc);
		AccountDAO.close(conn);
	}
	
	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		Connection conn = AccountDAO.getConnection();
		List<Account> accs = AccountDAO.selectAccountList(conn);
		for(Account acc : accs) {
			System.out.println(acc);
		}
		AccountDAO.close(conn);
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		while(true) {
			try {
				sel = bank.menu();
				if(sel==0)  {
					break;
				}
				switch(sel) {
				case 1: bank.selAccMenu(); break;
				case 2: bank.deposit(); break;
				case 3: bank.withdraw(); break;
				case 4: bank.accountInfo(); break;
				case 5: bank.allAccountInfo(); break;
				}
			} catch(NumberFormatException e) {
				System.out.println("입력형식이 맞지 않습니다. 다시 선택하세요.");
			} catch(BankException e) {
				//e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}