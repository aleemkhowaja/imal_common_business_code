package com.path.actions.common.global360view.oneobligor;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.global360view.oneobligor.DashOneObligorBO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorCO;
import com.path.vo.common.global360view.oneobligor.DashOneObligorSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * OneObligorMaintAction.java used to
 */
public class DashOneObligorMaintAction extends BaseAction
{
    private DashOneObligorBO dashOneObligorBO;
    private DashOneObligorCO dashOneObligorCO = new DashOneObligorCO();
    private DashOneObligorSC dashOneObligorSC = new DashOneObligorSC();

    public Object getModel()
    {
	return dashOneObligorCO;

    }
/**
 * 
 * @return
 */
    public String loadOneObligorMaintPage()
    {
	try
	{
	    // To set the record readOnly if it is opened From 360 degree
	    if("1".equals(dashOneObligorCO.getIsLookUp()))
	    {
		set_recReadOnly("true");
	    }
	    if(!NumberUtil.isEmptyDecimal(dashOneObligorSC.getCifNo()))
	    {
		fillOneObligorForm();
		setCurrencyFormat();
	    }
	}

	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "oneObligorMaint";
    }

    /**
     * 
     * @param oneObligorBO
     */
    public void fillOneObligorForm()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    dashOneObligorSC.setCompCode(sessionCO.getCompanyCode());

	    dashOneObligorCO = dashOneObligorBO.fillOneObligorForm(dashOneObligorSC);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
    }
/**
 * This method is to Load the MoneyLaudOneOblgTrendsDetlsList.jsp
 * @return
 */
    public String loadMoneyLaudOneObligTrendsPage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	
	    set_showSmartInfoBtn("false");
	    dashOneObligorCO.getRifOBTVO().getOBLIGOR_CODE();
	    dashOneObligorCO.getCurrenciesVO().getCURRENCY_CODE();
	    
	    if(!NumberUtil.isEmptyDecimal(dashOneObligorCO.getCurrenciesVO().getCURRENCY_CODE()))
	    {
		CURRENCIESVO currencyVO = new CURRENCIESVO();
		currencyVO.setCOMP_CODE(sessionCO.getCompanyCode());
		currencyVO.setCURRENCY_CODE(dashOneObligorCO.getCurrenciesVO().getCURRENCY_CODE());
		currencyVO = returnCommonLibBO().returnCurrency(currencyVO);

		String currecnyFormatter = CommonMethods.currencyMask(currencyVO.getDECIMAL_POINTS());
		dashOneObligorCO.setCurrecnyFormatter(currecnyFormatter);
	    }
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadOneObligorGrid of OneObligorListAction");
	    handleException(e, null, null);
	}
	return "moneyLaudOneObligorTrendsList";
    }
/**
 * This method for setting the currency format for Limit and Estimated Gross Amount of Cash
 * volume in the OneObligorMaint.jsp
 */
    public void setCurrencyFormat()
    {
	try
	{
	    if(dashOneObligorCO != null)
	    {
		String currecnyFormatter = CommonMethods.currencyMask(dashOneObligorCO.getCurrenciesVO()
			.getDECIMAL_POINTS());
		SYS_PARAM_SCREEN_DISPLAYVO sysParamDisplay = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysParamDisplay.setDecFormat(currecnyFormatter);
		getAdditionalScreenParams().put("limit", sysParamDisplay);
		getAdditionalScreenParams().put("mlGrossAmount", sysParamDisplay);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);

	}
    }

    public void setDashOneObligorBO(DashOneObligorBO dashOneObligorBO)
    {
        this.dashOneObligorBO = dashOneObligorBO;
    }
    public DashOneObligorCO getDashOneObligorCO()
    {
        return dashOneObligorCO;
    }
    public void setDashOneObligorCO(DashOneObligorCO dashOneObligorCO)
    {
        this.dashOneObligorCO = dashOneObligorCO;
    }
    public DashOneObligorSC getDashOneObligorSC()
    {
        return dashOneObligorSC;
    }
    public void setDashOneObligorSC(DashOneObligorSC dashOneObligorSC)
    {
        this.dashOneObligorSC = dashOneObligorSC;
    }

 

  

 
   

}
