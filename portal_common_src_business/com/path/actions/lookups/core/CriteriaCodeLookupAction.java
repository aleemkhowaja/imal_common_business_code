package com.path.actions.lookups.core;

import com.path.bo.core.criteria.CriteriaLkpBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.criteria.CriteriaSC;

public class CriteriaCodeLookupAction extends LookupBaseAction {

	private CriteriaLkpBO criteriaLkpBO;
	private final CriteriaSC criteriaSC = new CriteriaSC();

	public String constructCriteriaCodeLookup() {
		try {

			// Types the Grid by defining the column model and column names
			String[] name = { "CRITERIA_CODE", "CRITERIA_DESC", "QUERY_ID", "PROCEDURE_ID" };
			String[] colType = { "number", "text", "number", "number" };
			String[] titles = { getText("criteria_code_key"), getText("criteria_desc_key"), getText("query_id_key"),
					getText("procedure_id_key") };

			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("criteria_key"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/criteriaCodeLookup_fillCriteriaLookup");

			lookup(grid, criteriaSC, name, colType, titles);

			/*
			 * String[] name = { "CRITERIA_CODE", "CRITERIA_DESC", "QUERY_ID",
			 * "PROCEDURE_ID" }; String[] colType = { "number", "text", "number", "number"
			 * }; String[] titles = { getText("criteria_code_key"),
			 * getText("criteria_desc_key"), getText("query_id_key"),
			 * getText("procedure_id_key") }; LookupGrid grid = new LookupGrid();
			 * grid.setCaption(getText("criteria_key")); grid.setRowNum("5");
			 * grid.setUrl("/pathdesktop/criteriaCodeLookup_fillCriteriaLookup");
			 * criteria.setSearchCols(new String[] { "CRITERIA_CODE", "CRITERIA_DESC",
			 * "QUERY_ID", "PROCEDURE_ID" }); setSearchFilter(criteria); lookup(grid,
			 * criteria, name, colType, titles);
			 */
		} catch (Exception e) {
			log.error(e, "Error in constructProviderLookup of CriteriaCodeLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String fillCriteriaLookup() {
		try {

			setSearchFilter(criteriaSC);
			copyproperties(criteriaSC);

			SessionCO sessionCO = returnSessionObject();
			criteriaSC.setCompCode(sessionCO.getCompanyCode());
			criteriaSC.setBranchCode(sessionCO.getBranchCode());
			criteriaSC.setPreferredLanguage(sessionCO.getLanguage());

			if (get_pageRef() != null && get_pageRef().contains("CSC00")) {
				criteriaSC.setIsSegmentationScore("O"); // Set as O just in case the criteria usage in criteria screen,
														// else it is set as SC for Scoring
			} else if (get_pageRef() != null && get_pageRef().contains("CSG00")) {
				criteriaSC.setIsSegmentationScore("S");
			}
			// By Bilal For TP#750884 
			else if (get_pageRef() != null && get_pageRef().contains("BR00")) {
				criteriaSC.setIsSegmentationScore("B");
			}

			if (checkNbRec(criteriaSC)) {
				setRecords(criteriaLkpBO.returnCriteriaLookupCount(criteriaSC));
			}

			setGridModel(criteriaLkpBO.returnCriteriaLookup(criteriaSC));
		} catch (Exception e) {
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public Object getModel() {
		return criteriaSC;
	}

	public void setCriteriaLkpBO(CriteriaLkpBO criteriaLkpBO) {
		this.criteriaLkpBO = criteriaLkpBO;
	}
}
