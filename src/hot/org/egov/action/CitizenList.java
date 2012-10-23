package org.egov.action;

import org.egov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("citizenList")
public class CitizenList extends EntityQuery<Citizen> {

	private static final String EJBQL = "select citizen from Citizen citizen";

	private static final String[] RESTRICTIONS = {
			"lower(citizen.email) like lower(concat(#{citizenList.citizen.email},'%'))",
			"lower(citizen.name) like lower(concat(#{citizenList.citizen.name},'%'))",
			"lower(citizen.passwd) like lower(concat(#{citizenList.citizen.passwd},'%'))",
			"lower(citizen.te) like lower(concat(#{citizenList.citizen.te},'%'))",};

	private Citizen citizen = new Citizen();

	public CitizenList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Citizen getCitizen() {
		return citizen;
	}
}
