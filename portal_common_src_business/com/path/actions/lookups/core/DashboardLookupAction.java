/**
 * @Auther:MarwanMaddah
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.investments.DashInvestmentsBO;
import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * @author MarwanMaddah
 *
 */
public class DashboardLookupAction extends LookupBaseAction
{
   
    private DashboardSC criteria = new DashboardSC();
    private DashInvestmentsBO dashInvestmentsBO;
    
    public String constructSecuritiesLookup()
    {
  	try
  	{	    
  	    // Design the Grid by defining the column model and column names
  	    String[] name = {"SECURITY_CODE1",
  		             "SECURITY_CODE2",
                             "SECURITY_NAME"};
  	    String[] colType = { "number", "number", "text"};
  	    String[] titles = { getText("Security_Code_key"), getText("Security_Code2_key"), 
  		    		getText("Short_Name_key")};

  	    // Defining the Grid
  	    LookupGrid grid = new LookupGrid();
  	    grid.setCaption(getText("cifList_key"));
  	    grid.setRowNum("5");
  	    grid.setUrl("/pathdesktop/DashboardLookup_fillSecuritiesLookup");
  	  lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

  	return SUCCESS;

    }
    
    public String fillSecuritiesLookup()
    {
  	try
  	{
  	    setSearchFilter(criteria);
  	    copyproperties(criteria);
  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setCompCode(sessionCO.getCompanyCode());
  	    criteria.setUserId(sessionCO.getUserName());
  	    criteria.setRunningDate(sessionCO.getRunningDateRET());
  	    
  	    List<PMSPORTFOLIO_POSITION_TEMPVO> pmsPortfolioTmpVO;
  	   
  	    if(getRecords() == 0)
  	    {
  		setRecords(dashInvestmentsBO.returnSecuritiesLookupListCount(criteria));
  	    }
  	    pmsPortfolioTmpVO = dashInvestmentsBO.returnSecuritiesLookupList(criteria);
  	    /**
  	     * translate All_Security_Key
  	     */
  	    for(PMSPORTFOLIO_POSITION_TEMPVO theVO:pmsPortfolioTmpVO)
  	    {
  		if(BigDecimal.ZERO.equals(theVO.getSECURITY_CODE1()) 
  		   && 
  		   BigDecimal.ZERO.equals(theVO.getSECURITY_CODE2())
  		   &&
  		   ConstantsCommon.ALL_SECURITIES_KEY.equals(StringUtil.nullToEmpty(theVO.getSECURITY_NAME()))
  		  )
  		{
  		    theVO.setSECURITY_NAME(getText(ConstantsCommon.ALL_SECURITIES_KEY));
  		}
  	    }
  	    // set the collection into gridModel attribute defined at JSP grid
  	    setGridModel(pmsPortfolioTmpVO);

  	}
  	catch(Exception e)
  	{
  	    log.error(e, "Error in fillLookupData of DashboardLookupAction");
  	    handleException(e, null, null);
  	}
  	return SUCCESS;
    }

  

    public DashboardSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
        this.criteria = criteria;
    }

    public void setDashInvestmentsBO(DashInvestmentsBO dashInvestmentsBO)
    {
        this.dashInvestmentsBO = dashInvestmentsBO;
    }
    
}
