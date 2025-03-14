package com.bank.view;

import java.util.Scanner;

import com.bank.utility.Bank;
import com.bank.utility.client.Client;

public class HelloView implements View{

	private static final String BEAUTIFULDISPLAY = "-------------------------------------" + "\n" + "-------------------------------------" + "\n";
	
	private Bank bank;
	
	private Client client;
	
	public HelloView(Bank bank, Client client) {
		this.bank=bank;
		this.client=client;
	}
	
	@Override
	public View displayView(int mode) {
		StringBuilder printView = new StringBuilder();
		printView.append(BEAUTIFULDISPLAY);
		if (mode == 0) {
			printView.append("Welcome " + client.firstName() + " " + client.lastName() + " to the " + bank.getBankName() + " application !\n");
		}
		else 
			printView.append("Back at the main menu\n");
		
		//Display essential information on the user accounts
		
		
		printView.append("What do you want to do ?\n");
		printView.append("1- Make a deposit on one of your account\n");
		printView.append("2- Make a withdraw from one of your account\n");
		printView.append("3- Get a full statement of your accounts\n");
		printView.append("4- Exit the app\n");
		printView.append("Please tape on your keyboard the number of the action you want to do and touch enter after\n");
		System.out.println(printView.toString());
		Scanner scanner = new Scanner(System.in);
		
		return letClientChooseAction(scanner);
	}
	
	private View letClientChooseAction(Scanner scanner) {
		String clientChoice = scanner.nextLine();
		switch (clientChoice) {
		case "1" :
		case "2" : 
			System.out.println("Conducting you to the transaction view ...");
			return new TransactionView(bank,client).displayView(Integer.parseInt(clientChoice));
		case "3" : 
			System.out.println("Here is your accounts statements :");
			GenerateStats.DisplayAllStatement(bank, client);
			return displayView(1);
		case "4" :
			System.out.println("Goodbye !");
			return null;
		default :
			System.out.println("We didn't understand what action you choosed, please tape one more time your choice");	
			return letClientChooseAction(scanner);
		}	
		
	}
	
}
