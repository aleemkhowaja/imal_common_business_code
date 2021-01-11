package com.path.actions.lookups.core;

import com.path.bo.core.fmsfundlimit.FmsFundLimitBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.fmsfundlimit.FmsFundLimitSC;

public class FmsFundLimitLookupAction  extends LookupBaseAction
{
    private FmsFundLimitSC criteria = new FmsFundLimitSC();
    private FmsFundLimitBO fmsFundLimitBO;

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
	    String[] name = { "fmsFundLimitVO.FUND_CODE", "cifVO.SHORT_NAME_ENG", "cifVO.LONG_NAME_ENG" , "fmsFundLimitVO.STATUS"};
	    String[] colType = { "number", "text", "text","text" };
	    String[] titles = { getText("Fund_Code_key"), getText("Short_name_eng_key"), getText("Long_Name_eng_key"), getText("Status_key") };

//	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Fund_Limit_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/FmsFundLimitLookup_fillFundLimitLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of FmsFundLimitLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String fillFundLimitLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            if(checkNbRec(criteria))
            {
                setRecords(fmsFundLimitBO.fmsFundLimitListCount(criteria));
            }
            
            setGridModel(fmsFundLimitBO.fmsFundLimitList(criteria));

        }
        catch(Exception e)
        {
            handleException(e, null, null);
        }
        return SUCCESS;
    }
    
    public FmsFundLimitBO getFmsFundLimitBO()
    {
        return fmsFundLimitBO;
    }

    public void setFmsFundLimitBO(FmsFundLimitBO fmsFundLimitBO)
    {
        this.fmsFundLimitBO = fmsFundLimitBO;
    }

    public FmsFundLimitSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(FmsFundLimitSC criteria)
    {
        this.criteria = criteria;
    }
}
