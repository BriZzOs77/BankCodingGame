package com.bank.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bank.utility.client.Account;
import com.bank.utility.client.Client;

public class Bank {
	private String bankName;
	private List<Client> clients;
	private List<Account> accounts;
	private List<Transaction> transactions;
	
	
	
	public Bank(String bankName, List<Client> clients, List<Account> accounts, List<Transaction> transactions) {
		this.bankName = bankName;
		this.clients = clients;
		this.accounts = accounts;
		this.transactions = transactions;
	}

	public String getBankName() {
		return bankName;
	}
	
	public Optional<Client> getClientFromIdAndEmail(int id, String email) {
		for (Client c : clients) {
			if (c.id() == id && c.email().equals(email))
				return Optional.of(c);
		}
		return Optional.empty();
	}
	
	public List<Account> getClientAccounts(Client client){
		ArrayList<Account> res = new ArrayList<Account>();
		accounts.forEach(a -> {
			if (a.getClient().equals(client))
				res.add(a);
		});
		return res;
	}
	
	public List<Transaction> getTransactionsOfAccount(Account account){
		ArrayList<Transaction> res = new ArrayList<Transaction>();
		for (Transaction transaction : transactions) {
			if (transaction.account().equals(account))
				res.add(transaction);
		}
		return res;
	}
	
	public void addNewTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
}
