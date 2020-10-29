package com.fdm.inheritence.singleTable;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "GUEST")
public class Guest extends User {

	private LocalDateTime loginTime;

	public Guest() {
		super();
	}

	public Guest(String username) {
		super(username);
		this.loginTime = LocalDateTime.now();
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

}
