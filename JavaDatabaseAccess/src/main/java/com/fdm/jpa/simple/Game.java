package com.fdm.jpa.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MY_GAMES")
public class Game {
	@Id
	@Column(name = "GAME_ID")
	private int id;
	@Column(name = "GAME_NAME", nullable=false, unique=true)
	private String name;

	// you need the default constructor and the getters and setters

	public Game() {
		super();
	}

	// we will also make constructor for ourselves to use (JPA does not care about
	// this constructor)
	// but for us making objects like this is easier

	public Game(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}
	
	

}
