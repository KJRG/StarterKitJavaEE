package com.capgemini.starterkit.jee.todo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class TODO {

	@Id
	@Column(name = "ID")
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "DESC")
	String description;
	
	@Column(name = "IS_DONE")
	boolean done;
	
	@Column(name = "USER")
	String user;

	@Column(name = "DATETIME")
	Date date;
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
