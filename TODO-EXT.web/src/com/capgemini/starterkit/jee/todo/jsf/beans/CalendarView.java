package com.capgemini.starterkit.jee.todo.jsf.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalendarView {

	private Date datetime;

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}
