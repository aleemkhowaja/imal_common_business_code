/**
 * 
 */
package com.path.actions.common.requests.csm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.requests.csm.CtsRequestCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * @author raees
 * 
 */
public class CtsRequestCommonMaintAction extends GridBaseAction
{
    CtsRequestCO ctsRequestCO = new CtsRequestCO();
    private CtsRequestBO ctsRequestBO;
    private List<SelectCO> paymentTypeList = new ArrayList<SelectCO>();

    @Override
    public Object getModel()
    {
	return ctsRequestCO;
    }
    
    public void fillSessionData() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	ctsRequestCO.setLoginCompCode(sessionCO.getCompanyCode());
	ctsRequestCO.setLoginBraCode(sessionCO.getBranchCode());
	ctsRequestCO.setLanguage(sessionCO.getLanguage());
	ctsRequestCO.setAppName(sessionCO.getCurrentAppName());
	ctsRequestCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	ctsRequestCO.setOpt(get_pageRef());
	ctsRequestCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	ctsRequestCO.setCrud(getIv_crud());
	ctsRequestCO.setOriginalAppName(sessionCO.getOriginalAppName());
	ctsRequestCO.setOriginalProgRef(sessionCO.getOriginalProgRef());
	ctsRequestCO.setRunningDate(sessionCO.getRunningDateRET());

	if(null == sessionCO.getCtsTellerVO())
	{
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getOriginalAppName()))
	    {
		BigDecimal compCode = sessionCO.getCompanyCode();
		BigDecimal branchCode = sessionCO.getBranchCode();
		CTSTELLERVO ctsTellerVO = returnCommonLibBO().returnCtsTellerDetails(compCode, branchCode,
			sessionCO.getUserName());
		ctsRequestCO.setLoginTellerCode(ctsTellerVO.getCODE());
	    }
	}
	else
	{
	    ctsRequestCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
	}
    }
    

    public String loadChargesMaint()
    {
	try
	{
	    fillSessionData();
	    // in case we open the screen from CSM directly, or from the
	    // emebeded TFA in CSM
	    if(ConstantsCommon.CSM_APP_NAME.equals(returnSessionObject().getOriginalAppName())
		    || ConstantsCommon.CSM_APP_NAME.equals(returnSessionObject().getCurrentAppName()))
	    {
		SelectSC selSC = new SelectSC(CtsRequestConstant.PAYMENT_TYPE_LOV_TYPE);
		paymentTypeList = returnLOV(selSC);
	    }

	    if( ConstantsCommon.TFA_APP_NAME.equals( ctsRequestCO.getAppName()))
	    {
		if(NumberUtil.isEmptyDecimal(ctsRequestCO.getCtsRequestVO().getREQ_NO())
			|| "A".equals(ctsRequestCO.getCtsRequestVO().getSTATUS()) && "R".equals(getIv_crud()))
		{
		    set_recReadOnly("false");
		}
		else
		{
		    set_recReadOnly("true");
		}
	    }
		
	    ctsRequestCO = ctsRequestBO.returnCtsRqstInfoChargesDet(ctsRequestCO);
	    getAdditionalScreenParams().putAll(ctsRequestCO.getHmSysParam());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "chargesMaint";

    }
    
    private CtsRequestSC fillSessionCriteria(CtsRequestSC criteria)
    {
	SessionCO sessionCO = returnSessionObject();
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setBranchCode(sessionCO.getBranchCode());
	criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	criteria.setCode(ctsRequestCO.getCtsRequestVO().getREQ_NO());
	criteria.setPaymentType(ctsRequestCO.getPaymentType());
	return criteria;
    }

    /**
     * First method to open the screen
     * 
     * @return
     */
    public String loadChargesSection() throws BaseException
    {
	try
	{
	    // fillSessionData(returnSessionObject());
	    ctsRequestCO.getEntityChargesCO().setEntityType(CtsRequestConstant.REQUEST_ENTITY_TYPE);
	    ctsRequestCO.getEntityChargesCO().setEntityCommand(CoreCommonConstants.CHEQUEBOOK_ENTITY_TYPE);
	    ctsRequestCO.setOpt(get_pageRef());
	    if(NumberUtil.isEmptyDecimal(ctsRequestCO.getEntityChargesCO().getAccBranch())
		    || NumberUtil.isEmptyDecimal(ctsRequestCO.getEntityChargesCO().getAccCurrency())
		    || NumberUtil.isEmptyDecimal(ctsRequestCO.getEntityChargesCO().getAccGL())
		    || NumberUtil.isEmptyDecimal(ctsRequestCO.getEntityChargesCO().getAccCIF())
		    || NumberUtil.isEmptyDecimal(ctsRequestCO.getEntityChargesCO().getAccSL()))
	    {
		throw new BOException(MessageCodes.ACCOUNT_NUMBER_IS_INVALID);
	    }
	}
	catch (Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	
	return "loadChargesSection";
    }
    
    public String dependencyByPaymentType() throws BaseException
    {
	try
	{
	    fillSessionData();


	    ctsRequestCO = ctsRequestBO.dependencyByPaymentType(ctsRequestCO);
	    getAdditionalScreenParams().putAll(ctsRequestCO.getHmSysParam());
	    
	}
	catch (Exception e)
	{
	    ctsRequestCO.setPaymentType(null);
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    
    
    /**
     * @Paremeter: ctsRequestCO.ctsRequestVO.REQ_EXP_DATE
     * @throws BaseException
     */
    public String dependencyByExpiryDate() throws BaseException
    {
	try
	{
	    fillSessionData();
	    if(ctsRequestCO.getCtsRequestVO().getREQ_EXP_DATE() != null)
	    {
		ctsRequestCO = ctsRequestBO.dependencyByExpiryDate(ctsRequestCO);
	    }
	}
	catch(Exception e)
	{
	    ctsRequestCO.getCtsRequestVO().setREQ_EXP_DATE(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    /**
     * @Paremeter: ctsRequestCO.AmfVO.BRANCH_CODE
     * @throws BaseException
     */
    public String dependencyAccBranch() throws BaseException
    {
	try
	{
	    fillSessionData();
	    if(NumberUtil.isEmptyDecimal(ctsRequestCO.getAmfVO().getBRANCH_CODE()))
	    {
		if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
		{
		    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
		}
		ctsRequestCO.getAmfVO().setBRANCH_CODE(null);
	    }
	    else
	    {
		ctsRequestCO = ctsRequestBO.dependencyAccBranch(ctsRequestCO);
	    }
	}
	catch(Exception e)
	{
	    ctsRequestCO.getAmfVO().setBRANCH_CODE(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @Paremeter: ctsRequestCO.AmfVO.CURRENCY_CODE
     * @throws BaseException
     */
    public String dependencyAccCurrency() throws BaseException
    {
	try
	{
	    fillSessionData();
	    if(NumberUtil.isEmptyDecimal(ctsRequestCO.getAmfVO().getCURRENCY_CODE()))
	    {
		if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
		{
		    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
		}
		ctsRequestCO.getAmfVO().setCURRENCY_CODE(null);
	    }
	    else
	    {
		ctsRequestCO = ctsRequestBO.dependencyAccCurrency(ctsRequestCO);
	    }
	}
	catch(Exception e)
	{
	    ctsRequestCO.getAmfVO().setCURRENCY_CODE(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * @Paremeter: ctsRequestCO.AmfVO.GL_CODE
     * @throws BaseException
     */
    public String dependencyAccGl() throws BaseException
    {
	try
	{
	    fillSessionData();
	    if(NumberUtil.isEmptyDecimal(ctsRequestCO.getAmfVO().getGL_CODE()))
	    {
		if(CtsRequestConstant.PAYMENT_TYPE_IND_ACCOUNT.equals(ctsRequestCO.getPaymentType()))
		{
		    ctsRequestCO.getAmfVO().setCIF_SUB_NO(NumberUtil.emptyDecimalToNull(ctsRequestCO.getRequestCif()));
		}
		ctsRequestCO.getAmfVO().setGL_CODE(null);
	    }
	    else
	    {
		ctsRequestCO = ctsRequestBO.dependencyAccGl(ctsRequestCO);
	    }
	}
	catch(Exception e)
	{
	    ctsRequestCO.getAmfVO().setGL_CODE(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    

    public void setCtsRequestBO(CtsRequestBO ctsRequestBO)
    {
	this.ctsRequestBO = ctsRequestBO;
    }

    /**
     * @return the ctsRequestCO
     */
    public CtsRequestCO getCtsRequestCO()
    {
        return ctsRequestCO;
    }

    /**
     * @param ctsRequestCO the ctsRequestCO to set
     */
    public void setCtsRequestCO(CtsRequestCO ctsRequestCO)
    {
        this.ctsRequestCO = ctsRequestCO;
    }

    /**
     * @return the paymentTypeList
     */
    public List<SelectCO> getPaymentTypeList()
    {
        return paymentTypeList;
    }

    /**
     * @param paymentTypeList the paymentTypeList to set
     */
    public void setPaymentTypeList(List<SelectCO> paymentTypeList)
    {
        this.paymentTypeList = paymentTypeList;
    }
}
