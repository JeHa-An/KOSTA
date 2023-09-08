package acc;

import java.io.Serializable;

import exc.BankException;

public class SpecialAccount extends Account implements Serializable {
	String grade = "Normal";
	double interest = 0.01;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		switch(grade.charAt(0)) {
		case 'V': 
		case 'v': this.grade="VIP"; interest=0.04; break;
		case 'G': 
		case 'g': this.grade="Gold"; interest=0.03; break;
		case 'S': 
		case 's': this.grade="Silver"; interest=0.02; break;
		case 'N': 
		case 'n': this.grade="Normal"; interest=0.01; break;
		}
	}
	
	public SpecialAccount() {}
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id,name,money);
		setGrade(grade);
	}
	
	@Override
	public void deposit(int money) throws BankException {
		super.deposit((int)(Math.round(money+money*interest)));
	}
	
	@Override
	public String toString() {
		return super.toString()+",등급:"+grade;
	}
}
