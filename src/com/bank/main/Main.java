package com.bank.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

import com.bank.utility.Bank;
import com.bank.utility.Transaction;
import com.bank.utility.client.Account;
import com.bank.utility.client.Client;
import com.bank.view.HelloView;
import com.bank.view.View;

public class Main {

	/*
	 * arg[0] should be the clientID
	 * arg[1] should be the email of the client who want to use the program
	 */
	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String bankName = "YeepeeBank";
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(new Client(0, "Jean", "Jacques", "Trat", dateFormat.parse("04/03/1984"), "jean.trat@gmail.com"));
		clients.add(new Client(1, "Gérard", "", "Menvusa", dateFormat.parse("23/07/1972"), "gmenv@yahoo.com"));
		clients.add(new Client(2, "Pascal", "", "Hecto", dateFormat.parse("11/10/1956"), "pascal.hecto@gmail.com"));
		clients.add(new Client(3, "Fabrice", "", "Trat", dateFormat.parse("18/05/1996"), "fab.trat@gmail.com"));
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(0, "Classic Account", clients.get(0), 3500, "€"));
		accounts.add(new Account(1, "Savings Account", clients.get(0), 8400, "€"));
		accounts.add(new Account(2, "Savings Account", clients.get(0), 5200, "€"));
		accounts.add(new Account(3, "Classic+ Account", clients.get(1), 10342, "$"));
		accounts.add(new Account(4, "Savings Account", clients.get(1), 20000, "$"));
		accounts.add(new Account(5, "Classic Account", clients.get(2), 5, "€"));
		accounts.add(new Account(6, "Enterprise Account", clients.get(3), 347874, "€"));
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		Bank bank = new Bank(bankName, clients, accounts, transactions);
		System.out.println(args[0] + " " + args[1]);
		Optional<Client> client = bank.getClientFromIdAndEmail(Integer.parseInt(args[0]), args[1]);
		
		if (client.isPresent()) {
			View view = new HelloView(bank,client.get());
			view.displayView(0);
		}
		else {
			System.out.println("User does not exist, bye !");
		}
	}
}
