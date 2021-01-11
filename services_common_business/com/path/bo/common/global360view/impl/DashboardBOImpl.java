/**
 * 
 */
package com.path.bo.common.global360view.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.fms.limitscommon.FmsLimitsCommonBO;
import com.path.bo.common.global360view.DashboardBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.dao.common.global360view.DashboardDAO;
import com.path.dbmaps.vo.AMFSUPPLEMENTVO;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.vo.core.csmfom.FomCO;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.fms.limitscommon.FmsLimitsInputCO;
import com.path.vo.common.global360view.DashAccDtlJvsCO;
import com.path.vo.common.global360view.DashAccDtlTrxCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashPassbookCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.common.AccRestrictedSC;
import com.path.vo.core.csmfom.FomCO;
import com.path.vo.core.dues.DuesManagementSC;
import com.path.vo.core.trxmgnt.AccountPositionCO;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashboardBOImpl.java used to
 */
public class DashboardBOImpl extends RetailBaseBO implements DashboardBO
{
    private DashboardDAO dashboardDAO;
    private FmsLimitsCommonBO fmsLimitsCommonBO;

    /**
     * return the List of data that will be in Financing Deals Grid
     * 
     * @author marwanmaddah
     * @date Apr 23, 2013
     * @param criteria
     * @return List<DashboardCO>
     * 
     */
    public List<DashboardCO> returnFinancingDealsList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.returnFinancingDealsList(criteria);
    }

    /**
     * 
     * @date Apr 24, 2013
     * @param criteria
     * @return DashboardCO
     * @throws BaseException DashboardCO
     * 
     */
    public DashboardCO dashboardDependCifById(DashboardSC criteria) throws BaseException
    {   //modified by abbas for Bug#682992, set readonly logintype
	DashboardCO dashboardCO = new DashboardCO();
	dashboardCO = dashboardDAO.dashboardDependCifById(criteria);
	if(dashboardCO != null)
	{
//	    applyDynScreenDisplay("loginType", null, ConstantsCommon.ACTION_TYPE_READONLY, "1", dashboardCO.getHm(), null);
	    
	    //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

	    String readOnly = "1";
	    if(dashboardCO != null && dashboardCO.getATTORNEY_OUTSIDE_COUNTRY_YN() != null
		    && "Y".equals(dashboardCO.getATTORNEY_OUTSIDE_COUNTRY_YN()))
	    {
		readOnly = "0";
	    }
	    applyDynScreenDisplay("power_of_attroney", null, ConstantsCommon.ACTION_TYPE_READONLY, readOnly,
		    dashboardCO.getHm(), null);
	  //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

	}
	return dashboardCO;
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int accountDetailsListCount(DashboardSC criteria) throws BaseException
    {

	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(criteria.getCif_no());
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCif(criteria.getCif_no());
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(999));
	accRestrictedSC.setAppName(criteria.getAppName());
	accRestrictedSC.setUserId(criteria.getUserId());
	accRestrictedSC.setCompCode(criteria.getCompCode());
	accRestrictedSC.setBranchCode(criteria.getBranchCode());
	accRestrictedSC.setProgRef(criteria.getProgRef());
	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	return dashboardDAO.accountDetailsListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccountDetailsCO> accountDetailsList(DashboardSC criteria) throws BaseException
    {
	List<DashAccountDetailsCO> lst = dashboardDAO.accountDetailsList(criteria);
	for(DashAccountDetailsCO resultCO : lst)
	{
	    DuesManagementSC duesManagementSC = new DuesManagementSC();
	    
	    duesManagementSC.setCompCode(resultCO.getLoginCompCode()) ;
	    duesManagementSC.setBranchCode(resultCO.getBranchCode()) ;
	    duesManagementSC.setBaseCurrencyCode(criteria.getBaseCurrencyCode()) ;
	    duesManagementSC.setRunningDate(criteria.getRunningDate()) ;
	    
	    duesManagementSC.setDebitAccBr(resultCO.getBranchCode()) ;
	    duesManagementSC.setDebitAccCy(resultCO.getCurrencyCode());
	    duesManagementSC.setDebitAccGL(resultCO.getGlCode()) ;
	    duesManagementSC.setDebitAccCIF(resultCO.getCifCode()) ;
	    duesManagementSC.setDebitAccSL(resultCO.getSlNo()) ;
	    duesManagementSC.setTellerCode(criteria.getTellerCode());
	    duesManagementSC.setDueStatus("1") ;
	    duesManagementSC.setAction("A");
	    coreCommonProcedureBO.returnDuesAmountAcc( duesManagementSC);
	    BigDecimal dueCode = duesManagementSC.getDueCode();
	    resultCO.setDueCode(dueCode);
	    
	    // Added by nancy - 30/01/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
	    //postdated deposit cheques ,postdated withdrawal cheques and  settlement cheques balances 
	    String formatByCurrencyDecimalPoints = CommonMethods.currencyMask(resultCO.getDecimalPoints());
	    resultCO.setFormatByCurrencyDecimalPoints(formatByCurrencyDecimalPoints);
	    coreCommonProcedureBO.returnPostdatedChequeBalances( duesManagementSC);
	    BigDecimal postDatedWidrawalBal, postDatedDepositBal,settlementBal;
	    postDatedWidrawalBal = duesManagementSC.getPostDatedWidrawalBal();
	    postDatedDepositBal  = duesManagementSC.getPostDatedDepositBal();
	    settlementBal 	 = duesManagementSC.getSettlementBal();
	    resultCO.setPostDatedWithdrawalchequesBalance(postDatedWidrawalBal);
	    resultCO.setPostDatedDepositchequesBalance(postDatedDepositBal);
	    resultCO.setSettlementChequesBalance(settlementBal);
	    
	    //Active W/D amount
	    duesManagementSC.setTrsNo(BigDecimal.ZERO);
	    duesManagementSC.setTrxBranch(BigDecimal.ZERO);
	    coreCommonProcedureBO.returnActiveWithAmountAcc( duesManagementSC);
	    BigDecimal activeWithAmountAcc = duesManagementSC.getActiveWidrawalAmount();
	    resultCO.setActiveWdBalance(activeWithAmountAcc);
	    
	    // Investment Bal
	    /*
	     * Set Account Details
	    */
	    AMFVO amfVO = new AMFVO();
	    amfVO.setCOMP_CODE(resultCO.getLoginCompCode());
	    amfVO.setBRANCH_CODE(resultCO.getBranchCode());
	    amfVO.setCURRENCY_CODE(resultCO.getCurrencyCode());
	    amfVO.setGL_CODE(resultCO.getGlCode());
	    amfVO.setCIF_SUB_NO(resultCO.getCifCode());
	    amfVO.setSL_NO(resultCO.getSlNo());
	    amfVO = (AMFVO)genericDAO.selectByPK(amfVO);
	    if(amfVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_ACCOUNT);
	    }
	    AccountPositionCO accountPositionCO = new AccountPositionCO();
	    accountPositionCO.setLoginCompCode(resultCO.getLoginCompCode());
	    accountPositionCO.setBaseCurrencyCode(resultCO.getBranchCode());
	    accountPositionCO.getAmfVO().setCUR_AC_BR(amfVO.getBRANCH_CODE());
	    accountPositionCO.getAmfVO().setCUR_AC_CY(amfVO.getCURRENCY_CODE());
	    accountPositionCO.getAmfVO().setCUR_AC_GL(amfVO.getGL_CODE());
	    accountPositionCO.getAmfVO().setCUR_AC_CIF(amfVO.getCIF_SUB_NO());
	    accountPositionCO.getAmfVO().setCUR_AC_SL(amfVO.getSL_NO());
	    accountPositionCO.setCtsTrxTypeVO(new CTSTRXTYPEVO());
	    accountPositionCO.getCtsTrxTypeVO().setBLOCK_ACTIVE_WITH(ConstantsCommon.ZERO);
	    BigDecimal investmentBalance = new BigDecimal(coreCommonProcedureBO.returnAvlBalBR(accountPositionCO).doubleValue()).negate();
	    resultCO.setInvestmentBalance(investmentBalance);
	    // end nancy
	   
	}
	return lst;
    }

    
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int accDtlJvsListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.accDtlJvsListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccDtlJvsCO> accDtlJvsList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.accDtlJvsList(criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int accDtlTrxListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.accDtlTrxListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccDtlTrxCO> accDtlTrxList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.accDtlTrxList(criteria);
    }

    /**
     * 
     * @author marwanmaddah
     * @date Jun 6, 2013
     * @param criteria
     * @return
     * @throws BaseException DashAccDtlJvsCO
     * 
     */
    public DashAccountDetailsCO returnAccountData(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.returnAccountData(criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int passbooksListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.passbooksListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashPassbookCO> passbooksList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.passbooksList(criteria);
    }

    /**
     * 
     * @date Jun 19, 2013
     * @param dashboardSC
     * @return
     * @throws BaseException DashboardCO
     * 
     */
    public DashboardCO returnMainData(DashboardSC dashboardSC) throws BaseException
    {
	FmsLimitsInputCO  fmsLimitsInputCO = new  FmsLimitsInputCO();
	fmsLimitsInputCO.setCompanyCode(dashboardSC.getCompCode());
	fmsLimitsInputCO.setCifCode(dashboardSC.getCif_no());
	if(StringUtil.isEmptyString(dashboardSC.getParentCif()))
	{
	    boolean isParentCif = fmsLimitsCommonBO.checkParentCifOrNot(fmsLimitsInputCO);
	    
	    if(isParentCif)
	    {
		throw new BOException(MessageCodes.CIF_IS_PARENT_CIF_HAVING_CHILD_CIF,
			ConstantsCommon.CONFIRM_MSG_TYPE);
	    }
	}
	
	dashboardDAO.deleteFmsSubdidiaryCifs(dashboardSC);
	if("true".equals(dashboardSC.getParentCif()))
	{
	    fmsLimitsInputCO.setBranchCode(dashboardSC.getAccBr());
	    fmsLimitsInputCO.setAppName(dashboardSC.getAppName());
	    fmsLimitsInputCO.setUserId(dashboardSC.getUserId());
	    fmsLimitsInputCO.setSysDate(dashboardSC.getRunningDate());
	    fmsLimitsCommonBO.execProc_P_FMS_INSERT_SUBSIDIARY_CIFS(fmsLimitsInputCO);
	}
	
	if(commonLibBO.returnIsSybase() == 1)
	     {
	       dashboardDAO.dropDashTables();
	       dashboardDAO.createDashTables();
	     }
	//PATH130194
	//We are deleting the LoginBranch and then insert it in CIFVIEW_TMP Table because we are using the loginBranchCode to get the tellerCode in P_FILL_DAHBOARD_COUNT Proc
	//This login branch code is not sent in case we choose all branches 
	dashboardDeleteLoginBranchCode(dashboardSC);
	dashboardInsertLoginBranchCode(dashboardSC);
	
	//PATH130194
	

	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(dashboardSC.getCif_no());
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCif(dashboardSC.getCif_no());
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(999));
	accRestrictedSC.setAppName(dashboardSC.getAppName());
	accRestrictedSC.setUserId(dashboardSC.getUserId());
	accRestrictedSC.setCompCode(dashboardSC.getCompCode());
	accRestrictedSC.setBranchCode(dashboardSC.getBranchCode());
	accRestrictedSC.setProgRef("GLBVIEW001");
	coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	dashboardSC.setProgRef("GLBVIEW001");
	dashboardSC = dashboardDAO.fillDashboardCounts(dashboardSC);
	//Abdo TP#489043 02/03/2017
	if(NumberUtil.nullToZero(dashboardSC.getErrorCode()).compareTo(BigDecimal.ZERO) < 0)
	{
	    throw new BOException(dashboardSC.getErrorMessage());
	}
	//End Abdo
	// DBU191081 Muhammed Anas Start
	DashboardCO dashboardCO = new DashboardCO();
	dashboardSC.setShowCumulativeDataOfParentCifYN(ConstantsCommon.YES);
	if(ConstantsCommon.YES.equals(dashboardSC.getShowCumulativeDataOfParentCifYN()))
	{
	    BigDecimal parentCif = dashboardSC.getCif_no();

	    // Financed Deals
	    BigDecimal totalAssetAmt = BigDecimal.ZERO;
	    BigDecimal settledAssetAmt = BigDecimal.ZERO;
	    BigDecimal outstandAssetAmt = BigDecimal.ZERO;
	    BigDecimal profitAssetAmt = BigDecimal.ZERO;
	    BigDecimal overdueAssetAmt = BigDecimal.ZERO;
	    BigDecimal guaranteesAssetAmt = BigDecimal.ZERO;
	    BigDecimal collateralAssetAmt = BigDecimal.ZERO;
	    BigDecimal promNoteAssetAmt = BigDecimal.ZERO;

	    BigDecimal totalLiabAmt = BigDecimal.ZERO;
	    BigDecimal settledLiabAmt = BigDecimal.ZERO;
	    BigDecimal outstandLiabAmt = BigDecimal.ZERO;
	    BigDecimal profitLiabAmt = BigDecimal.ZERO;
	    BigDecimal overdueLiabAmt = BigDecimal.ZERO;
	    BigDecimal guaranteesLiabAmt = BigDecimal.ZERO;
	    BigDecimal collateralLiabAmt = BigDecimal.ZERO;
	    BigDecimal promNoteLiabAmt = BigDecimal.ZERO;

	    BigDecimal totalIliabAmt = BigDecimal.ZERO;
	    BigDecimal settledIliabAmt = BigDecimal.ZERO;
	    BigDecimal outstandIliabAmt = BigDecimal.ZERO;
	    BigDecimal profitIliabAmt = BigDecimal.ZERO;
	    BigDecimal overdueIliabAmt = BigDecimal.ZERO;
	    BigDecimal guaranteesIliabAmt = BigDecimal.ZERO;
	    BigDecimal collateralIliabAmt = BigDecimal.ZERO;
	    BigDecimal promNoteIliabAmt = BigDecimal.ZERO;

	    // Treasury
	    BigDecimal treasForexAmt = BigDecimal.ZERO;
	    BigDecimal treasMarketAmt = BigDecimal.ZERO;
	    BigDecimal treasDerivAmt = BigDecimal.ZERO;

	    List<DashboardCO> childCifList = dashboardDAO.returnChildCifList(dashboardSC);
	    for(DashboardCO cifList : childCifList)
	    {
		dashboardSC.setCif_no(cifList.getChildCif());
		dashboardCO = dashboardDAO.returnMainData(dashboardSC);

		if(dashboardCO != null)
		{
		    totalAssetAmt = totalAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalAssetAmt()));
		    settledAssetAmt = settledAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledAssetAmt()));
		    outstandAssetAmt = outstandAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandAssetAmt()));
		    profitAssetAmt = profitAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitAssetAmt()));
		    overdueAssetAmt = overdueAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueAssetAmt()));
		    guaranteesAssetAmt = guaranteesAssetAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getGuaranteesAssetAmt()));
		    collateralAssetAmt = collateralAssetAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getCollateralAssetAmt()));
		    promNoteAssetAmt = promNoteAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getPromNoteAssetAmt()));

		    totalLiabAmt = totalLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalLiabAmt()));
		    settledLiabAmt = settledLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledLiabAmt()));
		    outstandLiabAmt = outstandLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandLiabAmt()));
		    profitLiabAmt = profitLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitLiabAmt()));
		    overdueLiabAmt = overdueLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueLiabAmt()));
		    guaranteesLiabAmt = guaranteesLiabAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getGuaranteesLiabAmt()));
		    collateralLiabAmt = collateralLiabAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getCollateralLiabAmt()));
		    promNoteLiabAmt = promNoteLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getCollateralLiabAmt()));

		    totalIliabAmt = totalIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalIliabAmt()));
		    settledIliabAmt = settledIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledIliabAmt()));
		    outstandIliabAmt = outstandIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandIliabAmt()));
		    profitIliabAmt = profitIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitIliabAmt()));
		    overdueIliabAmt = overdueIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueIliabAmt()));
		    guaranteesIliabAmt = guaranteesIliabAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getGuaranteesIliabAmt()));
		    collateralIliabAmt = collateralIliabAmt
			    .add(NumberUtil.nullToZero(dashboardCO.getCollateralIliabAmt()));
		    promNoteIliabAmt = promNoteIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getPromNoteIliabAmt()));

		    treasForexAmt = treasForexAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasForexAmt()));
		    treasMarketAmt = treasMarketAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasMarketAmt()));
		    treasDerivAmt = treasDerivAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasDerivAmt()));
		}

	    }
	    dashboardSC.setCif_no(parentCif);
	    dashboardCO = dashboardDAO.returnMainData(dashboardSC);

	    dashboardCO.setTotalAssetAmt(totalAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalAssetAmt())));
	    dashboardCO
		    .setSettledAssetAmt(settledAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledAssetAmt())));
	    dashboardCO.setOutstandAssetAmt(
		    outstandAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandAssetAmt())));
	    dashboardCO.setProfitAssetAmt(profitAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitAssetAmt())));
	    dashboardCO
		    .setOverdueAssetAmt(overdueAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueAssetAmt())));
	    dashboardCO.setGuaranteesAssetAmt(
		    guaranteesAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getGuaranteesAssetAmt())));
	    dashboardCO.setCollateralAssetAmt(
		    collateralAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getCollateralAssetAmt())));
	    dashboardCO.setPromNoteAssetAmt(
		    promNoteAssetAmt.add(NumberUtil.nullToZero(dashboardCO.getPromNoteAssetAmt())));

	    dashboardCO.setTotalLiabAmt(totalLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalLiabAmt())));
	    dashboardCO.setSettledLiabAmt(settledLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledLiabAmt())));
	    dashboardCO
		    .setOutstandLiabAmt(outstandLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandLiabAmt())));
	    dashboardCO.setProfitLiabAmt(profitLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitLiabAmt())));
	    dashboardCO.setOverdueLiabAmt(overdueLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueLiabAmt())));
	    dashboardCO.setGuaranteesLiabAmt(
		    guaranteesLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getGuaranteesLiabAmt())));
	    dashboardCO.setCollateralLiabAmt(
		    collateralLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getCollateralLiabAmt())));
	    dashboardCO
		    .setPromNoteLiabAmt(promNoteLiabAmt.add(NumberUtil.nullToZero(dashboardCO.getCollateralLiabAmt())));

	    dashboardCO.setTotalIliabAmt(totalIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getTotalIliabAmt())));
	    dashboardCO
		    .setSettledIliabAmt(settledIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getSettledIliabAmt())));
	    dashboardCO.setOutstandIliabAmt(
		    outstandIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getOutstandIliabAmt())));
	    dashboardCO.setProfitIliabAmt(profitIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getProfitIliabAmt())));
	    dashboardCO
		    .setOverdueIliabAmt(overdueIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getOverdueIliabAmt())));
	    dashboardCO.setGuaranteesIliabAmt(
		    guaranteesIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getGuaranteesIliabAmt())));
	    dashboardCO.setCollateralIliabAmt(
		    collateralIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getCollateralIliabAmt())));
	    dashboardCO.setPromNoteIliabAmt(
		    promNoteIliabAmt.add(NumberUtil.nullToZero(dashboardCO.getPromNoteIliabAmt())));

	    dashboardCO.setTreasForexAmt(treasForexAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasForexAmt())));
	    dashboardCO.setTreasMarketAmt(treasMarketAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasMarketAmt())));
	    dashboardCO.setTreasDerivAmt(treasDerivAmt.add(NumberUtil.nullToZero(dashboardCO.getTreasDerivAmt())));
	}
	else
	{
	    dashboardCO = dashboardDAO.returnMainData(dashboardSC);
	}
	// DBU191081 Muhammed Anas End

    return dashboardCO;
    }


    
    /**
     * PATH130194 
     * @param dashboardCO
     * @return
     * This method is added to check if the current user is restricted from viewing certain account statuses
     * if yes a red warning message is displayed 
     * @throws BaseException 
     */
    
    public DashboardCO returnHiddenAccStatusesCount(DashboardCO dashboardCO) throws BaseException
    {
	DashboardSC dashboardSC = new DashboardSC();
	
	dashboardSC.setCompCode(dashboardCO.getLoginCompCode());
	dashboardSC.setBranchCode(dashboardCO.getLoginBraCode());
	dashboardSC.setTellerCode(dashboardCO.getLoginTellerCode());
	
	int count = dashboardDAO.returnHiddenAccStatusesCount(dashboardSC);
	
	if(count > 0)
	{
	    dashboardCO.setUserRestrictionOnCIFDetls("true");
	}
	else
	{
	    dashboardCO.setUserRestrictionOnCIFDetls("false");
	}
	
	return dashboardCO;
    }
    
    
    /**
     * @return the dashboardDAO
     */
    public DashboardDAO getDashboardDAO()
    {
	return dashboardDAO;
    }

    /**
     * @param dashboardDAO the dashboardDAO to set
     */
    public void setDashboardDAO(DashboardDAO dashboardDAO)
    {
	this.dashboardDAO = dashboardDAO;
    }

    public BigDecimal fetchFinancialApprovedLinesAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialApprovedLinesAmountSum(criteria);
    }

    public BigDecimal fetchFinancialBlockedAndSuspendedAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialBlockedAndSuspendedAmountSum(criteria);
    }

    public BigDecimal fetchFinancialCollateralsAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialCollateralsAmountSum(criteria);
    }

    public BigDecimal fetchFinancialDrawDownsAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialDrawDownsAmountSum(criteria);
    }

    public BigDecimal fetchFinancialGuarantorAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialGuarantorAmountSum(criteria);
    }

    public BigDecimal fetchFinancialNewApplicationsAmountSum(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.fetchFinancialNewApplicationsAmountSum(criteria);
    }

    @Override
    public DashboardCO returnDashAccountMaintDetail(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.returnDashAccountMaintDetail(criteria);
    }

    @Override
    public List duesForAccList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.duesForAccList(criteria);
    }

    @Override
    public Integer duesForAccListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.duesForAccListCount(criteria);
    }

    public List<AMFSUPPLEMENTVO> getAmfSupplement(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.getAmfSupplement(criteria);
    }
    
    
    //PATH130194
    public void dashboardDeleteLoginBranchCode(DashboardSC dashboardSC)throws BaseException
    {
	dashboardDAO.dashboardDeleteLoginBranchCode(dashboardSC);
    }
    //PATH130194
    public void dashboardInsertLoginBranchCode(DashboardSC dashboardSC)throws BaseException
    {
	dashboardDAO.dashboardInsertLoginBranchCode(dashboardSC);
    }
    // added by nancy -02/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public int postDatedChqListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.postDatedChqListCount(criteria);
    }
    public List<DashChequesServicesCO> postDatedChqListList(DashboardSC criteria) throws BaseException
    {
	 List<DashChequesServicesCO> lst = dashboardDAO.postDatedChqListList(criteria);
	 return lst;
    }
    //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

    public int returnDashboardSmsSubscriptionListCount(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.returnDashboardSmsSubscriptionListCount(criteria);
    }
    public List returnDashboardSmsSubscriptionList(DashboardSC criteria) throws BaseException
    {
	return dashboardDAO.returnDashboardSmsSubscriptionList(criteria);
    }
    //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

 
    public int dashboardCheckRestrictedCifById(DashboardSC criteria) throws BaseException
    {
	DashboardCO dashboardCO = new DashboardCO();
	Integer count = dashboardDAO.dashboardCheckRestrictedCifById(criteria);
	

	return count.intValue();
    }
    
    public FomCO dependencyByScoreRiskValue(DashboardCO dashboardCO) throws BaseException
    {
	List<CIFCONTROL_DEFINE_SCORE_RANGEVO> selCOs = dashboardDAO.dashboardReturnScoreRiskDescriptions(dashboardCO);
	FomCO fomCO = new FomCO();
	fomCO.setCifExtendedVO(new CIF_EXTENDEDVO());
	String scoreRiskDesc = "";
	
	/*if(selCOs.size() < 1)
	{
	    throw new BOException(MessageCodes.INVALID_SCORE_CANNOT_PROCEED);
	}*/
	
	CIFCONTROLVO cifControlVO = new CIFCONTROLVO();
	cifControlVO.setCOMP_CODE(dashboardCO.getLoginCompCode());
	
	cifControlVO = commonLibBO.returnCifControlDetails(cifControlVO);
	
	if(cifControlVO != null && dashboardCO.getScoreRiskValue() != null && selCOs.size() > 0)
	{
	    if(StringUtil.nullEmptyToValue(cifControlVO.getSCORE_DISPLAY_LIST(), "S").equals(FomElementsConstant.SCORE_DISPLAY_S))
	    {
		scoreRiskDesc = selCOs.get(0).getRISK_LEVEL();
	    }
	    else if(StringUtil.nullEmptyToValue(cifControlVO.getSCORE_DISPLAY_LIST(), "S").equals(FomElementsConstant.SCORE_DISPLAY_V))
	    {
		scoreRiskDesc = dashboardCO.getScoreRiskValue().toString();
	    }
	    else if(StringUtil.nullEmptyToValue(cifControlVO.getSCORE_DISPLAY_LIST(), "S").equals(FomElementsConstant.SCORE_DISPLAY_B))
	    {
		scoreRiskDesc = dashboardCO.getScoreRiskValue().toString().concat(" - ".concat(selCOs.get(0).getRISK_LEVEL().toString()));
	    }
	    
	    fomCO.setScoreRiskDescription(scoreRiskDesc);
	}
	
	return fomCO;
    }

    public FmsLimitsCommonBO getFmsLimitsCommonBO()
    {
        return fmsLimitsCommonBO;
    }

    public void setFmsLimitsCommonBO(FmsLimitsCommonBO fmsLimitsCommonBO)
    {
        this.fmsLimitsCommonBO = fmsLimitsCommonBO;
    }

}
