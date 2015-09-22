package com.capgemini.starterkit.jee.todo.jsf.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.capgemini.starterkit.jee.todo.entities.TODO;
import com.capgemini.starterkit.jee.todo.service.TODOsManagementService;

@SessionScoped
@ManagedBean(name = "todoBean")
public class TODOBean {

	@EJB
	TODOsManagementService todosService;

	private TODO todo;
	private Date date;
	private Date currentDate = new Date();

	public void listener(javax.faces.event.ComponentSystemEvent event)
			throws javax.faces.event.AbortProcessingException {
		/*
		 * Refresh current date.
		 */
		currentDate = new Date();
	}

	public Date getDate() {
		if (date == null) {
			date = new Date();
		}
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isUrgent(TODO todo) {
		if (todo == null) {
			return false;
		}
		if (todo.getDate() == null) {
			return false;
		}

		return (!todo.isDone()) && (todo.getDate().compareTo(currentDate) <= 0);
	}

	public TODO getTodo() {
		if (todo == null) {
			todo = new TODO();
		}
		return todo;
	}

	public List<TODO> getTodos() {
		return todosService.findTODOs();
	}

	public String addNewTodo() {
		todosService.addTODO(todo, date);
		todo = null;

		return "list";
	}

	public void setTodoAsDone(TODO todo) {
		todosService.markTODOAsDone(todo);
	}
}
