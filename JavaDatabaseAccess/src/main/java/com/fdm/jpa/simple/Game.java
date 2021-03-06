package com.fdm.jpa.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "findGameByName", query = "SELECT g FROM Game g WHERE g.name LIKE :gameName") })
@Entity
@Table(name = "MY_GAMES")
public class Game {
	//we are now generating the id so we do not need to pass it in to the constructor
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GAME_ID")
	private int id;
	@Column(name = "GAME_NAME", nullable = false, unique = true)
	private String name;

	// you need the default constructor and the getters and setters

	public Game() {
		super();
	}

	// we will also make constructor for ourselves to use (JPA does not care about
	// this constructor)
	// but for us making objects like this is easier

	public Game(String name) {
		super();
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
