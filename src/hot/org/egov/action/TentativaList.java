package org.egov.action;

import org.egov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tentativaList")
public class TentativaList extends EntityQuery<Tentativa> {

	private static final String EJBQL = "select tentativa from Tentativa tentativa";

	private static final String[] RESTRICTIONS = {
			"lower(tentativa.description) like lower(concat(#{tentativaList.tentativa.description},'%'))",
			"lower(tentativa.name) like lower(concat(#{tentativaList.tentativa.name},'%'))",};

	private Tentativa tentativa = new Tentativa();

	public TentativaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tentativa getTentativa() {
		return tentativa;
	}
}
