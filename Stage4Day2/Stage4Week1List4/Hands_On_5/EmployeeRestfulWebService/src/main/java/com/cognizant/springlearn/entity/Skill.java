package com.cognizant.springlearn.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {

	@NotNull
	private int id;
	
	@NotNull
	@Size(min =1,max=30,message = "Skill should not null and less than 30 characters")
	private String name;

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(@NotNull int id,
			@NotNull @Size(min = 1, max = 30, message = "Skill should not null and less than 30 characters") String name) {
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
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
	
}
