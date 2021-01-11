package com.path.actions.dependencies.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.trxmgnt.TrxMgntConstant;
import com.path.bo.core.trxtype.TrxTypeBO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trxtype.TrxTypeSC;

public class CtsTrxTypeDependencyAction extends RetailBaseAction
{

    private TrxTypeBO trxTypeBO;
    private CTSTRXTYPEVO ctsTrxTypeVO = new CTSTRXTYPEVO();
    private TrxTypeSC criteria = new TrxTypeSC();
    private String bnameEngReadOnly = "true";
    private BigDecimal trxCode;
    private String fromWhere;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String dependencyByTrxTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setStatus("P");
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setFromTrxTypeDep("true");
	    if(ctsTrxTypeVO == null || NumberUtil.emptyDecimalToNull(ctsTrxTypeVO.getCODE()) == null)
	    {
		ctsTrxTypeVO = new CTSTRXTYPEVO();
	    }
	    else
	    {
		criteria.setCode(ctsTrxTypeVO.getCODE());
		
		List<String> allOptsLst = TrxMgntConstant.allOptsList;
		String[] optDetails = returnCommonLibBO().returnOptDetailsList(returnSessionObject().getCurrentAppName(), get_pageRef());
		if(optDetails != null && optDetails[4] != null && allOptsLst.contains(optDetails[4])
                   &&
		    /*
		     * Checking for Transaction Type Groups
		     */
		    (!allOptsLst.contains(get_pageRef())) )
		{
		    criteria.setIsDyOpt(TrxMgntConstant.TRUE_LOWER_CASE);
		    criteria.setReference(get_pageRef().substring(0, get_pageRef().length() - 2));
		}
		if(TrxMgntConstant.OPT_SCANCHEQUEMT.equals(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef())))
		{
		    criteria.setChqRelated("'"+TrxMgntConstant.CLEARING_CHEQUE+"'");
		}
		
		ctsTrxTypeVO = trxTypeBO.returnTrxTypeDependencyById(criteria);
		if(ctsTrxTypeVO == null)
		{
		    ctsTrxTypeVO = new CTSTRXTYPEVO();
		}
	    }
	    setBnameEngReadOnly("true");
    	    //NABIL FEGHALI - IIAB110237 - SOA Charges
	    resetTrxStatementReport(this.session);
	}
	catch(Exception e)
	{
//    	    	log.error(e, "Error in dependencyByTrxTypeCode method of CtsTrxTypeDependencyAction");
	    ctsTrxTypeVO = new CTSTRXTYPEVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
	
    public String dependencyByTrxTypeCodeOnly()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCode(trxCode);
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    ctsTrxTypeVO = trxTypeBO.returnTrxTypeDependencyById(criteria);
	    
//			if(criteria.getCode().compareTo(BigDecimal.ONE)==0)
//				ctsTrxTypeVO.setSTATUS("P");
//			else
//			ctsTrxTypeVO.setSTATUS("D");
	}
	catch(Exception e)
	{
		ctsTrxTypeVO = new CTSTRXTYPEVO();
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
	
    public String dependencyByCardTrxTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    ctsTrxTypeVO = trxTypeBO.cardsTrxTypeDependency(criteria);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCardTrxTypeCode method of CtsTrxTypeDependencyAction");
	    handleException(e, "ERROR in Card Trx Type Dependency", null);
	}

	return SUCCESS;
    }
	
    public String dependencyByCtsTrxTypeCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    if(NumberUtil.isEmptyDecimal(criteria.getCode()))
	    {
		throw new BOException(MessageCodes.INVALID_ENTRY);
	    }
	    ctsTrxTypeVO = trxTypeBO.returnHoldTrxTypeByDependency(criteria);
	    if(ctsTrxTypeVO == null)
	    {
		ctsTrxTypeVO = new CTSTRXTYPEVO();
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCtsTrxTypeCode method of TrxTypeDependencyAction");
	    handleException(e, null, null);
	    ctsTrxTypeVO.setCODE(null);
	    criteria = null;
	}
	return SUCCESS;
    }
	 
    public String dependencyByTransactionTrendsTrxTypeCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setStatus("P");
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    ctsTrxTypeVO = trxTypeBO.trxTypeForTransactionTrendsDependency(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCardTrxTypeCode method of CardsTrxTypeDependencyAction");
	    handleException(e, "ERROR in Card Trx Type Dependency", null);
	}

	return SUCCESS;
    }
	  
    public String dependencyByLimitSchemaTrxTypeCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setStatus("P");
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(criteria.getCode() != null && (criteria.getCode().compareTo(BigDecimal.ZERO) == 0))
	    {
		int trxTypeListCount = trxTypeBO.trxTypeListCount(criteria);
		if(trxTypeListCount > 0)
		{
		    ctsTrxTypeVO.setCODE(BigDecimal.ZERO);
		    ctsTrxTypeVO.setSHORT_DESC_ENG(getText("All_types_key"));
		}
	    }
	    else
	    {
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		ctsTrxTypeVO = trxTypeBO.returnTrxTypeDependencyById(criteria);
	    }

//	    if(ctsTrxTypeVO == null)
//	    {
//		String errMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.INVALID_TRX_TYPE, sessionCO.getLanguage());
//		addDependencyMsg(errMsg, null);
//	    }
//			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
//			ctsTrxTypeVO = trxTypeBO.trxTypeForTransactionTrendsDependency(criteria);
			
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCardTrxTypeCode method of CardsTrxTypeDependencyAction");
	    handleException(e, "ERROR in Card Trx Type Dependency", null);
	}

	return SUCCESS;
    }

    /****
     * Method for checking the dependency by trx type code for fixed maturity
     * account dddw_import_trxtype: AccountsIntructionsTab.jsp
     * 
     * @return
     */
    public String dependencyByCtsTrxTypeCodeForFma()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setType("T");
	    criteria.setChequeFlag("N");
	    criteria.setTrsfr(BigDecimal.ONE);
	    criteria.setNostro("2");
	    criteria.setMultiTrx("0");
	    criteria.setFolderType("F");
	    criteria.setReference(fromWhere);
	    if(criteria.getCode() == null)
	    {
		ctsTrxTypeVO = new CTSTRXTYPEVO();
	    }
	    else
	    {
		ctsTrxTypeVO = trxTypeBO.getTrxTypeForFma(criteria);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCtsTrxTypeCode method of TrxTypeDependencyAction");
	    handleException(e, "ERROR in Hold Trx Type Dependency", null);
	}
	return SUCCESS;
    }
    
    /****
     * Hasan TP#82867 BPI120091 -phase 2
     * Method for checking the dependency by trx type code for account charges
     * 
     * @return
     */
    public String dependencyByCtsTrxTypeCodeAccCharges()
    {
		try
		{
		    SessionCO sessionCO = returnSessionObject();
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setUserId(sessionCO.getUserName());
		    criteria.setStatus("P");
		    if(criteria.getCode() == null)
		    {
			ctsTrxTypeVO = new CTSTRXTYPEVO();
		    }
		    else
		    {
			ctsTrxTypeVO = trxTypeBO.trxTypeLookupForAccChargesDependency(criteria);
		    }
		}
		catch(Exception e)
		{
		    log.error(e, "Error in dependencyByCtsTrxTypeCodeAccCharges method of TrxTypeDependencyAction");
		    handleException(e, "ERROR in Trx Type Dependency", null);
		}
		return SUCCESS;
    }
	
    // NABIL FEGHALI - IIAB110237 - SOA Charges
    private void resetTrxStatementReport(Map<String, Object> sessionMapParam)
    {
	Map<String, Object> sessionMap = sessionMapParam;
	if(sessionMapParam != null && "2".equals(ctsTrxTypeVO.getPROCESS_WINDOW()))
	{

	    sessionMap.remove(TrxMgntConstant.SOA_REPORT_BYTES);
	    sessionMap.remove(TrxMgntConstant.SOA_WATERMARK_REPORT_BYTES);

	}
    }
	
    public void setTrxTypeBO(TrxTypeBO trxTypeBO)
    {
	this.trxTypeBO = trxTypeBO;
    }

    public CTSTRXTYPEVO getCtsTrxTypeVO()
    {
	return ctsTrxTypeVO;
    }

    public void setCtsTrxTypeVO(CTSTRXTYPEVO ctsTrxTypeVO)
    {
	this.ctsTrxTypeVO = ctsTrxTypeVO;
    }

    public TrxTypeSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(TrxTypeSC criteria)
    {
	this.criteria = criteria;
    }

    public String getBnameEngReadOnly()
    {
	return bnameEngReadOnly;
    }

    public void setBnameEngReadOnly(String bnameEngReadOnly)
    {
	this.bnameEngReadOnly = bnameEngReadOnly;
    }

    public BigDecimal getTrxCode()
    {
	return trxCode;
    }

    public void setTrxCode(BigDecimal trxCode)
    {
	this.trxCode = trxCode;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }
}
