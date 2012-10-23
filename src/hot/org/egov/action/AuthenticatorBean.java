package org.egov.action;

import javax.ejb.Stateless;

import org.egov.action.dao.CitizenDAO;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator {
	
	@Logger
	private Log log;

	@In
	Identity identity;
	
	@In
	Credentials credentials;
	
	@In(create = true)
	private CitizenDAO citizenDAO;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		return citizenDAO.doLogin(credentials.getUsername(),credentials.getPassword());
	}

}
