/**
 * 
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.currency.CurrencyBO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.core.currency.CurrencySC;

/**
 * @author MarwanMaddah
 * 
 */
public class CurrencyDependencyAction extends RetailBaseAction
{
    private AMFVO account = new AMFVO();
    private CURRENCIESVO currency = new CURRENCIESVO();
    private CurrencyBO currencyBO;
    private BigDecimal CURRENCY_CODE;
    private BigDecimal BRANCH_CODE;
    private String BRIEF_DESC_ENG;
    private BigDecimal COMP_CODE;
    private String includeAllCurrencies;

    private BigDecimal displayMsg;

    /**
     * used for the dependency management on currency change in account default
     * management.
     * 
     * @return
     */
    public String dependencyByCYId()
    {
	try
	{
	    CurrencySC criteria = new CurrencySC();
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * set the criteria...
	     */
	    // criteria.setBranchCode(account.getBRANCH_CODE());
	    // criteria.setCurrencyCode(account.getCURRENCY_CODE());

	    BigDecimal brCode = account.getBRANCH_CODE();
	    BigDecimal curCode = account.getCURRENCY_CODE();

	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setBranchCode(NumberUtil.emptyDecimalToNull(brCode));
	    criteria.setCurrencyCode(NumberUtil.emptyDecimalToNull(curCode));
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(!currencyBO.checkCurrencyValidation(criteria))
	    {
		account.setCURRENCY_CODE(null);
	    }
	    account.setCIF_SUB_NO(null);
	    account.setSL_NO(null);
	    account.setGL_CODE(null);
	    account.setCOMP_CODE(null);
	    account.setBRIEF_NAME_ENG(null);
	    account.setADDITIONAL_REFERENCE(null);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCYId method of CurrencyDependencyAction.java");
	    handleException(e, "ERROR IN CURRENCY DEPENDENCY MANAGEMENR", null);
	}
	return SUCCESS;
    }

    /**
     * Get currency by id
     * 
     * @return
     */
    public String returnCurrencyInBranchById()
    {
	try
	{
	    CurrencySC criteria = new CurrencySC();
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setUserId(sessionCO.getUserName());

	    if(NumberUtil.nullToZero(getBRANCH_CODE()).intValue() == 0
		    || NumberUtil.nullToZero(getBRANCH_CODE()).intValue() == -9999999)
	    {
		setBRANCH_CODE(sessionCO.getBranchCode());
	    }

	    criteria.setBranchCode(getBRANCH_CODE());

	    if(null == getCURRENCY_CODE())
	    {
		currency = new CURRENCIESVO();
	    }
	    else
	    {
		criteria.setCurrencyCode(getCURRENCY_CODE());
		currency = currencyBO.returnCurrencyInBranchById(criteria);
		if(null == currency)
		{
		    currency = new CURRENCIESVO();
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in returnCurrencyInBranchById method of CurrencyDependencyAction.java");
	    handleException(e, "ERROR IN CURRENCY DEPENDENCY MANAGEMENR", null);
	}
	return SUCCESS;

    }

    /**
     * Method for dependency by using currency code
     * 
     * @return
     */
    public String dependencyByCurrencyCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CurrencySC criteria = new CurrencySC();
	    /**
	     * if condition added By HanaaElJazzar for TrxTemplate Screen. If
	     * the company code was not sent to this method, then take it from
	     * the session....
	     */
	    if(NumberUtil.isEmptyDecimal(COMP_CODE))
	    {
		criteria.setCompCode(sessionCO.getCompanyCode());
	    }
	    else
	    {
		criteria.setCompCode(COMP_CODE);
	    }
	    // criteria.setCompCode(sessionCO.getCompanyCode());//commented by
	    // Assets Team
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCurrencyCode(CURRENCY_CODE);
	    // the below was commented by Assets Team and replaced with the next
	    // 2 lines
	    // Object currDep = currencyBO.returnCurrencyById(criteria);
	    // if(currDep == null)
	    if(!NumberUtil.isEmptyDecimal(CURRENCY_CODE)) // added by assets
	    // team for tp bug
	    // 88677
	    {
		if("1".equals(includeAllCurrencies) && BigDecimal.ZERO.compareTo(NumberUtil.nullToZero(CURRENCY_CODE)) == 0)
		{
		    currency.setCURRENCY_CODE(BigDecimal.ZERO);
		    CommonLibSC sc = new CommonLibSC();
		    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		    sc.setKeyLabelCode("all_currencies_key");
		    if(ConstantsCommon.PREFERED_LANG_ARABIC.equals(sessionCO.getPreferredLanguage()))
		    {
			sc.setLanguage(ConstantsCommon.LANGUAGE_ARABIC);
		    }
		    else
		    {
			sc.setLanguage(ConstantsCommon.LANGUAGE_ENGLISH);
		    }
		    currency.setBRIEF_DESC_ENG(returnCommonLibBO().returnKeyLabelTrans(sc));
		}
		else
		{
		    currency = currencyBO.returnCurrencyById(criteria);
		}

		if(currency == null)

		{
		    if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(getDisplayMsg())) == 0)
		    {
			String errMsg = returnCommonLibBO().returnTranslErrorMessage(
				MessageCodes.INVALID_MISSING_CURRENCY, sessionCO.getLanguage());
			addDependencyMsg(errMsg, null);
		    }

		    else
		    {
			String errMsg = returnCommonLibBO().returnTranslErrorMessage(
				MessageCodes.INVALID_MISSING_DEAL_CURRENCY, sessionCO.getLanguage());
			addDependencyMsg(errMsg, null);
		    }

		}
		// currency =
		// currencyBO.returnCurrencyById(criteria);//commented by
		// by Assets Team
	    }
	    // TP#235336;Arun.R.Variyath;02/01/2015
	    NumberUtil.resetEmptyValues(account);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCurrencyCode method of CurrencyDependencyAction");
	    handleException(e, "ERROR in Currency Dependency", null);
	    currency.setCURRENCY_CODE(null);
	    setCURRENCY_CODE(null);
	}
	if(null == currency)
	{
	    currency = new CURRENCIESVO();
	}
	return SUCCESS;
    }

    /**
     * Method for dependency by using currency code
     * 
     * @return
     */
    public String dependencyByCurrencyCodeFms()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CurrencySC criteria = new CurrencySC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCurrencyCode(CURRENCY_CODE);
	    currency = currencyBO.returnCurrencyByIdFms(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCurrencyCodeFms method of CurrencyDependencyAction");
	    handleException(e, "ERROR in Currency Dependency fms", null);
	}
	if(null == currency)
	{
	    currency = new CURRENCIESVO();
	}
	return SUCCESS;
    }

    /*
     * this method is similar to dependencyByCurrencyCode but it doesn't prompt
     * any alert
     */
    public String dependencyByCurrencyCode1()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CurrencySC criteria = new CurrencySC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setCurrencyCode(CURRENCY_CODE);
	    currency = currencyBO.returnCurrencyById(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

	/**
     * Method for dependency by using currency code
     */
    public String dependencyByCurrencyCodeFAS()
    {
		 try
		 {
			 SessionCO sessionCO = returnSessionObject();
			 CurrencySC criteria = new CurrencySC();
			 criteria.setCompCode(sessionCO.getCompanyCode());
			 criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());

			 if(BigDecimal.ZERO.compareTo(CURRENCY_CODE) == 0)
			 {
			  currency.setCURRENCY_CODE(CURRENCY_CODE);
			  currency.setBRIEF_DESC_ENG("OTHERS");
			  currency.setLONG_DESC_ENG("OTHERS");
			 }
			 else if(BigDecimal.valueOf(-1).compareTo(CURRENCY_CODE) == 0)
			 {
			  currency.setCURRENCY_CODE(CURRENCY_CODE);
			  currency.setBRIEF_DESC_ENG("ALL");
			  currency.setLONG_DESC_ENG("ALL");
			 }
			 else
			 {
			  criteria.setCurrencyCode(CURRENCY_CODE);
			  currency = currencyBO.returnCurrencyById(criteria);
			  
			  if(currency == null)
			  {
			      throw new BOException(MessageCodes.INVALID_MISSING_CURRENCY);
			  }
			  
			 }
		 }
		 catch(Exception e)
		 {
			 log.error(e, "Error in dependencyByCurrencyCodeFAS method of CurrencyDependencyAction");
			 handleException(e, null, null);
		 }
		 return SUCCESS;
    }
	
    /**
     * Get the currency code
     * 
     * @return
     */
    public BigDecimal getCURRENCY_CODE()
    {
	return CURRENCY_CODE;
    }

    /**
     * Sets the currency code
     * 
     * @param currencyCode
     */
    public void setCURRENCY_CODE(BigDecimal currencyCode)
    {
	CURRENCY_CODE = currencyCode;
    }

    /**
     * Get the brief desc
     * 
     * @return
     */
    public String getBRIEF_DESC_ENG()
    {
	return BRIEF_DESC_ENG;
    }

    /**
     * Sets the bried description
     * 
     * @param briefDescEng
     */
    public void setBRIEF_DESC_ENG(String briefDescEng)
    {
	BRIEF_DESC_ENG = briefDescEng;
    }

    /**
     * Get AMF vo
     * 
     * @return
     */
    public AMFVO getAccount()
    {
	return account;
    }

    /**
     * Sets the Amf Vo
     * 
     * @param account
     */
    public void setAccount(AMFVO account)
    {
	this.account = account;
    }

    /**
     * Gets the currency VO
     * 
     * @return
     */
    public CURRENCIESVO getCurrency()
    {
	return currency;
    }

    /**
     * Sets the currency VO
     * 
     * @param currency
     */
    public void setCurrency(CURRENCIESVO currency)
    {
	this.currency = currency;
    }

    /**
     * Sets the currency BO
     * 
     * @param currencyBO
     */
    public void setCurrencyBO(CurrencyBO currencyBO)
    {
	this.currencyBO = currencyBO;
    }

    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal bRANCHCODE)
    {
	BRANCH_CODE = bRANCHCODE;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public BigDecimal getDisplayMsg()
    {
	return displayMsg;
    }

    public void setDisplayMsg(BigDecimal displayMsg)
    {
	this.displayMsg = displayMsg;
    }

    public String getIncludeAllCurrencies()
    {
        return includeAllCurrencies;
    }

    public void setIncludeAllCurrencies(String includeAllCurrencies)
    {
        this.includeAllCurrencies = includeAllCurrencies;
    }

}
