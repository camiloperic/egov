package org.egov.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
