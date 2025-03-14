package com.bank.view;

import java.time.LocalDate;
import java.util.List;

import com.bank.utility.Bank;
import com.bank.utility.Transaction;
import com.bank.utility.client.Account;
import com.bank.utility.client.Client;

public class GenerateStats {
	
	public static void DisplayAccountsResume(Bank bank, Client client) {
		List<Account> clientAccounts = bank.getClientAccounts(client);
		System.out.println("Accounts resume - " + LocalDate.now());
		for (Account account : clientAccounts) {
			System.out.println(account.toString());
		}
		
	}
	
	public static void DisplayAllStatement(Bank bank, Client client) {
		List<Account> clientAccounts = bank.getClientAccounts(client);
		System.out.println("Accounts statement - " + LocalDate.now());
		for (Account account : clientAccounts) {
			System.out.println("Account name : " + account.getName());
			System.out.println("Balance remaining : " + account.getBalance());
			System.out.println("Transactions on account :");
			List<Transaction> accountTransactions = bank.getTransactionsOfAccount(account);
			accountTransactions.forEach(t -> System.out.println(t));
			
			if (accountTransactions.size() == 0)
				System.out.println("No transaction has been done with this account");
			System.out.println();
		}
	}
}
