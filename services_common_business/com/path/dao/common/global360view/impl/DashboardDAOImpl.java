/**
 * 
 */
package com.path.dao.common.global360view.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dao.common.global360view.DashboardDAO;
import com.path.dbmaps.vo.AMFSUPPLEMENTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.global360view.DashAccDtlJvsCO;
import com.path.vo.common.global360view.DashAccDtlTrxCO;
import com.path.vo.common.global360view.DashAccountDetailsCO;
import com.path.vo.common.global360view.DashChequesServicesCO;
import com.path.vo.common.global360view.DashPassbookCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashboardDAOImpl.java used to
 */
public class DashboardDAOImpl extends BaseDAO implements DashboardDAO 
{
    /**
     * 
     * @date   Apr 23, 2013
     * @param criteria
     * @return List<DashboardCO>
     * @throws DAOException
     *
     */
    public List<DashboardCO> returnFinancingDealsList(DashboardSC criteria) throws DAOException
    {
	return new ArrayList<DashboardCO>();
    }
    
    /**
     * 
     */
    public DashboardCO dashboardDependCifById(DashboardSC criteria) throws DAOException
    {
	return (DashboardCO)getSqlMap().queryForObject("dashboardMapper.dahboardDependCifById", criteria);
    }
    /**
     * 
     * @date   Jun 3, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int accountDetailsListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accountDetailsListMap");
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.accountDetailsListCount", criteria)).intValue();
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccountDetailsCO> accountDetailsList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accountDetailsListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.accountDetailsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.accountDetailsList", criteria, criteria.getRecToskip(),criteria.getNbRec());
	}
    }    
    /**
     * 
     * @date   Jun 3, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int accDtlJvsListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accDtlJvsListMap");
	return((Integer) getSqlMap().queryForObject("dashboardMapper.accDtlJvsListCount", criteria)).intValue();
    }
    
    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccDtlJvsCO> accDtlJvsList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accDtlJvsListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.accDtlJvsList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.accDtlJvsList", criteria, criteria.getRecToskip(),criteria.getNbRec());
	}
    }
    /**
     * 
     * @date   Jun 3, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int accDtlTrxListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accDtlTrxListMap");
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.accDtlTrxListCount", criteria)).intValue();
    }
    
    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashAccDtlTrxCO> accDtlTrxList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.accDtlTrxListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.accDtlTrxList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.accDtlTrxList", criteria, criteria.getRecToskip(),criteria.getNbRec());
	}
    }
    /**
     * 
     * @date   Jun 3, 2013
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int passbooksListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.passbooksListMap");
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.passbooksListCount", criteria)).intValue();
    }
    
    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List<DashPassbookCO> passbooksList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.passbooksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.passbooksList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.passbooksList", criteria, criteria.getRecToskip(),criteria.getNbRec());
	}
    }
    
    /**
     * 
     * @date   Jun 19, 2013
     * @param dashboardSC
     * @return
     * @throws DAOException DashboardCO
     *
     */
    public DashboardCO returnMainData(DashboardSC criteria) throws DAOException
    {
	return (DashboardCO)getSqlMap().queryForObject("dashboardMapper.returnMainData", criteria);
    }
    /**
     * 
     * @date   Jun 6, 2013
     * @param criteria
     * @return
     * @throws DAOException DashAccDtlJvsCO
     *
     */
    public DashAccountDetailsCO returnAccountData(DashboardSC criteria) throws DAOException
    {
	return (DashAccountDetailsCO)getSqlMap().queryForObject("dashboardMapper.returnAccountData", criteria);
    }

	public BigDecimal fetchFinancialApprovedLinesAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_APPROVED_LINES", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}

	public BigDecimal fetchFinancialBlockedAndSuspendedAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_BLOCKED_AND_SUSPENDED_AMOUNT", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}

	public BigDecimal fetchFinancialCollateralsAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_COLLATERALS", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}

	public BigDecimal fetchFinancialDrawDownsAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_DRAWDOWNS", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}

	public BigDecimal fetchFinancialGuarantorAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_GUARANTOR", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}

	public BigDecimal fetchFinancialNewApplicationsAmountSum(DashboardSC criteria) throws DAOException
	{
		BigDecimal amt = BigDecimal.ZERO;
		Object obj = getSqlMap().queryForObject("dashFMSMapper.sum_NEW_APPLICATIONS", criteria);
		if(obj!=null)
		{
			amt = (BigDecimal) obj;
		}
		return amt;
	}
	
	public DashboardSC fillDashboardCounts(DashboardSC criteria) throws DAOException
	{
	    //Abdo TP#489043 02/03/2017
	   // getSqlMap().update("dashboardMapper.fillDashboardCounts", criteria);
	    try
	        {
		 getSqlMap().update("dashboardMapper.fillDashboardCounts", criteria);
		 criteria.setErrorMessage(StringUtil.replaceProcedureMessage(criteria
	                .getErrorMessage()));
	        }
	        catch(Exception e)
	        {
	            throw new DAOException("Error in P_FILL_DASHBOARD_COUNTS " + e.getMessage(), e);
	        }
	        return criteria;
	   //End Abdo
	}

	@Override
	public DashboardCO returnDashAccountMaintDetail(DashboardSC criteria) throws DAOException
	{
	    criteria.setCompCode(BigDecimal.ONE);
	    return (DashboardCO) getSqlMap().queryForObject("dashboardMapper.returnDashAccountMaintDetail", criteria);
	}
	
    @Override
    public Integer duesForAccListCount(DashboardSC criteria) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.duesForAccListCount", criteria));
    }

    @Override
    public List duesForAccList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.duesForAccList_map");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.duesForAccList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.duesForAccList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    public List<AMFSUPPLEMENTVO> getAmfSupplement (DashboardSC criteria) throws DAOException
	{
	 
	    return (ArrayList) getSqlMap().queryForList("dashboardMapper.getAmfSupplement", criteria);
	}
    public void dropDashTables()
    {
	try
	{
	    
	    
	    getSqlMap().update("dashboardMapper.dropDashTables","");
	}
	catch(Exception e)
	{
	    log.info("No hash Table to Drop");
	    /*
	     * the try catch block is added here since in Sybase we can't check
	     * on the existence of the Hash table before creating it, but we
	     * want to continue normally even if the drop was not successful
	     */

	}

    }
    public void createDashTables()
    {
	try
	{
		getSqlMap().update("coreCommonProcedureMapper.commitTrans", null);
		getSqlMap().update("dashboardMapper.createDashTables","");
	}
	catch(Exception e)
	{
	    log.info("Unable to Create Hash Table CTSTRS_TMP ");
	    /*
	     * the try catch block is added here since in Sybase we can't check
	     * on the existence of the Hash table before creating it, but we
	     * want to continue normally even if the drop was not successful
	     */

	}

    }
    
    
    //PATH130194
    public int returnHiddenAccStatusesCount(DashboardSC dashboardSC) throws DAOException
    {
	return((Integer) getSqlMap().queryForObject("dashboardMapper.returnHiddenAccStatusesCount", dashboardSC)).intValue();
	
    }
  //PATH130194
    public void dashboardDeleteLoginBranchCode(DashboardSC dashboardSC)throws DAOException
    {
	 getSqlMap().delete("dashboardMapper.dashboardDeleteLoginBranchCode",dashboardSC);
    }
  //PATH130194
    public void dashboardInsertLoginBranchCode(DashboardSC dashboardSC)throws DAOException
    {
	 getSqlMap().delete("dashboardMapper.dashboardInsertLoginBranchCode",dashboardSC);
    }
    
    public int dashboardCheckRestrictedCifById(DashboardSC criteria) throws DAOException
    {
	return((Integer) getSqlMap().queryForObject("dashboardMapper.dashboardCheckRestrictedCifById", criteria)).intValue();
    }
    
  //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

    public int returnDashboardSmsSubscriptionListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.resDashSmsSubscriptionListMap");
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.returnDashboardSmsSubscriptionListCount", criteria)).intValue();
    }
    public List returnDashboardSmsSubscriptionList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.resDashSmsSubscriptionListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.returnDashboardSmsSubscriptionList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.returnDashboardSmsSubscriptionList", criteria, criteria.getRecToskip(), criteria.getNbRec());
	}
    }
  //806304- Adding CIF Ranking, KYC status, Internal POA, and SMS subscription in 360 degrees view screen

    public List dashboardReturnScoreRiskDescriptions(DashboardCO dashboardCO) throws DAOException
    {
	return getSqlMap().queryForList("dashboardMapper.dashboardReturnScoreRiskDescriptions", dashboardCO);
    }
        
    // added by nancy - 02/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public int postDatedChqListCount(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.postDatedChqLisMap");
	return ((Integer) getSqlMap().queryForObject("dashboardMapper.postDatedChqListCount", criteria)).intValue();
    }
    public List<DashChequesServicesCO> postDatedChqListList(DashboardSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashboardMapper.postDatedChqLisMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashboardMapper.postDatedChqList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashboardMapper.postDatedChqList", criteria, criteria.getRecToskip(),criteria.getNbRec());
	}
    }
    // end nancy

    // DBU191081 Muhammed Anas Start
    @Override
    public List<DashboardCO> returnChildCifList(DashboardSC dashboardSC) throws DAOException
    {
	return (ArrayList) getSqlMap().queryForList("dashboardMapper.returnChildCifList", dashboardSC);
    }
    // DBU191081 Muhammed Anas End

    // DBU191081 Rakan Start
    public void deleteFmsSubdidiaryCifs(DashboardSC dashboardSC) throws DAOException
    {
	getSqlMap().delete("dashboardMapper.deleteFmsSubdidiaryCifs", dashboardSC);
    }
    // DBU191081 Rakan Start

}