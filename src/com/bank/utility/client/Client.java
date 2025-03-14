package com.bank.utility.client;

import java.util.Date;

public record Client(int id, String firstName, String middleName, String lastName, Date birthDate, String email) {
	
	@Override
	public final boolean equals(Object obj) {
		if (!(obj instanceof Client))
			return false;
		Client c = (Client) obj;
		System.out.println(this.id == c.id);
		System.out.println(this.firstName.equals(c.firstName));
		System.out.println(this.middleName.equals(c.middleName));
		System.out.println(this.lastName.equals(c.lastName));
		System.out.println(this.birthDate.equals(c.birthDate));
		System.out.println(this.email.equals(c.email));
		if (this.id == c.id && this.firstName.equals(c.firstName) && this.middleName.equals(c.middleName) && this.lastName.equals(c.lastName) && this.birthDate.equals(c.birthDate) && this.email.equals(c.email))
			return true;
		
		return false;
	}
}