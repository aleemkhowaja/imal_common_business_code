package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.admin.branches.BranchesBO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 *
 *       BranchesLookupAction.java used to load Branch Lookup
 */
public class BranchesDestinationLookupAction extends LookupBaseAction {
	private final BranchesSC branchesSC = new BranchesSC();
	private BranchesBO branchesBO;

	@Override
	public Object getModel()
	{
	return branchesSC;
	}


	/**
	 * Construct Branch Lookup
	 * @return
	 */
	public String constructLookup() {

		try 
		{
			// Design the Grid by defining the column model and column names
			String[] name = { "BRANCH_CODE", "BRIEF_DESC_ENG" };
			String[] colType = { "number", "text" };
			String[] titles = { getText("branchCode"), getText("briefDesc") };

			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("branches.branchList"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/BranchesDestinationLookup_fillLookupBranchDestination");
			lookup(grid, branchesSC, name, colType, titles);
		} 
		catch (Exception e) 
		{
			log.error(e, "Error in constructLookup of BranchesDestinationLookupAction");
			handleException(e, null, null);
		}

		return SUCCESS;

	}

	/**
	 * Fill the lookup branch data filtered by user.
	 * @return
	 */
	public String fillLookupBranchDestination() 
	{
		try {
		        List<BRANCHESVO> branchesVOList;
			setSearchFilter(branchesSC);
			// Get the data from BO
			copyproperties(branchesSC);
			
			SessionCO sessionCO = returnSessionObject();
			branchesSC.setCompCode(sessionCO.getCompanyCode());
			branchesSC.setBranchCode(sessionCO.getBranchCode());
			
			if (getRecords() == 0)
			{
			setRecords(branchesBO.getBranchesDestinationsLstCount(branchesSC));
			}
			branchesVOList = branchesBO.getBranchesDestinationsLst(branchesSC);
			// set the collection into gridModel attribute defined at JSP grid
			setGridModel(branchesVOList);

		} 
		catch (Exception e) 
		{
			log.error(e, "Error in fillLookupData of BranchesDestinationLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	public void setBranchesBO(BranchesBO branchesBO) {
		this.branchesBO = branchesBO;
	}

}
