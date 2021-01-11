/**
 * 
 */
package com.path.actions.common.global360view;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.global360view.DashboardBO;
import com.path.bo.common.global360view.investments.DashInvestmentsBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.PMSPORTFOLIO_POSITION_TEMPVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.common.memo.MemoSC;
import com.path.bo.common.audit.AuditConstant;
import com.path.vo.common.audit.AuditRefCO;

import com.path.vo.core.csmfom.FomCO;


/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashboardDependencyAction.java used to
 */
public class DashboardDependencyAction extends RetailBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private MemoSC memoSC = new MemoSC();
    private DashboardCO dashboardCO = new DashboardCO();

    private DashboardBO dashboardBO;
    private DashInvestmentsBO dashInvestmentsBO;

    private PMSPORTFOLIO_POSITION_TEMPVO pmsPortfolioPostitionTmpVO = new PMSPORTFOLIO_POSITION_TEMPVO();

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * 
     * @date Apr 24, 2013
     * @return String
     * 
     */
    public String dashboardDependencyByCif()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    if(null == sessionCO.getCtsTellerVO())
	    {
		criteria.setAllowCifCreationMaskYN("1");
	    }
	    else
	    {
		criteria.setAllowCifCreationMaskYN(sessionCO.getCtsTellerVO().getALLOW_CIF_CREATION_MASK_YN());
	    }
	    
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    criteria.setCompCode(compCode);
//	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setLovType(FomConstant.CIF_STATUS_LOV_TYPE);
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setProgRef(criteria.getTraceProgRef());
	    if(dashboardCO.getCifVO() == null
		    || NumberUtil.emptyDecimalToNull(dashboardCO.getCifVO().getCIF_NO()) == null)
	    {
		dashboardCO = new DashboardCO();
	    }
	    else
	    {
		criteria.setCif_no(dashboardCO.getCifVO().getCIF_NO());
		dashboardCO = dashboardBO.dashboardDependCifById(criteria);
		//modified by abbas for Bug#682992, check on CifVO() instead of CO
		if(dashboardCO == null || dashboardCO.getCifVO() == null)
		{
		    throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);

		}
		else
		{

		    //Rania - ABSAI180073
		    CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
		    cifControlVO.setCOMP_CODE(compCode);
		    
		    cifControlVO = returnCommonLibBO().returnCifControlDetails(cifControlVO);
		    
		    if(cifControlVO != null && "1".equals(cifControlVO.getENABLE_SCORING_YN()))
		    {
			returnScoreValueDescription();
		    }
		    //
		    

		    criteria.setRestrBranchCode(sessionCO.getBranchCode());
		    int countRestricted = dashboardBO.dashboardCheckRestrictedCifById(criteria);
		    if(countRestricted < 1)
		    {
			throw new BOException(MessageCodes.NO_ACCESS_VIEW_ACCOUNT_CIF);
		    }
		    
		    if(dashboardCO.getCifVO() != null
			    && BigDecimal.ONE.equals(NumberUtil.emptyDecimalToZero(dashboardCO.getCifVO()
				    .getBLACK_LISTED())))
		    {
			dashboardCO.setCif_BlackList(getText("cifIsBlackListed_key"));
		    }

		    /**
		     * going to the common function in RetailBaseAction and
		     * check if there is any Memo.
		     */
		     MemoSC memoSC = new MemoSC();
		     memoSC.setCompCode(compCode);
		     memoSC.setAppType(MemoConstants.CSM_APP_TYPE);
		     memoSC.setForAccOrCif(MemoConstants.CIF);
		     memoSC.setCifNo(criteria.getCif_no());
		     checkForMemo(memoSC);
		     //Abdo TP#570325 19/03/2018	  
		     dashboardCO.getCifVO().setCOMP_CODE(compCode);
		     applyRetrieveAudit(AuditConstant.FOM_KEY_REF, dashboardCO.getCifVO(),
			     dashboardCO);
		     //added by abbas for Bug#682992
		     setAdditionalScreenParams(dashboardCO.getHm());
		}
	    }
	}
	catch(Exception ex)
	{
	    dashboardCO = new DashboardCO();
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String dashboardDependencyBySecurities()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    criteria.setCompCode(compCode);
	    criteria.setUserId(sessionCO.getUserName());
	    //added by bahaa for TP# 1042048
	    criteria.setRunningDate(sessionCO.getRunningDateRET());
	    
	    if(null == criteria.getSecurityName() || criteria.getSecurityName().isEmpty())
	    {
		pmsPortfolioPostitionTmpVO = new PMSPORTFOLIO_POSITION_TEMPVO();
	    }
	    else
	    {
		if(ConstantsCommon.DASH_ALL_SECURITIES.equals(criteria.getSecurityName()))
		{
		    pmsPortfolioPostitionTmpVO.setSECURITY_CODE1(BigDecimal.ZERO);
		    pmsPortfolioPostitionTmpVO.setSECURITY_CODE2(BigDecimal.ZERO);
		    pmsPortfolioPostitionTmpVO.setSECURITY_NAME(ConstantsCommon.DASH_ALL_SECURITIES);
		}
		else
		{
		    pmsPortfolioPostitionTmpVO = dashInvestmentsBO.dashInvestmentDependencyBySecurity(criteria);

		    if(pmsPortfolioPostitionTmpVO == null)
		    {
			throw new BOException(MessageCodes.INVALID_MISSING_CIF_NO);
		    }
		}
	    }
	}
	catch(Exception ex)
	{
	    dashboardCO = new DashboardCO();
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    
    /**
     * @author RaniaAlBitar
     * ABSAI180073
     */
    private void returnScoreValueDescription()
    {
	try
	{
	    FomCO fomCOTemp = new FomCO();
	    SessionCO sessionCO = returnSessionObject();
	    
	    dashboardCO.setLoginCompCode(sessionCO.getCompanyCode());
	    
	    fomCOTemp = dashboardBO.dependencyByScoreRiskValue(dashboardCO);
	    
	    dashboardCO.setScoreRiskDescription(fomCOTemp.getScoreRiskDescription());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }
    
    /**
     * @return the memoSC
     */
    public MemoSC getMemoSC()
    {
	return memoSC;
    }

    /**
     * @param memoSC the memoSC to set
     */
    public void setMemoSC(MemoSC memoSC)
    {
	this.memoSC = memoSC;
    }

    /**
     * @param dashboardBO the dashboardBO to set
     */
    public void setDashboardBO(DashboardBO dashboardBO)
    {
	this.dashboardBO = dashboardBO;
    }

    /**
     * @return the dashboardCO
     */
    public DashboardCO getDashboardCO()
    {
	return dashboardCO;
    }

    /**
     * @param dashboardCO the dashboardCO to set
     */
    public void setDashboardCO(DashboardCO dashboardCO)
    {
	this.dashboardCO = dashboardCO;
    }

    /**
     * @return the criteria
     */
    public DashboardSC getCriteria()
    {
	return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DashboardSC criteria)
    {
	this.criteria = criteria;
    }

    public void setDashInvestmentsBO(DashInvestmentsBO dashInvestmentsBO)
    {
	this.dashInvestmentsBO = dashInvestmentsBO;
    }

    public PMSPORTFOLIO_POSITION_TEMPVO getPmsPortfolioPostitionTmpVO()
    {
	return pmsPortfolioPostitionTmpVO;
    }

    public void setPmsPortfolioPostitionTmpVO(PMSPORTFOLIO_POSITION_TEMPVO pmsPortfolioPostitionTmpVO)
    {
	this.pmsPortfolioPostitionTmpVO = pmsPortfolioPostitionTmpVO;
    }
}
