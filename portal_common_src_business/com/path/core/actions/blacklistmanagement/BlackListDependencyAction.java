package com.path.core.actions.blacklistmanagement;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.memo.MemoConstants;
import com.path.core.bo.blacklistmanagement.BlackListBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.blacklistmanagement.BlackListCO;

/**
 * This class is used for all dependencies under Black List Management / ...
 * Notes : it has been created recently, you may find many missing dependencies into 
 */
public class BlackListDependencyAction extends RetailBaseAction
{
    private BlackListCO blackListCO = new BlackListCO();
    private BlackListBO blackListBO;

    private final static String LOADJSON = "loadJson";

    @Override
    public Object getModel()
    {
	return blackListCO;
    }

    
    // Black List CodeDependency
    public String validateBlackListCode()
    {
	try
	{
	    set_forceAfterDepEvent("true");
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.getBlackListVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    blackListCO = blackListBO.validateBlackListCode(blackListCO);
	}
	catch(BOException e)
	{
	    set_disRevertOldVal("true");
	    blackListCO.getBlackListVO().setCODE(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }
    
    

    // Doc No. Dependency
    public String dependnecyByDocNo()
    {
	try
	{ // verify code.
	    if(NumberUtil.emptyDecimalToNull(blackListCO.getBlackListVO().getCODE()) == null)
	    {
		throw new BOException(MessageCodes.PLEASE_DEFINE_THE_BLACKLIST_CODE);
	    }
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setLoginCompCode(sessionCO.getCompanyCode());
	    blackListCO = blackListBO.getBlackListetailsbyDocNo(blackListCO);
	    if(blackListCO.getCifCO().isShowDepMsg())// flag to show if message
						     // need to be shown
	    {
		String errMsg = returnCommonLibBO().returnTranslErrorMessage(
			MessageCodes.MULTIPLE_CIFS_EXIST_FOR_SAME_ID_NUMBER, sessionCO.getLanguage());
		addDependencyMsg(errMsg, null);
	    }

	}
	catch(BOException e)
	{
	    blackListCO.setCifCO(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }

    
    
    public String dependnecyByCIFNo()
    {
    	try
    	{

    	    SessionCO sessionCO = returnSessionObject();
    	    blackListCO.setLoginCompCode(sessionCO.getCompanyCode());
    	    blackListCO = blackListBO.dependencyByCIFNo(blackListCO);
    	    getAdditionalScreenParams().putAll(blackListCO.getHm());
    	    if(!NumberUtil.isEmptyDecimal(blackListCO.getCifCO().getCifVO().getCIF_NO()))
    	    {
    		MemoSC memoSC = new MemoSC();
    		memoSC.setCompCode(sessionCO.getCompanyCode());
    		memoSC.setAppType(MemoConstants.CSM_APP_TYPE);
    		memoSC.setForAccOrCif(MemoConstants.CIF);
    		memoSC.setOptRef(MemoConstants.MEMO_BLACKLIST_OPT);
    		memoSC.setCifNo(blackListCO.getCifCO().getCifVO().getCIF_NO());
    		checkForMemo(memoSC);
    	    }
    	}
    	catch(Exception e)
    	{
    	    blackListCO = null;
    	    handleException(e, null, null);
    	}
    	return LOADJSON;
        }


    public String dependencyValidationByBlackListBirthDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	    blackListCO.getBlackListVO().setTYPE("V");// temp entry
	    blackListCO = blackListBO.validateAndReturnBirthDate(blackListCO);
	}
	catch(BOException e)
	{
	    blackListCO.getBlackListVO().setDATE_OF_BIRTH(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }

    
    // Issue Date Dependency
    public String dependencyValidationByBlackListIssueDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	    blackListCO.getBlackListVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    blackListCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    blackListCO = blackListBO.validateAndReturnIssueDate(blackListCO);
	}
	catch(BOException e)
	{
	    blackListCO.getBlackListVO().setOID_DATE_ISSUED(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }


    // Source Date Dependency
    public String dependencyValidationByBlackListSourceDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	    blackListCO.getBlackListVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    blackListCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    blackListCO = blackListBO.validateAndReturnSourceDate(blackListCO);
	}
	catch(BOException e)
	{
	    blackListCO.getBlackListVO().setSOURCE_DATE(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }

    
    // Black List Type Dependency
    public String dependencyByBlackListTypeCode()
    {
	try
	{
	    BigDecimal blacklistType = blackListCO.getBlackListVO().getBLACKLIST_TYPE();
	    if(NumberUtil.isEmptyDecimal(blacklistType))
	    {
		blackListCO.getBlackListVO().setBLACKLIST_TYPE(null);
	    }
	    else
	    {
		SessionCO sessionCO = returnSessionObject();
		blackListCO.setRunningDate(sessionCO.getRunningDateRET());
		blackListCO.getBlackListVO().setCOMP_CODE(sessionCO.getCompanyCode());
		blackListCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		blackListCO = blackListBO.returnBlackListTypeData(blackListCO);
	    }
	}
	catch(BOException e)
	{
	    blackListCO.getBlackListVO().setBLACKLIST_TYPE(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }

    // Revision Date Dependency
    public String dependencyValidationByBlackListRevisionDate()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    blackListCO.setRunningDate(sessionCO.getRunningDateRET());
	    blackListCO.getBlackListVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    blackListCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    blackListCO = blackListBO.validateAndReturnRevisionDate(blackListCO);
	}
	catch(BOException e)
	{
	    blackListCO.getBlackListVO().setREVISION_DATE(null);
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return LOADJSON;
    }

    
    public BlackListCO getBlackListCO()
    {
	return blackListCO;
    }

    public void setBlackListCO(BlackListCO blackListCO)
    {
	this.blackListCO = blackListCO;
    }

    public void setBlackListBO(BlackListBO blackListBO)
    {
	this.blackListBO = blackListBO;
    }

}
