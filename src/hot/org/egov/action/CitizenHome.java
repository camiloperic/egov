package org.egov.action;

import org.egov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("citizenHome")
public class CitizenHome extends EntityHome<Citizen> {

	public void setCitizenId(Integer id) {
		setId(id);
	}

	public Integer getCitizenId() {
		return (Integer) getId();
	}

	@Override
	protected Citizen createInstance() {
		Citizen citizen = new Citizen();
		return citizen;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Citizen getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
