package com.connect4.bean;

import org.springframework.data.annotation.Id;

/**
 * This class is designed to add the Player based details.
 * 
 * @author harikrushna 
 *
 */
public class Player {

	@Id
	String id;
	String name;

	public Player() {
		super();
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

}
