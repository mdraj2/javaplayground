package com.fdm.inheritence.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User {

	private String password;

	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super(username);
		this.password = password;
	}

	public String getPasword() {
		return password;
	}

	public void setPasword(String password) {
		this.password = password;
	}

}
