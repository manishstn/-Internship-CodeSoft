package com.atminterface.bankaccount;

public class BankAccount {

	private Integer number;
	private String name;
	private Double acBal;
	public BankAccount(Integer number, String name, Double acBal) {
		super();
		this.number = number;
		this.name = name;
		this.acBal = acBal;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAcBal() {
		return acBal;
	}
	public void setAcBal(Double acBal) {
		this.acBal = acBal;
	}
	
	public Double withdrawAmount(Double amt) {
		this.acBal= this.acBal-amt;
		return this.acBal;
	}
	
	public Double depositeAmount(Double amt) {
		this.acBal = this.acBal + amt;
		return this.acBal;
	}
	@Override
	public String toString() {
		return "BankAccount [number=" + number + ", name=" + name + ", acBal=" + acBal + "]";
	}
	
	
}
