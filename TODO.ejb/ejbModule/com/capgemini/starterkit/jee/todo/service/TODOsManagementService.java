package com.capgemini.starterkit.jee.todo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.starterkit.jee.todo.entities.TODO;

/**
 * Session Bean implementation class TODOsManagementService
 */
@Stateless
@LocalBean
@PermitAll
public class TODOsManagementService {

	@PersistenceContext(unitName = "TodoPU")
	EntityManager em;
	
	@Resource
	SessionContext sessionContext;

	/**
	 * Default constructor.
	 */
	public TODOsManagementService() {
	}

	public List<TODO> findTODOs() {
		return em.createQuery("Select td From TODO td", TODO.class)
				.getResultList();
	}

	@RolesAllowed("ADMIN")
	public void addTODO(TODO todo, Date date) {
		String username = sessionContext.getCallerPrincipal().getName();
		todo.setUser(username);
		todo.setDate(date);
		em.persist(todo);
	}

	public void markTODOAsDone(TODO todo) {
		TODO todoDb = em.find(TODO.class, todo.getId());
		
		if(sessionContext.isCallerInRole("ADMIN") || sessionContext.getCallerPrincipal().getName().equals(todoDb.getUser())) {
			todoDb.setDone(true);
		} else {
			throw new AuthorizationException("Not allowed!");
		}
	}
}
