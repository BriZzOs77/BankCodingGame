package com.bank.utility;

import java.util.Date;

import com.bank.utility.client.Account;
import com.bank.utility.client.Client;

public record Transaction(Client client, Account account, Date date, int amount, String currency) {
	@Override
	public final String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Date of the transaction : " + date.toString());
		res.append("Client : " + account.getIdAndNameOfAccount());
		res.append("Amount send / withdraw : " + amount + " " + currency);
		
		return res.toString();
	}
}
