package org.egov.action;

import org.egov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tentativaHome")
public class TentativaHome extends EntityHome<Tentativa> {

	public void setTentativaId(Integer id) {
		setId(id);
	}

	public Integer getTentativaId() {
		return (Integer) getId();
	}

	@Override
	protected Tentativa createInstance() {
		Tentativa tentativa = new Tentativa();
		return tentativa;
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

	public Tentativa getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
