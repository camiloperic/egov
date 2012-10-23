package org.egov.action.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.egov.model.Citizen;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("citizenDAO")
public class CitizenDAO {
	
	@In
	private EntityManager entityManager;
	
	@Create
	public void create() {
	}

	public boolean doLogin(String te, String passwd) {
		
		List<Citizen> usuario = 
			entityManager
			.createQuery(
				"SELECT c " + 
				"FROM Citizen c " + 
				"WHERE te = :te " + 
					"AND passwd = :passwd")
			.setParameter("te", te)
			.setParameter("passwd", passwd)
			.getResultList();
		
		if (usuario.size() == 1) return true;
		else return false;
	}

}
