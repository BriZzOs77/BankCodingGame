package com.bank.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.bank.utility.Bank;
import com.bank.utility.Transaction;
import com.bank.utility.client.Account;
import com.bank.utility.client.Client;

public class TransactionView implements View {

	private static final String BEAUTIFULDISPLAY = "-------------------------------------" + "\n" + "-------------------------------------" + "\n";
	
	private Bank bank;
	private Client client;
	
	public TransactionView(Bank bank, Client client) {
		this.bank=bank;
		this.client=client;
	}
	
	@Override
	public View displayView(int mode) {
		
		List<Account> accounts = bank.getClientAccounts(client);
		
		System.out.println(BEAUTIFULDISPLAY);
		
		switch (mode) {
		case 1:
			return depositMoney(accounts);
		case 2:
			return withdrawFromAccount(accounts);
		default :
			throw new IllegalArgumentException("Bad mode number");	
		}
	}
	
	private View depositMoney(List<Account> accounts) {
		System.out.println("On which account you want to deposit money ?");
		System.out.println("Accounts available :");
		accounts.forEach(a -> System.out.println(a.getIdAndNameOfAccount()));
		System.out.println();
		System.out.println("Please type here the number of the account you want to select");
		boolean isAccountId = false;
		Account accountToModify = null;
		Scanner scanner = new Scanner(System.in);
		while (!isAccountId) {
			int scan = scanner.nextInt();
			for (Account a : accounts) {
				if (a.getId() == scan) {
					accountToModify = a;
					isAccountId = true;
				}
			}
			if (!isAccountId)
				System.out.println("Bad ID, please type an existing account ID");
		}
		
		System.out.println(BEAUTIFULDISPLAY);
		System.out.println("Which amount of money you want to deposit ?");
		int amount = scanner.nextInt();
		if (amount < 0) {
			System.out.println("Negative amount is not possible ; returning to the main menu...");
		}
		else {
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				bank.addNewTransaction(new Transaction(client, accountToModify, dateFormat.parse(LocalDate.now().toString()), amount, accountToModify.getCurrency()));
				accountToModify.setBalance(accountToModify.getBalance() + amount);
			} catch (ParseException e) {
				System.out.println("Error during the transaction, returning back to the main menu...");
			}
			
		}
		
		scanner.close();
		return new HelloView(bank, client);
	}

	
	private View withdrawFromAccount(List<Account> accounts) {
		System.out.println("On which account you want to withdraw money ?");
		System.out.println("Accounts available :");
		accounts.forEach(a -> System.out.println(a.getIdAndNameOfAccount()));
		System.out.println();
		System.out.println("Please type here the number of the account you want to select");
		boolean isAccountId = false;
		Account accountToModify = null;
		Scanner scanner = new Scanner(System.in);
		while (!isAccountId) {
			int scan = scanner.nextInt();
			for (Account a : accounts) {
				if (a.getId() == scan) {
					accountToModify = a;
					isAccountId = true;
				}
			}
			if (!isAccountId)
				System.out.println("Bad ID, please type an existing account ID");
		}
		
		System.out.println(BEAUTIFULDISPLAY);
		System.out.println("Which amount of money you want to deposit ?");
		int amount = scanner.nextInt();
		if (amount < 0) {
			System.out.println("Negative amount is not possible ; returning to the main menu...");
		}
		else if (amount > accountToModify.getBalance()) {
			System.out.println("The amount selected exceed the money you have on this account.");
			System.out.println("Returning to the main menu ...");
		}
		else {
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				bank.addNewTransaction(new Transaction(client, accountToModify, dateFormat.parse(LocalDate.now().toString()), -amount, accountToModify.getCurrency()));
				accountToModify.setBalance(accountToModify.getBalance() - amount);
			} catch (ParseException e) {
				System.out.println("Error during the transaction, returning back to the main menu...");
			}
			
		}
		
		scanner.close();
		return new HelloView(bank, client);
	}
}
