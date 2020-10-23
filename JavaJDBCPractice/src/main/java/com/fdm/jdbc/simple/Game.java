package com.fdm.jdbc.simple;

public class Game {

	private int id;
	private String name;

	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

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
