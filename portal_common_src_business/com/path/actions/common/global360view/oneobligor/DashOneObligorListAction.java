package com.path.actions.common.global360view.oneobligor;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.global360view.oneobligor.DashOneObligorBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;
import com.path.vo.core.oneobligor.OneObligorCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * OneObligorListAction.java used to
 */
public class DashOneObligorListAction extends GridBaseAction
{
    private DashOneObligorBO dashOneObligorBO;
    private DashOneObligorSC dashOneObligorSC = new DashOneObligorSC();
    private DashOneObligorSC criteria = new DashOneObligorSC();
    private DashOneObligorCO dashOneObligorCO = new DashOneObligorCO();

    public Object getModel()
    {
	return dashOneObligorSC;
    }

//    public String loadOneObligorGrid()
//    {
//	try
//	{
//	    String[] searchCol = { "myCIfNOAlias", "SHORT_NAME_ENG" };
//	    HashMap<String, String> hmDate = new HashMap<String, String>();
//	    hmDate.put("BANK_EXP_DTE", "BANK_EXP_DTE");
//	    SessionCO sessionCO = returnSessionObject();
//	    criteria.setSearchCols(searchCol);
//	    criteria.setDateSearchCols(hmDate);
//	    copyproperties(criteria);
//	    if(checkNbRec(criteria))
//	    {
//		// setRecords(dashOneObligorBO.returnOneObligorListCount(criteria));
//	    }
//	    // setGridModel(dashOneObligorBO.returnOneObligorList(criteria));
//	}
//	catch(Exception e)
//	{
//	    log.error(e, "Error in loadOneObligorGrid of OneObligorListAction");
//	    handleException(e, null, null);
//	}
//	return SUCCESS;
//    }
/**
 * 
 * @return
 */
    public String loadOneObligorTrendsDetlsGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    /*sabine rename SINGLE_TRX_AMT_CV and TOTAL_TRX_AMT_CV to TOTAL_TRX_AMT and SINGLE_TRX_AMT TPID#850157 TAR#ZB190001  */
	    String[] searchCol = { "CTSTRX_TYPE", "CTSTRXTYPE_DESC", "PERIODICITY_TYPE", "PERIODICITY", "SINGLE_TRX_AMT",
		    "TOTAL_TRX_AMT","CURRENCY_CODE" };
	    dashOneObligorSC.setSearchCols(searchCol);

	    dashOneObligorSC.setCompCode(sessionCO.getCompanyCode());
	    dashOneObligorSC.setBranchCode(sessionCO.getBranchCode()); //added by sabine
	    
	    dashOneObligorSC.setLovTypeId(BigDecimal.valueOf(97));
	    dashOneObligorSC.setLanguage(sessionCO.getLanguage());
	    dashOneObligorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    
	    copyproperties(dashOneObligorSC);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(dashOneObligorSC))
	    {
		setRecords(dashOneObligorBO.oneObligorTrendsListCount(dashOneObligorSC));
	    }
	    /**
	     * return the collection of records
	     */
	    List<OneObligorCO> oneObligorTrendsList = dashOneObligorBO.oneObligorTrendsList(dashOneObligorSC);
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(oneObligorTrendsList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadOneObligorGrid of OneObligorListAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

public DashOneObligorSC getDashOneObligorSC()
{
    return dashOneObligorSC;
}

public void setDashOneObligorSC(DashOneObligorSC dashOneObligorSC)
{
    this.dashOneObligorSC = dashOneObligorSC;
}

public DashOneObligorSC getCriteria()
{
    return criteria;
}

public void setCriteria(DashOneObligorSC criteria)
{
    this.criteria = criteria;
}

public DashOneObligorCO getDashOneObligorCO()
{
    return dashOneObligorCO;
}

public void setDashOneObligorCO(DashOneObligorCO dashOneObligorCO)
{
    this.dashOneObligorCO = dashOneObligorCO;
}

public void setDashOneObligorBO(DashOneObligorBO dashOneObligorBO)
{
    this.dashOneObligorBO = dashOneObligorBO;
}

 
}
