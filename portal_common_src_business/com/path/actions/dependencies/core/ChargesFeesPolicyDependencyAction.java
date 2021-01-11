package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.chargesfeespolicy.ChargesFeesPolicyBO;
import com.path.dbmaps.vo.CTS_CHARGES_FEES_POLICYVO;
import com.path.vo.core.chargesfeespolicy.ChargesFeesPolicySC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AIssac
 *
 * ChargesFeesPolicyDependencyAction.java used to
 */
public class ChargesFeesPolicyDependencyAction extends RetailBaseAction
{	
    private final ChargesFeesPolicySC criteria = new ChargesFeesPolicySC();
    private ChargesFeesPolicyBO chargesFeesPolicyBO;
    private CTS_CHARGES_FEES_POLICYVO chargesFeePolicyVO;
    private BigDecimal feesPolicyCode;

    public String dependencyByChargesFeesPolicyCode() {
	try 
	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setChargesCode(feesPolicyCode);
	    criteria.setLangCode(returnSessionObject().getLanguage());
	    criteria.setLovType(ConstantsCommon.PERIODICITY_LOV_TYPE);// For Periodicity
	    chargesFeePolicyVO = chargesFeesPolicyBO.chargesFeesPolicyById(criteria);
	} 
	catch (Exception e) 
	{
	    log.error(e,"Error in dependencyByChargesFeesPolicyCode method of ChargesFeesPolicyDependencyAction");
	    handleException(e, "ERROR in charges Fees Policy Dependency", null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public void setChargesFeesPolicyBO(ChargesFeesPolicyBO chargesFeesPolicyBO)
    {
	this.chargesFeesPolicyBO = chargesFeesPolicyBO;
    }

    public CTS_CHARGES_FEES_POLICYVO getChargesFeePolicyVO()
    {
	return chargesFeePolicyVO;
    }

    public void setChargesFeePolicyVO(CTS_CHARGES_FEES_POLICYVO chargesFeePolicyVO)
    {
	this.chargesFeePolicyVO = chargesFeePolicyVO;
    }
    

    public BigDecimal getFeesPolicyCode()
    {
        return feesPolicyCode;
    }

    public void setFeesPolicyCode(BigDecimal feesPolicyCode)
    {
        this.feesPolicyCode = feesPolicyCode;
    }

}
