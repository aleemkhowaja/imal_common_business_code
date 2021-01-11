package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.vendorcif.VendorCIFBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.vendorcif.VendorCIFCO;

/**
 * @Auther:Pappady
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public class VendorCIFLookupAction extends LookupBaseAction
{
    private CifSC criteria = new CifSC();
    private VendorCIFBO vendorCIFBO;
    private List<VendorCIFCO> trsVendorVOList;

    public Object getModel()
    {
	return criteria;
    }

    /**
     * Construct Vendor CIF Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructVendorCIFLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "trsVendorVO.CIF", "SHORT_NAME_ENG", "SHORT_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Cif_key"), getText("Brief_Description_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Description_key"), getText("Long_Desc_Arab_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_CIF_key"));
	    grid.setRowNum("5");
	    // grid.setUrl("/pathdesktop/iislookups/VendorCifLookup_fillVendorCIFLookup");
	    grid.setUrl("/pathdesktop/VendorCifLookup_fillVendorCIFLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup CIF data filtered by the defined criteria
     * 
     * @return
     */
    public String fillVendorCIFLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    // criteria.setAppName(sessionCO.getCurrentAppName());
	    // criteria.setAppName("IIS");//TODO:HardCoded

	    if(getRecords() == 0)
	    {
		setRecords(vendorCIFBO.trsVendorCIFListCount(criteria));
	    }
	    trsVendorVOList = (List<VendorCIFCO>) vendorCIFBO.trsVendorCIFList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trsVendorVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String constructVendorIncentiveCIFLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "trsVendorVO.CIF", "SHORT_NAME_ENG", "SHORT_NAME_ARAB", "LONG_NAME_ENG", "LONG_NAME_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Cif_key"), getText("Brief_Description_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Description_key"), getText("Long_Desc_Arab_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_CIF_key"));
	    grid.setRowNum("5");
	    // grid.setUrl("/pathdesktop/iislookups/VendorCifLookup_fillVendorCIFLookup");
	    grid.setUrl("/pathdesktop/VendorCifLookup_fillVendorIncentiveCIFLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    public String fillVendorIncentiveCIFLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    // criteria.setAppName(sessionCO.getCurrentAppName());
	    // criteria.setAppName("IIS");//TODO:HardCoded

	    if(getRecords() == 0)
	    {
		setRecords(vendorCIFBO.trsVendorIncentiveCIFListCount(criteria));
	    }
	    trsVendorVOList = (List<VendorCIFCO>) vendorCIFBO.trsVendorIncentiveCIFList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trsVendorVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * Construct Purchase Party CIF Lookup based on the VO returned in the
     * resultMap.
     * 
     * @return
     */
    public String constructCIFACCLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "trsVendorVO.CIF", "SHORT_NAME_ENG", "SHORT_NAME_ARAB", "LONG_NAME_ENG",
		    "LONG_NAME_ARAB", "ID_NO", "ADDITIONAL_REFERENCE" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Cif_key"), getText("Brief_Description_key"), getText("Brief_Desc_Arab_key"),
		    getText("Long_Description_key"), getText("Long_Desc_Arab_key"), getText("Civil_ID_No_key"),
		    getText("Addnl_Ref_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query__For_CIF_key"));
	    grid.setRowNum("7");
	    grid.setUrl("/pathdesktop/VendorCifLookup_fillCIFACCLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the Purchase Party lookup
     * 
     * @return
     */
    public String fillCIFACCLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());

	    if(getRecords() == 0)
	    {
		setRecords(vendorCIFBO.trsCIFACCListCount(criteria));
	    }
	    trsVendorVOList = (List<VendorCIFCO>) vendorCIFBO.trsCIFACCList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(trsVendorVOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public CifSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(CifSC criteria)
    {
	this.criteria = criteria;
    }

    public void setVendorCIFBO(VendorCIFBO vendorCIFBO)
    {
	this.vendorCIFBO = vendorCIFBO;
    }

}
