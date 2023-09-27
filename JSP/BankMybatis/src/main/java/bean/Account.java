package bean;

public class Account {
	private String id;
	private String name;
	private int balance;
	private String type;
	private String grade;

	public Account() {}

	public Account(String id, String name, int balance, String type, String grade) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type = type;
		this.grade = grade;
	}

	public void deposit(Integer money) {
		if (money > 0) {
			balance += money;
		}
	}

	public void withdraw(Integer money) throws Exception {
		if (balance >= money) {
			balance -= money;
		} else {
			throw new Exception("잔액이 부족합니다");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
