public class Account {
	private String id;
	private String name;
	private Integer balance;
	private String grade;
	
	public Account() {}
	public Account(String id, String name, Integer balance, String grade) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.grade = grade;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void deposit(Integer money) {
		if(money>0) {
			balance += money;
		}
	}
	
	public void withdraw(Integer money) {
		if(balance>=money) {
			balance -= money;
		}
	}
	
	@Override
	public String toString() {
		return String.format("계좌번호:%s, 이름:%s , 잔액:%d , 등급:%s",id, name, balance, grade);
	}
	
}
