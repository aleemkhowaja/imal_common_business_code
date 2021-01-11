package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.chargesfeespolicy.ChargesFeesPolicyBO;
import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;

public class ChargesFeesPolicyLookupAction extends LookupBaseAction
{
    private ChargesFeesPolicySC criteria = new ChargesFeesPolicySC();
    private ChargesFeesPolicyBO chargesFeesPolicyBO;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"CODE",
                             "BRIEF_NAME_ENG",
                             "BRIEF_NAME_ARAB",
                             "LONG_NAME_ENG",
                             "LONG_NAME_ARAB",
                             "PERIODICITY",
                             "PERIODICITY_TYPE"
                            };
	    String[] colType = { "number", "text", "text", "text", "text","text","text"};
	    String[] titles = { getText("Code_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
	    		getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key"), "", getText("Periodicity__key")};

	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] {"CODE",
                                    "BRIEF_NAME_ENG",
                                    "LONG_NAME_ENG",
                                    "PERIODICITY",
                                    "PERIODICITY_TYPE" };
		colType = new String[] { "number", "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"), getText("Brief_Desc_Eng_key"),
	    		getText("Long_Desc_Eng_key"), "", getText("Periodicity__key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Lookup/Query_Charges_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/ChargesFeesPolicyLookup_fillChargesFeesPolicyLookup");
	    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	    if(name.length == 7)
	    {
		lsGridColumn.get(5).setHidden(true); // Periodicity is Hidden
	    }
	    else
	    {
		lsGridColumn.get(3).setHidden(true); // Periodicity is Hidden
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of ChargesFeesPolicyLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Charges Fees Policy data filtered by the defined criteria
     *
     * @return
     */
    public String fillChargesFeesPolicyLookup()
    {
	try
	{
	    List<CTS_CHARGES_FEES_POLICYVO> chargesFeesPolicyVOList;
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setLangCode(returnSessionObject().getLanguage());
	    criteria.setLovType(ConstantsCommon.PERIODICITY_LOV_TYPE);// For Periodicity

	    if(checkNbRec(criteria))
	    {
		setRecords(chargesFeesPolicyBO.chargesFeesPolicyListCount(criteria));
	    }
	    chargesFeesPolicyVOList = chargesFeesPolicyBO.chargesFeesPolicyList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(chargesFeesPolicyVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillChargesFeesPolicyLookup of ChargesFeesPolicyLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	public ChargesFeesPolicySC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(ChargesFeesPolicySC criteria)
	{
		this.criteria = criteria;
	}

	public void setChargesFeesPolicyBO(ChargesFeesPolicyBO chargesFeesPolicyBO)
	{
		this.chargesFeesPolicyBO = chargesFeesPolicyBO;
	}
}
