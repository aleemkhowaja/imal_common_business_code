/**
 * 
 */
package com.path.actions.common.global360view.others;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.others.DashOthersBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashOthersCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: elieachkar
 * 
 *          DashVoidedChequesListAction.java used to
 */
public class DashLinksListAction extends GridBaseAction
{
    private DashOthersBO dashOthersBO;
    private DashboardSC criteria = new DashboardSC();
    private int isCifCif;
    private int isAccAcc;
    private int isAccCif;
    private int isCifAcc; 

    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * 
     * @return String
     * 
     */
    public String loadLinksPage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setProgRef(get_pageRef());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    DashOthersCO dashOthersCO = dashOthersBO.returnLinksExistanceQueryList(criteria);
	    isCifCif = dashOthersCO.getIsCifCif();
	    isAccAcc = dashOthersCO.getIsAccAcc();
	    isCifAcc = dashOthersCO.getIsCifAcc();
	    isAccCif = dashOthersCO.getIsAccCif();
	}
	catch(Exception e)
	{
	    log.error(e, "Error in Links List Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * 
     * @author elieachkar
     * @date May 29, 2013
     * @return
     * 
     */
    public String linksListCifCifGrid()
    {
	String[] searchCol = { "CODE", "SERIAL", "BRIEF_NAME", "FROM_CIF_NO", "FROM_CIF_NAME", 
		"TO_CIF_NO", "TO_CIF_NAME", "STATUS" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.STATUS_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    criteria.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    criteria.setUserId(sessionCO.getUserName());
            criteria.setAppName(sessionCO.getCurrentAppName());
            criteria.setProgRef(get_pageRef());
            //917789 - DBU191081  
            criteria.setLoginBranchCode(sessionCO.getBranchCode());

           
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.linksCifCifListCount(criteria));
	    }
	    setGridModel(dashOthersBO.linksCifCifList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Links List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String linksListAccAccGrid()
    {
	String[] searchCol = { "CODE", "SERIAL", "BRIEF_NAME", "FROM_BRANCH", "FROM_CURRENCY", 
		"FROM_GL", "FROM_CIF", "FROM_SL", "FROM_NAME", "TO_BRANCH", "TO_CURRENCY", "TO_GL", 
		"TO_CIF", "TO_SL","TO_ADD_REFERENCE", "TO_NAME", "STATUS" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	  //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.STATUS_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());

	    criteria.setLovType(ConstantsCommon.STATUS_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.linksAccAccListCount(criteria));
	    }
	    setGridModel(dashOthersBO.linksAccAccList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Links List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String linksListAccCifGrid()
    {
	String[] searchCol = { "CODE", "SERIAL", "BRIEF_NAME", "FROM_BRANCH", "FROM_CURRENCY", 
		"FROM_GL", "FROM_CIF", "FROM_SL","FROM_ADD_REFERENCE", "FROM_NAME", "TO_CIF_NO", "TO_CIF_NAME", "STATUS" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	  //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	 
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.STATUS_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.linksAccCifListCount(criteria));
	    }
	    setGridModel(dashOthersBO.linksAccCifList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Links List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String linksListCifAccGrid()
    {
	String[] searchCol = { "CODE", "SERIAL", "BRIEF_NAME", "FROM_CIF_NO", "FROM_CIF_NAME", 
		"TO_BRANCH", "TO_CURRENCY", "TO_GL","TO_ADD_REFERENCE", "TO_CIF", "TO_SL", "TO_NAME", "STATUS" };

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	  //[John Massaad]-- IN CASE 360 degree opened From another application then CSM The USER_ID of the Login application may not have a TELLER_CODE
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(get_pageRef());
	    //917789 - DBU191081  
	    criteria.setLoginBranchCode(sessionCO.getBranchCode());
	    criteria.setLanguage(sessionCO.getLanguage());
	    criteria.setLovType(ConstantsCommon.STATUS_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashOthersBO.linksCifAccListCount(criteria));
	    }
	    setGridModel(dashOthersBO.linksCifAccList(criteria));
	}

	catch(Exception ex)
	{
	    log.error(ex, "Error in Links List Grid");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public void setDashOthersBO(DashOthersBO dashOthersBO)
    {
	this.dashOthersBO = dashOthersBO;
    }

    public DashboardSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }

    public int getIsCifCif()
    {
        return isCifCif;
    }

    public void setIsCifCif(int isCifCif)
    {
        this.isCifCif = isCifCif;
    }

    public int getIsAccAcc()
    {
        return isAccAcc;
    }

    public void setIsAccAcc(int isAccAcc)
    {
        this.isAccAcc = isAccAcc;
    }

    public int getIsAccCif()
    {
        return isAccCif;
    }

    public void setIsAccCif(int isAccCif)
    {
        this.isAccCif = isAccCif;
    }

    public int getIsCifAcc()
    {
        return isCifAcc;
    }

    public void setIsCifAcc(int isCifAcc)
    {
        this.isCifAcc = isCifAcc;
    }
}
