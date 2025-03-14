package com.bank.utility.client;

public class Account {
	private final int id;
	private final String name;
	private Client client;
	private int balance;
	private String currency;
	public Account(int id, String name, Client client, int balance, String currency) {
		super();
		this.id = id;
		this.name = name;
		this.client = client;
		this.balance = balance;
		this.currency = currency;
	}
	
	
	
	public final String getIdAndNameOfAccount() {
		StringBuilder res = new StringBuilder();
		res.append("Account id : " + id + "\n");
		res.append("Account owner : " + client.firstName() + client.lastName() + "\n");
		
		
		return res.toString();
	}
	
	@Override
	public final String toString() {
		StringBuilder res = new StringBuilder();
		res.append(getIdAndNameOfAccount());
		res.append("Current balance : " + balance + " " + currency);		
		
		return res.toString();
	}
		
	
	public void setBalance(int balance) {
		this.balance = balance;
	}



	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Client getClient() {
		return client;
	}



	public int getBalance() {
		return balance;
	}



	public String getCurrency() {
		return currency;
	}
	
	
}
