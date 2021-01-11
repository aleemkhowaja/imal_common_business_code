package com.path.core.actions.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.core.bo.blacklistmanagement.BlackListLogBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.blacklistmanagement.BlackListLogCO;
import com.path.vo.core.blacklistmanagement.BlackListLogSC;
import com.path.vo.core.blacklistmanagement.BlackListNameMatchCO;
import com.path.vo.core.blacklistmanagement.BlackListReasonCO;
import com.path.core.bo.blacklistmanagement.BlackListConstant;

public class BlackListLogMaintAction extends RetailBaseAction
{
    
    BlackListLogSC blackListLogSC = new BlackListLogSC();
    BlackListLogBO blackListLogBO;
    BlackListLogCO blackListLogCO;
    private BigDecimal lineNo;
    private List<SelectCO> blackListLogActionList = new ArrayList<SelectCO>();
    private String isAML; //added by bilal for TP#885556
    
    

    public String loadBlackListLogPage() throws BaseException
    {
    	//added by bilal for TP#885556
    	SessionCO sessionObject = returnSessionObject();
    	if(BlackListConstant.APP_AML.equals(sessionObject.getCurrentAppName()))
    	{
    		setIsAML(ConstantsCommon.TRUE);
    	}
    	else
    	{
    		setIsAML(ConstantsCommon.FALSE);
    	}
    	
    	return "blackListLogPage";
    }
    
    
    public String loadBlackListLogGrid(){
	

	try
	{
	    String[] searchCol = {  };
	    SessionCO sessionObject = returnSessionObject();
	    blackListLogSC.setCompCode(sessionObject.getCompanyCode());
	    blackListLogSC.setBranchCode(sessionObject.getBranchCode());
	    blackListLogSC.setPreferredLanguage(sessionObject.getLanguage());  //added by rany for tpid:514489-SBI170088 tfa blacklist checking
	    //blackListLogSC.setEntityNo(transferCashSC.getTrsNo());
	    //added by bilal for TP#885556
	    blackListLogSC.setCurrAppName(sessionObject.getCurrentAppName());

	    copyproperties(blackListLogSC);

	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(blackListLogSC))
	    {
		setRecords(blackListLogBO.loadBlackListLogGridCount(blackListLogSC));
	    }

	    /**
	     * return the collection of records
	     */
	    List<BlackListLogCO> transferCashSubGridCashCOs = blackListLogBO.loadBlackListLogGrid(blackListLogSC);



	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(transferCashSubGridCashCOs);

	   
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	 return SUCCESS;

    }
    
    
    public String loadBlackListReasonGrid()
    {

	return "successBlckListReason";
	
    }
    
    
    public String loadBlackListReasonPage () {
	
	
	try
	{
	    String[] searchCol = {  };
	    SessionCO sessionObject = returnSessionObject();
	    blackListLogSC.setCompCode(sessionObject.getCompanyCode());
	    blackListLogSC.setBranchCode(sessionObject.getBranchCode());


	    copyproperties(blackListLogSC);

	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(blackListLogSC))
	    {
		setRecords(blackListLogBO.loadBlackListReasonGridCount(blackListLogSC));
	    }

	    /**
	     * return the collection of records
	     */
	    List<BlackListReasonCO> transferCashSubGridCashCOs = blackListLogBO.loadBlackListReasonPageGrid(blackListLogSC);



	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(transferCashSubGridCashCOs);

	   
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	 return SUCCESS;
	
	
    }
    

    public String loadBlackListNameMatchGrid()
    {

	return "successBlckListNameMatch";
	
    }
    
    
    public String loadBlackListNameMatchPage () {
	
	
	try
	{
	    String[] searchCol = {  };
	    SessionCO sessionObject = returnSessionObject();
	    blackListLogSC.setCompCode(sessionObject.getCompanyCode());
	    blackListLogSC.setBranchCode(sessionObject.getBranchCode());


	    copyproperties(blackListLogSC);

	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(blackListLogSC))
	    {
		setRecords(blackListLogBO.loadBlackListNameMatchGridCount(blackListLogSC));
	    }

	    /**
	     * return the collection of records
	     */
	    List<BlackListNameMatchCO> transferCashSubGridCashCOs = blackListLogBO.loadBlackListNameMatchPageGrid(blackListLogSC);



	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(transferCashSubGridCashCOs);

	   
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	 return SUCCESS;
	
	
    }
    
    public String loadBlackListLogActionList() throws BaseException
    {
	try
	{
	    SelectSC selSC = new SelectSC(BlackListConstant.BLACKLIST_LOG_ACTION_LOV);
	    blackListLogActionList.add(new SelectCO("",""));
	    blackListLogActionList = returnLOV(selSC);
	    blackListLogActionList.add(new SelectCO("",""));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String process()
    {
	try
	{

	    if(StringUtil.isNotEmpty(blackListLogCO.getBlackListLogCOsStr()))
	    {
		GridUpdates gu = getGridUpdates(blackListLogCO.getBlackListLogCOsStr(), BlackListLogCO.class, true);
		blackListLogCO.setBlackListLog(gu.getLstAllRec());
		SessionCO sessionObject = returnSessionObject();
		blackListLogCO.setLanguage(sessionObject.getLanguage());//added by rany for tpid:514489-SBI170088 tfa blacklist checking  
		blackListLogCO.setCompCode(sessionObject.getCompanyCode());
		blackListLogCO.setBranchCode(sessionObject.getBranchCode());
		blackListLogCO.setUserId(sessionObject.getUserName());
		blackListLogCO.setAppName(sessionObject.getCurrentAppName());
		blackListLogCO.setRunningDate(sessionObject.getRunningDateRET());
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    blackListLogBO.process(blackListLogCO);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    public BlackListLogSC getBlackListLogSC()
    {
        return blackListLogSC;
    }


    public void setBlackListLogSC(BlackListLogSC blackListLogSC)
    {
        this.blackListLogSC = blackListLogSC;
    }


    public void setBlackListLogBO(BlackListLogBO blackListLogBO)
    {
        this.blackListLogBO = blackListLogBO;
    }


    public BigDecimal getLineNo()
    {
        return lineNo;
    }


    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }


    public List<SelectCO> getBlackListLogActionList()
    {
        return blackListLogActionList;
    }


    public void setBlackListLogActionList(List<SelectCO> blackListLogActionList)
    {
        this.blackListLogActionList = blackListLogActionList;
    }


    public BlackListLogCO getBlackListLogCO()
    {
        return blackListLogCO;
    }


    public void setBlackListLogCO(BlackListLogCO blackListLogCO)
    {
        this.blackListLogCO = blackListLogCO;
    }


	public String getIsAML() {
		return isAML;
	}


	public void setIsAML(String isAML) {
		this.isAML = isAML;
	}
    
    
    
    
}
